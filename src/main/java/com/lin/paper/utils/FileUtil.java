package com.lin.paper.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.IURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.w3c.dom.Document;

import com.lin.paper.bean.UserInfo;

/**
 * 文档表格操作工具
 * @author	lin
 * @date	2018年1月23日下午7:51:08
 * @version 1.0
 */
public class FileUtil {
	 //总行数  
    private static int totalRows = 0;    
    //总条数  
    private static int totalCells = 0;   
	
	
	/**
	 * 将html片段存储为文件内容(公告使用中,适用于doc docx)
	 * @param html
	 * @return
	 * @throws Exception
	 */
	public static void htmlToWord(String htmlContent, String outUrl) {
		try {
			//拼一个标准的HTML格式文档  
			String content = "<html><body>" + htmlContent + "</body></html>";  
			//文件输入流
			InputStream is = new ByteArrayInputStream(content.getBytes("UTF-8"));  
			//文件输出流
			OutputStream os = new FileOutputStream(outUrl);
			//文件输出
			inputStreamToWord(is, os); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	        
	/** 
	* 把is写入到对应的word输出流os中 
	* 不考虑异常的捕获，直接抛出 
	* @param is 
	* @param os 
	* @throws IOException 
	*/  
	private static void inputStreamToWord(InputStream is, OutputStream os) throws IOException {  
	    POIFSFileSystem fs = new POIFSFileSystem();  
	    //对应于org.apache.poi.hdf.extractor.WordDocument  
	    fs.createDocument(is, "WordDocument");  
	    fs.writeFilesystem(os);  
	    os.close();  
	    is.close();  
	}  
	
	
	
	
	
	/**
	 * 将word存储为html内容(公告使用中,适用于doc docx)
	 * @param wordPath
	 * @return 
	 */
	public static String wordToHtml(String wordPath) {
		try {
			String htmlPath = wordPath.substring(0, wordPath.lastIndexOf("\\"));
			return convert2Html(wordPath, htmlPath);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 将word转换成html 支持 .doc and .docx
	 * @param fileName word文件名
	 * @param outPutFilePath html存储路径
	 * @param newFileName  html名
	 * @throws TransformerException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	private static String convert2Html(String fileName, String outPutFilePath)
			throws TransformerException, IOException, ParserConfigurationException {
		String substring = fileName.substring(fileName.lastIndexOf(".") + 1);
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		/**
		 * word2007和word2003的构建方式不同， 前者的构建方式是xml，后者的构建方式是dom树。
		 * 文件的后缀也不同，前者后缀为.docx，后者后缀为.doc 相应的，apache.poi提供了不同的实现类。
		 */
		if ("docx".equals(substring)) {		//docx
			// writeFile(new String("<html><head> <meta
			// http-equiv=\"content-type\" content=\"text/html\"
			// charset=\"utf-8\"/></head>对不起，.docx格式的word文档，暂时不能生成预览</html>".getBytes("utf-8")),
			// outPutFilePath+newFileName);

			// step 1 : 加载 DOCX 到 XWPFDocument
			InputStream inputStream = new FileInputStream(new File(fileName));
			XWPFDocument document = new XWPFDocument(inputStream);

			// step 2 : prepare XHTML options
			final String imageUrl = "";

			XHTMLOptions options = XHTMLOptions.create();
			options.setExtractor(new FileImageExtractor(new File(outPutFilePath + imageUrl)));
			options.setIgnoreStylesIfUnused(false);
			options.setFragment(true);
			options.URIResolver(new IURIResolver() {
				// @Override 重写的方法，加上这个报错，你看看是啥问题
				public String resolve(String uri) {
					return imageUrl + uri;
				}
			});

			// step 3 : convert XWPFDocument to XHTML
			XHTMLConverter.getInstance().convert(document, out, options);
		} else {		//doc
			HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(fileName));// WordToHtmlUtils.loadDoc(new
																						// FileInputStream(inputFile));
			WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
					DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
			wordToHtmlConverter.setPicturesManager(new PicturesManager() {
				public String savePicture(byte[] content, PictureType pictureType, String suggestedName,
						float widthInches, float heightInches) {
					return suggestedName;
				}
			});
			wordToHtmlConverter.processDocument(wordDocument);
			// 保存图片
			List<Picture> pics = wordDocument.getPicturesTable().getAllPictures();
			if (pics != null) {
				for (int i = 0; i < pics.size(); i++) {
					Picture pic = (Picture) pics.get(i);
					System.out.println();
					try {
						pic.writeImageContent(new FileOutputStream(outPutFilePath + pic.suggestFullFileName()));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
			Document htmlDocument = wordToHtmlConverter.getDocument();
			DOMSource domSource = new DOMSource(htmlDocument);
			StreamResult streamResult = new StreamResult(out);

			TransformerFactory tf = TransformerFactory.newInstance(); // 这个应该是转换成xml的
			Transformer serializer = tf.newTransformer();
			serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			serializer.setOutputProperty(OutputKeys.METHOD, "html");
			serializer.transform(domSource, streamResult);
		}

		out.close(); //关闭流
		//写入文件
		//writeFile(new String(out.toByteArray()), outPutFilePath + newFileName);
		return new String(out.toByteArray());
	}
	
	/**
	 * 读EXCEL文件，获取用户信息集合 
	 * @param excelPath
	 * @return
	 */
	@SuppressWarnings("resource")
	public static List<UserInfo> ExcelToUserBean(String excelPath) {
		List<UserInfo> userList = null;
		try {
			InputStream inputStream = new FileInputStream(excelPath);
			
			if (!validateExcel(excelPath)) {// 验证文件名是否合格  
	            return null;  
	        }  
	        boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本，默认为2003
	        if (isExcel2007(excelPath)) {  
	            isExcel2003 = false;  
	        }  
	        //创建表格，解析表格数据
	        userList = createExcel(inputStream, isExcel2003);  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	/** 
	* 根据excel里面的内容读取客户信息 
	* @param is 输入流 
	* @param isExcel2003 excel是2003还是2007版本 
	* @return 
	* @throws IOException 
	*/  
	private static List<UserInfo> createExcel(InputStream is, boolean isExcel2003) {  
		List<UserInfo> userList = null;
		try{  
	        Workbook wb = null;  
	        if (isExcel2003) {// 当excel是2003时,创建excel2003  
	        wb = new HSSFWorkbook(is);  
	    } else {// 当excel是2007时,创建excel2007  
	        wb = new XSSFWorkbook(is);  
	    }  
	    userList = readExcelValue(wb);// 读取Excel里面客户的信息  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	    return userList;  
	}  
	
	/** 
	   * 读取Excel里面客户的信息 
	   * @param wb 
	   * @return 
	   */  
    private static List<UserInfo> readExcelValue(Workbook wb) {  
        // 得到第一个shell  
        Sheet sheet = wb.getSheetAt(0);  
        // 得到Excel的行数  
        totalRows = sheet.getPhysicalNumberOfRows();  
        // 得到Excel的列数(前提是有行数)  
        if (totalRows > 1 && sheet.getRow(0) != null) {  
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();  
        }  
        //创建集合
        List<UserInfo> userList = new ArrayList<UserInfo>();  
        // 循环Excel行数  
        for (int r = 2; r < totalRows; r++) {  
            Row row = sheet.getRow(r);  
            if (row == null){  
                continue;  
            }  
            //创建对象
            UserInfo user = new UserInfo();  
            // 循环Excel的列  
            for (int c = 0; c < totalCells; c++) {  
                Cell cell = row.getCell(c);  
                if (null != cell) {  
                	switch (c) {
                	case 0:	//学号/职工号
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setUserno(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setUserno(cell.getStringCellValue());//名称  
                        }  
						break;
					case 1:	//姓名
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setName(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setName(cell.getStringCellValue());//名称  
                        }  
						break;
					case 2:	//性别
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setSex(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setSex(cell.getStringCellValue());//名称  
                        }  
						break;
					case 3:	//系
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setSeries(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setSeries(cell.getStringCellValue());//名称  
                        }  
						break;
					case 4:	//专业
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setMajor(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setMajor(cell.getStringCellValue());//名称  
                        }  
						break;
					case 5:	//班级
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setClazz(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setClazz(cell.getStringCellValue());//名称  
                        }  
						break;
					case 6:	//入学年份
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setYear(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setYear(cell.getStringCellValue());//名称  
                        }  
						break;
					case 7:	//届数
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setSession(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setSession(cell.getStringCellValue());//名称  
                        }  
						break;
					case 8:	//手机号
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setTel(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setTel(cell.getStringCellValue());//名称  
                        }  
						break;
					case 9:	//qq
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setQq(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setQq(cell.getStringCellValue());//名称  
                        }  
						break;
					case 10:	//邮箱
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setEmail(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setEmail(cell.getStringCellValue());//名称  
                        }  
						break;
					case 11:	//身份证号
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setCardid(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setCardid(cell.getStringCellValue());//名称  
                        }  
						break;
					case 12:	//部门
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setDepartment(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setDepartment(cell.getStringCellValue());//名称  
                        }  
						break;
					case 13:	//学位
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setDedgree(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setDedgree(cell.getStringCellValue());//名称  
                        }  
						break;
					case 14:	//职称
						//如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25  
                        if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){  	//数字
                            String name = String.valueOf(cell.getNumericCellValue());  
                            user.setTitle(name.substring(0, name.length()-2>0?name.length()-2:1));//名称  
                        }else{  
                            user.setTitle(cell.getStringCellValue());//名称  
                        }  
						break;
					}
                	
                }  
            }  
            // 添加到list  
            userList.add(user);  
        }  
        return userList;  
    }  
	    
    /** 
     * 验证EXCEL文件 
     * @param filePath 
     * @return 
     */  
    private static boolean validateExcel(String filePath) {  
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {  
            return false;  
        }  
        return true;  
    }  
      
    // @描述：是否是2003的excel，返回true是2003   
    private static boolean isExcel2003(String filePath)  {    
    	return filePath.matches("^.+\\.(?i)(xls)$");    
    }    
     
    //@描述：是否是2007的excel，返回true是2007   
    private static boolean isExcel2007(String filePath)  {    
    	return filePath.matches("^.+\\.(?i)(xlsx)$");    
    }

    /**
     * 文件下载
     * @param filepath	全路径
     * @param fileurl	全名称（包括拓展名）
     * @param fileName  下载之后名称
     * @return
     * @throws Exception 
     */
	@SuppressWarnings("resource")
	public static ResponseEntity<byte[]> downloadFile(String filepath, String fileurl, String fileName) throws Exception {
		File file = new File(filepath);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        //拓展名
        String ext = fileurl.substring(fileurl.lastIndexOf("."));
        //生成文件名
        String filename = new String(fileName.getBytes("UTF-8"), "iso-8859-1")+ext;
        headers.add("Content-Disposition", "attchement;filename=" + filename);
        HttpStatus statusCode = HttpStatus.OK;
        return new ResponseEntity<byte[]>(body, headers, statusCode);
	}   
   
}
