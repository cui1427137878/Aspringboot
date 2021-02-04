package com.db.sys.service;

import java.util.Map;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysUser;
import com.db.sys.vo.SysUserDeptVo;

public interface SysUserService {
	/**
	 * 基于id查询用户以及用户对应的部门，角色信息
	 * @param userId
	 * @return
	 */
	Map<String, Object> findObjectById(
			Integer userId);

	/**
	 * 更新用户自身信息以及用户和角色关系数据
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int updateObject(SysUser entity,
			Integer[]roleIds);
	 /**
	  * 保存用户自身信息以及用户和角色关系数据
	  * @param entity
	  * @param roleIds
	  * @return
	  */
	 int saveObject(SysUser entity,
			 Integer[]roleIds);
	
	 int validById(Integer id,
			       Integer valid,
			       String modifiedUser);
	 

	 PageObject<SysUserDeptVo> findPageObjects(
			 String username,
			 Integer pageCurrent);
}
