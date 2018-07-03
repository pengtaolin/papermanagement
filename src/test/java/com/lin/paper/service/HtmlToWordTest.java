package com.lin.paper.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * HTML文档转化到Word文档测试
 * @author	lin
 * @date	2018年1月23日下午4:47:11
 * @version 1.0
 */
public class HtmlToWordTest {
	public static void main(String[] args) throws Exception {
		new HtmlToWordTest().htmlToWord();
	}
	
	
	public void htmlToWord() throws Exception {  
	    InputStream bodyIs = new FileInputStream("E:\\大学\\大四\\毕业论文\\论文\\材料\\htmlToWord.html");  
	    InputStream cssIs = new FileInputStream("E:\\大学\\大四\\毕业论文\\论文\\材料\\1.css");  
	    String body = this.getContent(bodyIs);  
	    /*String body = "<p class='MsoNormal' style='font-family:&quot;background-color:#FFFFFF;text-indent:24pt;'>"+ "<span style='font-size:12pt;font-family:宋体;'>"
	    		+ "<p class='MsoNormal' style='font-family:&quot;background-color:#FFFFFF;text-indent:24pt;'>"
	    		+ "<span style='font-size:12pt;font-family:宋体;'>"
	    		+ "<p class='MsoNormal' style='font-family:&quot;background-color:#FFFFFF;text-indent:24pt;'>"
	    		+ "<span style='font-size:12pt;font-family:宋体;'>&nbsp; 12</span><span style='font-size:12pt;font-family:宋体;'>月<span>8</span>日</span><span style='font-size:12pt;font-family:宋体;'>晚，由社团联合会主办，柚林文学社和历史文学社承办的“瞻彼日月，只争朝夕”一站到底知识竞赛决赛在大学生活动中心举行。<span></span></span>"
	    		+ "</p>"
	    		+ "<p class='MsoNormal' style='font-family:&quot;background-color:#FFFFFF;text-indent:24pt;'>"
	    		+ "<span style='font-size:12pt;font-family:宋体;'>&nbsp; 此次进入决赛的<span>12</span>人分为<span>NICE</span>组、杨林组、主旋律组和<span>WCL</span>组。决赛分为必答题、限时答题、抢答题三轮。比赛分一问一答、限时抢答和必答题三个环节。四支队伍你来我往、竞争激烈，各组选手从容应对，认真作答。期间加入观众互动环节，把全场气氛推向高潮。比赛过程中比赛内容涉及范围广，灵活多变，非常考验选手的知识储备。经过三轮的激烈比拼以及加赛环节，最终由主旋律队获得第一名，<span>NICE</span>队获得第二名，杨林队获得第三名，<span>WCL</span>队获得第四名。（学生记者 周薇<span>&nbsp;&nbsp;</span>赖丽红 刘青青 何苑琳<span>&nbsp;&nbsp;</span>责任编辑<span>&nbsp;&nbsp;</span>胡聪）</span>"
	    		+ "</p>"
	    		+ "</span>"
	    		+ "</p>"
	    		+ "<p class='MsoNormal' style='font-family:&quot;background-color:#FFFFFF;text-indent:24pt;'>"
	    		+ "<span style='font-size:12pt;font-family:宋体;'><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span></span>"
	    		+ "</p>"
	    		+ "</span>"
	    		+ "</p>"
	    		+ "<p class='MsoNormal' style='font-family:&quot;background-color:#FFFFFF;text-indent:24pt;'>"
	    		+ "<span style='font-size:12pt;font-family:宋体;'><span></span><span></span><span></span><span></span><span></span><span></span><span></span><span></span></span>"
	    		+ "</p>";*/
	    String css = this.getContent(cssIs);  
	    //拼一个标准的HTML格式文档  
	    String content = "<html><head><style>" + css + "</style></head><body>" + body + "</body></html>";  
	    InputStream is = new ByteArrayInputStream(content.getBytes("UTF-8"));  
	    OutputStream os = new FileOutputStream("E:\\大学\\大四\\毕业论文\\论文\\材料\\1.doc");  
	    this.inputStreamToWord(is, os);  
	}  
	        
	/** 
	* 把is写入到对应的word输出流os中 
	* 不考虑异常的捕获，直接抛出 
	* @param is 
	* @param os 
	* @throws IOException 
	*/  
	private void inputStreamToWord(InputStream is, OutputStream os) throws IOException {  
	    POIFSFileSystem fs = new POIFSFileSystem();  
	    //对应于org.apache.poi.hdf.extractor.WordDocument  
	    fs.createDocument(is, "WordDocument");  
	    fs.writeFilesystem(os);  
	    os.close();  
	    is.close();  
	}  
	        
	/** 
	* 把输入流里面的内容以UTF-8编码当文本取出。 
	* 不考虑异常，直接抛出 
	* @param ises 
	* @return 
	* @throws IOException 
	*/  
	private String getContent(InputStream... ises) throws IOException {  
	    if (ises != null) {  
	        StringBuilder result = new StringBuilder();  
	        BufferedReader br;  
	        String line;  
	        for (InputStream is : ises) {  
	            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));  
	            while ((line=br.readLine()) != null) {  
	                result.append(line);  
	            }  
	        }  
	        return result.toString();  
	    }  
	    return null;  
	} 
	  
}
