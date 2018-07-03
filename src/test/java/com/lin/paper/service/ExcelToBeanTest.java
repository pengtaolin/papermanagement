package com.lin.paper.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.lin.paper.bean.UserInfo;

/**
 * 将Excel表格数据导入到javabean对象测试
 * @author	lin
 * @date	2018年1月23日下午5:29:17
 * @version 1.0
 */
public class ExcelToBeanTest {
	
	public static void main(String[] args) throws Exception {
		/*InputStream inputStream = new FileInputStream("E:\\大学\\大四\\毕业论文\\论文\\材料\\2014年数信系新生名单.xls");
		ReadExcel test = new ExcelToBeanTest().new ReadExcel();
		test.createExcel(inputStream, true);*/
		
		//List<UserInfo> excelToUserBean = FileUtil.ExcelToUserBean("E:\\大学\\大四\\毕业论文\\论文\\材料\\2014年数信系新生名单.xls");
		//System.out.println(excelToUserBean);
	}
	
	/** 
     * 读取excel中的数据,生成list 
     */  
	public String readExcelFile(MultipartFile file) {  
        String result ="";  
        //创建处理EXCEL的类  
        ReadExcel readExcel=new ReadExcel();  
        //解析excel，获取上传的数据列表 
        List<UserInfo> useList = readExcel.getExcelInfo(file);  
        
        //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,  
        //和你具体业务有关,这里不做具体的示范  
        if(useList != null && !useList.isEmpty()){  
            result = "上传成功";  
        }else{  
            result = "上传失败";  
        }  
        return result;  
    }  
	
	public class ReadExcel {  
	    //总行数  
	    private int totalRows = 0;    
	    //总条数  
	    private int totalCells = 0;   
	    //错误信息接收器  
	    private String errorMsg;  
	    //构造方法  
	    public ReadExcel(){}  
	    //获取总行数  
	    public int getTotalRows()  { return totalRows;}   
	    //获取总列数  
	    public int getTotalCells() {  return totalCells;}   
	    //获取错误信息  
	    public String getErrorInfo() { return errorMsg; }    
	      
	  /** 
	   * 读EXCEL文件，获取信息集合 
	   * @param fielName 
	   * @return 
	   */  
	    public List<UserInfo> getExcelInfo(MultipartFile mFile) {  
	        String fileName = mFile.getOriginalFilename();//获取文件名  
	        List<UserInfo> userList = null;
	        try {  
	            if (!validateExcel(fileName)) {// 验证文件名是否合格  
	                return null;  
	            }  
	            boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本，默认为2003
	            if (isExcel2007(fileName)) {  
	                isExcel2003 = false;  
	            }  
	            //创建表格，解析表格数据
	            userList = createExcel(mFile.getInputStream(), isExcel2003);  
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
	    public List<UserInfo> createExcel(InputStream is, boolean isExcel2003) {  
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
	    private List<UserInfo> readExcelValue(Workbook wb) {  
	        // 得到第一个shell  
	        Sheet sheet = wb.getSheetAt(0);  
	        // 得到Excel的行数  
	        this.totalRows = sheet.getPhysicalNumberOfRows();  
	        // 得到Excel的列数(前提是有行数)  
	        if (totalRows > 1 && sheet.getRow(0) != null) {  
	            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();  
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
	            for (int c = 0; c < this.totalCells; c++) {  
	                Cell cell = row.getCell(c);  
	                if (null != cell) {  
	                	switch (c) {
	                	case 0:	//学号
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
	     *  
	     * @param filePath 
	     * @return 
	     */  
	    public boolean validateExcel(String filePath) {  
	        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {  
	            errorMsg = "文件名不是excel格式";  
	            return false;  
	        }  
	        return true;  
	    }  
	      
	    // @描述：是否是2003的excel，返回true是2003   
	    public boolean isExcel2003(String filePath)  {    
	         return filePath.matches("^.+\\.(?i)(xls)$");    
	     }    
	     
	    //@描述：是否是2007的excel，返回true是2007   
	    public boolean isExcel2007(String filePath)  {    
	         return filePath.matches("^.+\\.(?i)(xlsx)$");    
	     }    
	}  

}
