package com.lin.paper.service;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.IURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;

import com.lin.paper.utils.FileUtil;

/**
 * Word文档转化到HTML文档测试
 * @author	lin
 * @date	2018年1月23日下午4:47:11
 * @version 1.0
 */
public class WordToHtmlTest {
	

	  public static void main(String[] args) {  
	       	String s = FileUtil.wordToHtml("E:\\大学\\大四\\毕业论文\\论文\\数信系毕业论文（设计）管理系统二稿.docx");
		  	System.out.println(s);
		  
		  	/*try {  
	            //wordToHtml("E:\\大学\\大四\\毕业论文\\论文\\数信系毕业论文（设计）管理系统二稿.docx", "E:\\大学\\大四\\毕业论文\\论文\\", "123.html");  
	            wordToHtml("E:\\大学\\大四\\毕业论文\\论文\\数信系毕业论文（设计）管理系统二稿.doc", "E:\\大学\\大四\\毕业论文\\论文\\", "12.html");  
	        } catch (TransformerException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } catch (ParserConfigurationException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  */
	    }  
	      
	    public static void wordToHtml(String wordPath,String htmlPath,String newFilename) throws TransformerException, IOException, ParserConfigurationException {      
	            convert2Html(wordPath, htmlPath, newFilename);  
	    }      
	      
	    public static void writeFile(String content, String path) {      
	        FileOutputStream fos = null;      
	        BufferedWriter bw = null;  
	        try {      
	            File file = new File(path);  
	            if(!file.exists()){  
	                  
	            }  
	            fos = new FileOutputStream(file);      
	            bw = new BufferedWriter(new OutputStreamWriter(fos));      
	            bw.write(content);    
	        } catch (FileNotFoundException fnfe) {      
	            fnfe.printStackTrace();      
	        } catch (IOException ioe) {      
	            ioe.printStackTrace();      
	        } finally {      
	            try {      
	                if (bw != null)      
	                    bw.close();      
	                if (fos != null)      
	                    fos.close();      
	            } catch (IOException ie) {      
	            }      
	        }      
	    }      
	      
	    /** 
	     * 将word转换成html 
	     * 支持 .doc and .docx 
	     * @param fileName word文件名 
	     * @param outPutFilePath html存储路径 
	     * @param newFileName html名 
	     * @throws TransformerException 
	     * @throws IOException 
	     * @throws ParserConfigurationException 
	     */  
	    public static void convert2Html(String fileName, String outPutFilePath,String newFileName)      
	            throws TransformerException, IOException,      
	            ParserConfigurationException {  
	        String substring = fileName.substring(fileName.lastIndexOf(".")+1);  
	        ByteArrayOutputStream out = new ByteArrayOutputStream();  
	          
	        /** 
	         * word2007和word2003的构建方式不同， 
	         * 前者的构建方式是xml，后者的构建方式是dom树。 
	         * 文件的后缀也不同，前者后缀为.docx，后者后缀为.doc 
	         * 相应的，apache.poi提供了不同的实现类。 
	         */  
	        if("docx".equals(substring)){  
//	          writeFile(new String("<html><head>  <meta http-equiv=\"content-type\" content=\"text/html\" charset=\"utf-8\"/></head>对不起，.docx格式的word文档，暂时不能生成预览</html>".getBytes("utf-8")), outPutFilePath+newFileName);   
	              
	            //step 1 : load DOCX into XWPFDocument  
	            InputStream inputStream = new FileInputStream(new File(fileName));  
	            XWPFDocument document = new XWPFDocument(inputStream);  
	              
	            //step 2 : prepare XHTML options  
	            final String imageUrl = "";  
	              
	            XHTMLOptions options = XHTMLOptions.create();  
	            options.setExtractor(new FileImageExtractor(new File(outPutFilePath + imageUrl)));  
	            options.setIgnoreStylesIfUnused(false);  
	            options.setFragment(true);  
	            options.URIResolver(new IURIResolver() {  
//	              @Override 重写的方法，加上这个报错，你看看是啥问题  
	                public String resolve(String uri) {  
	                    return imageUrl + uri;  
	                }  
	            });  
	              
	            //step 3 : convert XWPFDocument to XHTML  
	            XHTMLConverter.getInstance().convert(document, out, options);  
	        }else{  
	        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(fileName));//WordToHtmlUtils.loadDoc(new FileInputStream(inputFile));      
	        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(      
	                DocumentBuilderFactory.newInstance().newDocumentBuilder()      
	                        .newDocument());      
	         wordToHtmlConverter.setPicturesManager( new PicturesManager()      
	         {      
	             public String savePicture( byte[] content,      
	                     PictureType pictureType, String suggestedName,      
	                     float widthInches, float heightInches )      
	             {      
	                 return suggestedName;      
	             }      
	         } );      
	        wordToHtmlConverter.processDocument(wordDocument);      
	        //save pictures      
	        List<Picture> pics=wordDocument.getPicturesTable().getAllPictures();      
	        if(pics!=null){      
	            for(int i=0;i<pics.size();i++){      
	                Picture pic = (Picture)pics.get(i);      
	                System.out.println();      
	                try {      
	                    pic.writeImageContent(new FileOutputStream(outPutFilePath      
	                            + pic.suggestFullFileName()));      
	                } catch (FileNotFoundException e) {      
	                    e.printStackTrace();      
	                }        
	            }      
	        }      
	        Document htmlDocument = wordToHtmlConverter.getDocument();      
	        DOMSource domSource = new DOMSource(htmlDocument);      
	        StreamResult streamResult = new StreamResult(out);      
	      
	        TransformerFactory tf = TransformerFactory.newInstance();    //这个应该是转换成xml的  
	        Transformer serializer = tf.newTransformer();      
	        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");      
	        serializer.setOutputProperty(OutputKeys.INDENT, "yes");      
	        serializer.setOutputProperty(OutputKeys.METHOD, "html");      
	        serializer.transform(domSource, streamResult);      
	        }      
	          
	        out.close();      
	        writeFile(new String(out.toByteArray()), outPutFilePath+newFileName);      
	    } 
}
