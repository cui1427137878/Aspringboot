package com.pt.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.pt.member.entity.Member;
public interface MemberDao {
	 /**
	  * 查询会员信息
	  * 
	  * 当方法中的参数有多个时，在映射文件的sql语句中
	  * 1)可以使用#{arg0},#{arg1},...或者#{param1}，#{param2}...
	  * 获取参数的值。
	  * 2)也可以使用#{方法参数别名}，例如#{startIndex}方式获取，
	  * 但需要在接口方法中使用@Param注解定义参数别名。
	  */
	 List<Member> findPageObjects(
			 @Param("startIndex") Integer startIndex,
			 @Param("pageSize") Integer pageSize);
}



