package com.zk.dao;

import com.zk.entity.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserDao {
	
	@Select("select * from user where id = #{id}")
	public User getById(@Param("id")int id	);

	@Insert("insert into user(id, name)values(#{id}, #{name})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int insert(User user);
	
}
