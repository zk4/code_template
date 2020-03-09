package com.zk.mapper;

import com.zk.entity.Blog;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

	public Blog selectBlog(String id);

	public List<Blog> selectBlogs();


	public Boolean insert(Blog blog);

	@MapKey("id")
	public Map<Integer,Blog> selectBlogsInMap();

	// 只能用 arg0 arg1 来引用 id 与 name
	@MapKey("id")
	public Map<Integer,Blog> selectBlogsByIdAndName(String id, String name);

	// 可以在 xml 里直接引用 id ,与 name
	@MapKey("id")
	public Map<Integer,Blog> selectBlogsByIdAndName2(@Param("id") String id,@Param("name") String name);

	// 可以在 xml 里直接引用 id, 与 name, 但是在传的时候要将参数放入  map
	@MapKey("id")
	public Map<Integer,Blog> selectBlogsByMap(Map<String,String> args);

	@MapKey("id")
	public Map<Integer, Map<String,String>> selectBlogsInMap2();

	public boolean deleleteBlog(String id);

	public boolean updateBlog(Blog blog);
	public Integer updateBlogReturnEffectiveLRow(Blog blog);


	public Blog selectBlogOne2Many(String id);

	List<Blog> selectBlogsByArgs(Blog blog1);
}
