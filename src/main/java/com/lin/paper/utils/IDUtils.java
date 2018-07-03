package com.lin.paper.utils;

import java.util.Random;


/**
 * 主键生成工具
 * @author	lin
 * @date	2018年1月22日上午10:57:19
 * @version 1.0
 */
public class IDUtils {
	
	/**
	 * 栏目id生成
	 * @return
	 */
	public static String getColumnId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上一位随机数
		Random random = new Random();
		int end1 = random.nextInt(9);
		//如果不足一位前面补0
		String id = "c"+millis + String.format("%01d", end1);
		return id;
	}
	
	public static void main(String[] args) {
		for(int i=0;i< 20;i++) {
			//System.out.println("ITEM:"+genItemId());
			//System.out.println("IMAGE:"+genImageName());
			System.out.println(":"+getColumnId());
			
		}
		
	}

	/**
	 * 公告id生成
	 * @return
	 */
	public static String getNoticeId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上一位随机数
		Random random = new Random();
		int end1 = random.nextInt(9);
		//如果不足一位前面补0
		String id = "n"+millis + String.format("%01d", end1);
		return id;
	}
	
	/**
	 * 公告文件名生成
	 * @return
	 */
	public static String getNoticeFileName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上二位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足三位前面补0
		String str = "nf"+millis + String.format("%02d", end2);
		
		return str;
	}

	/**
	 * 角色id生成
	 * @return
	 */
	public static String getRoleId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上一位随机数
		Random random = new Random();
		int end1 = random.nextInt(9);
		//如果不足一位前面补0
		String id = "r"+millis + String.format("%01d", end1);
		return id;
	}

	/**
	 * 生成用户ID
	 * @return
	 */
	public static String getUserId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = "u"+millis + String.format("%03d", end3);
		return str;
	}

	/**
	 * 生成小组ID
	 * @return
	 */
	public static String getGroupId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上一位随机数
		Random random = new Random();
		int end1 = random.nextInt(9);
		//如果不足一位前面补0
		String id = "g"+millis + String.format("%01d", end1);
		return id;
	}

	/**
	 * 生成任务ID
	 * @return
	 */
	public static String getTaskId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上一位随机数
		Random random = new Random();
		int end1 = random.nextInt(9);
		//如果不足一位前面补0
		String id = "t"+millis + String.format("%01d", end1);
		return id;
	}

	/**
	 * 生成课题ID
	 * @return
	 */
	public static String getSubjectId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上一位随机数
		Random random = new Random();
		int end1 = random.nextInt(9);
		//如果不足一位前面补0
		String id = "s"+millis + String.format("%01d", end1);
		return id;
	}

	/**
	 * 生成选题ID
	 * @return
	 */
	public static String getSelectId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上一位随机数
		Random random = new Random();
		int end1 = random.nextInt(9);
		//如果不足一位前面补0
		String id = "se"+millis + String.format("%01d", end1);
		return id;
	}

	/**
	 * 生成进度ID
	 * @return
	 */
	public static String getProgressId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String id = "pr"+millis + String.format("%03d", end3);
		return id;
	}
}
