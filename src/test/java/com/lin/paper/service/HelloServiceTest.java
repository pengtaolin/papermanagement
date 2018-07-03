package com.lin.paper.service;


import org.apache.commons.codec.digest.DigestUtils;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 框架搭建测试
 * @author	lin
 * @date	2018年1月3日下午4:48:03
 * @version 1.0
 */
public class HelloServiceTest {
	
	ApplicationContext context;
	
	@Before
	public void Init(){
		context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		
	}
	
	@Test
	public void test() {
		//context.getBean(UserService.class);
		System.out.println(DigestUtils.md5Hex("14134390794"));
		System.out.println(DigestUtils.md5Hex("14134390794"));
		System.out.println(DigestUtils.md5Hex("14134390794"));
		System.out.println(DigestUtils.md5Hex("14134390794"));
	}

}
