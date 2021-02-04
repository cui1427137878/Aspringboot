package cn.tedu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tedu.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

	@Select("select * from user")
	public List<User> findAll();
	
	//新增
		@Insert("insert into user"
				+ " (name,birthday,address)"
				+ " values(#{user.name},#{user.birthday},#{user.address})")
		public void insert(@Param("user") User user);
}
