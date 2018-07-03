package com.lin.paper.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lin.paper.bean.UserInfo;
import com.lin.paper.mapper.PInfoMapper;
import com.lin.paper.mapper.PUserMapper;
import com.lin.paper.pojo.PInfo;
import com.lin.paper.pojo.PInfoExample;
import com.lin.paper.pojo.PUser;
import com.lin.paper.pojo.PUserExample;
import com.lin.paper.pojo.PUserExample.Criteria;
import com.lin.paper.service.InfoService;
import com.lin.paper.service.RoleService;
import com.lin.paper.utils.FileUtil;
import com.lin.paper.utils.IDUtils;

/**
 * 用户信息的业务逻辑实现类
 * @author	lin
 * @date	2018年1月18日下午4:33:17
 * @version 1.0
 */
@Service
public class InfoServiceImpl implements InfoService{
	@Resource
	private PInfoMapper infoMapper;
	@Resource
	private PUserMapper userMapper;
	@Resource
	private RoleService roleService;
	
	@Value("${ROLE_NOT_IN}")
	private String ROLE_NOT_IN;		//小组成员包括的成员角色数据
	
	
	@Override
	public List<PInfo> getAllUserInfo() {
		PInfoExample example = new PInfoExample();
		//查询所有的用户信息数据
		return infoMapper.selectByExample(example);
	}

	@Override
	public UserInfo getUserInfoById(String userid) {
		if (userid != null) {
			//查询对应用户的信息数据
			PInfo info = infoMapper.selectByPrimaryKey(userid);
			UserInfo userInfo = new UserInfo();
			BeanUtils.copyProperties(info, userInfo);
			//查询单条用户数据
			PUser user = userMapper.selectByPrimaryKey(userid);
			BeanUtils.copyProperties(user, userInfo);
			
			//查询对应的角色数据
			String roles = roleService.getNamesByIds(user.getRoles());
			userInfo.setRoles(roles);
			return userInfo;
		}else {
			return null;
		}
	}

	@Override
	public void saveUserInfo(UserInfo userInfo) {
		PUser user = new PUser();
		PInfo info = new PInfo();
		//赋值部分属性
		BeanUtils.copyProperties(userInfo, user);
		BeanUtils.copyProperties(userInfo, info);
		//初始化其他数据
		user.setCreatetime(new Date());		//创建时间
		user.setUpdatetime(new Date());		//更新时间
		user.setPwd(DigestUtils.md5Hex(userInfo.getUserno()).toString()); //密码
		user.setRoles(userInfo.getRoles()); //角色集合
		user.setUserstate(0); 	//0:正常
		String userid = IDUtils.getUserId();
		user.setUserid(userid); 	 		//用户ID
		
		
		info.setUserid(userid);		//用户ID
		info.setImageurl("/img/profile/picjumbo.com_HNCK4153_resize.jpg"); 	//默认头像
		info.setCreatetime(new Date());
		info.setUpdatetime(new Date());
		
		//插入数据
		userMapper.insert(user);
		infoMapper.insert(info);
		
	}

	@Override
	public void uploadFile(UserInfo userInfo, String path) {
		//上传文件
		//取文件扩展名
		String originalFilename = userInfo.getFile().getOriginalFilename();
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		//存储文件
		String url = uploadFile(path, ext, userInfo.getFile());
		
		//解析文件生成数据集合
		List<UserInfo> list = FileUtil.ExcelToUserBean(path+url);	
		//遍历循环
		for (UserInfo userInfo2 : list) {
			userInfo2.setRoles(userInfo.getRoles());
			//保存单条数据
			saveUserInfo(userInfo2);
		}
		
		
	}
	
	/**
	 * 文件保存
	 * @param path	路径
	 * @param ext	拓展名
	 * @param uploadFile 文件
	 * @return
	 */
	private String uploadFile(String path, String ext, MultipartFile uploadFile) {
		String url = "";
		//生成文件名
		String fileName = IDUtils.getNoticeFileName();
		//文件在存放路径，应该使用日期分隔的目录结构
		DateTime dateTime = new DateTime();
		String filePath = dateTime.toString("/yyyy/MM/dd");
		//上传文件
		File filepath = new File(path+filePath, fileName + ext);
        //判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) { 
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文件当中
        File file = new File(path+filePath + File.separator + fileName+ext);
        try {
        	uploadFile.transferTo(file);
			//url = "/file"+filePath+"/"+fileName+ext;
        	url = filePath+"/"+fileName+ext;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@Override
	public void deleteUserInfoById(String userid) {
		//删除用户中的数据
		userMapper.deleteByPrimaryKey(userid);
		//删除信息中的数据
		infoMapper.deleteByPrimaryKey(userid);
		
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		PUser user2 = userMapper.selectByPrimaryKey(userInfo.getUserid());
		PInfo info2 = infoMapper.selectByPrimaryKey(userInfo.getUserid());
		
		PUser user = new PUser();
		PInfo info = new PInfo();
		//赋值部分属性
		BeanUtils.copyProperties(userInfo, user);
		BeanUtils.copyProperties(userInfo, info);
		//初始化其他数据
		user.setCreatetime(user2.getCreatetime());
		user.setUpdatetime(new Date());
		user.setPwd(user2.getPwd());
		if (StringUtils.isEmpty(userInfo.getRoles())) {		//为空重新设置原来的
			user.setRoles(user2.getRoles());
		}
		
		
		info.setCreatetime(info2.getCreatetime());
		info.setUpdatetime(new Date());
		info.setImageurl(info2.getImageurl());
		//插入数据
		userMapper.updateByPrimaryKey(user);
		infoMapper.updateByPrimaryKey(info);
		
		userInfo.setRoles(roleService.getNamesByIds(user.getRoles()));
	}

	@Override
	public List<PInfo> getUserInfoByRoleIn() {
		//查询包含数据的角色集合
		String[] rolenames = ROLE_NOT_IN.split(",");
		
		List<String> roleids = new ArrayList<>();
		if (rolenames!=null&&rolenames.length>0) {
			for (String string : rolenames) {
				roleids.add(roleService.getRoleByName(string).getRoleid());
			}
		}
		
		//查询对应角色的用户的信息数据
		PUserExample example = new PUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRolesNotIn(roleids);
		
		List<PUser> users = userMapper.selectByExample(example);
		List<PInfo> infos = null;
		if (users != null && users.size()>0) {
			infos = new ArrayList<>();
			for (PUser pUser : users) {
				//查询对应角色的用户的信息数据
				PInfo info = infoMapper.selectByPrimaryKey(pUser.getUserid());
				infos.add(info);
			}
		}
		
		return infos;
	}

	@Override
	public String getNameByIds(String users) {
		//查询用户列表
		PInfoExample example = new PInfoExample();
		//设置查询条件
		com.lin.paper.pojo.PInfoExample.Criteria criteria = example.createCriteria();
		List<String> ids = Arrays.asList(users.split(","));
		criteria.andUseridIn(ids);
		//查询数据
		List<PInfo> list = infoMapper.selectByExample(example);
		if (list != null && list.size()>0) {
			//名称集合
			StringBuilder names = new StringBuilder();
			names.append(list.get(0).getName());
			
			for (int i = 1; i< list.size(); i++) {
				names.append(","+list.get(i).getName());
			}
			return names.toString();
		}else{
			return "";
		}
	}

}
