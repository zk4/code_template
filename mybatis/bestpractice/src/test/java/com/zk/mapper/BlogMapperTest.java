package com.zk.mapper;

import com.zk.entity.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlogMapperTest {

	BlogMapper mapper;

	SqlSessionFactory build;

	SqlSession sqlSession;
	@Before
	public void setUp() throws Exception {
		Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
		 build = new SqlSessionFactoryBuilder().build(resourceAsReader);
		//   参数 true 自动提交事务
		sqlSession = build.openSession(true);
		mapper = sqlSession.getMapper(BlogMapper.class);
	}


	@Test
	public void insertBlog() {
		Blog blog = new Blog().setName("insert").setAuthorName("meme");
		Boolean success = mapper.insert(blog);
		Assert.assertEquals(success, true);
		System.out.println(blog.getId());
	}

	@Test
	public void selectBlog() throws IOException {
		Blog blog = mapper.selectBlog("1");
		System.out.println(blog);
		Assert.assertEquals(blog.getId(), blog.getId());
	}

	@Test
	public void selectBlogs() {
		List<Blog> blogs = mapper.selectBlogs();
		for (Blog blog : blogs) {
			System.out.println(blog);
		}
		Assert.assertTrue(blogs.size()>0);

	}

	@Test
	public void selectBlogsInMap() {
		Map<Integer,Blog> blogs = mapper.selectBlogsInMap();
		Assert.assertTrue(blogs.size()>0);
	}
	@Test
	public void selectBlogsByIdAndName() {
		Map<Integer,Blog> blogs = mapper.selectBlogsByIdAndName("1","updated");
		Assert.assertTrue(blogs.size()>0);
	}
	@Test
	public void selectBlogsByIdAndName2() {
		Map<Integer,Blog> blogs = mapper.selectBlogsByIdAndName2("1","updated");
		Assert.assertTrue(blogs.size()>0);
	}
	@Test
	public void selectBlogsByMap() {
		HashMap<String, String> args = new HashMap<>();
		args.put("id", "1");
		args.put("name", "updated");

		Map<Integer,Blog> blogs = mapper.selectBlogsByMap(args);
		Assert.assertTrue(blogs.size()>0);
	}
	@Test
	public void selectBlogsInMap2() {
		Map<Integer, Map<String, String>> blogs = mapper.selectBlogsInMap2();
		Assert.assertEquals(1,  blogs.get(1).get("id"));

		Assert.assertTrue(blogs.size()>0);
	}
	@Test
	public void selectBlogsInMap2Cache() {
		Map<Integer, Map<String, String>> blogs = mapper.selectBlogsInMap2();
		Assert.assertEquals(1,  blogs.get(1).get("id"));

		// 缓存要生效,必须要提交.
		this.sqlSession.commit();

		BlogMapper mapper = this.sqlSession.getMapper(BlogMapper.class);
		 blogs = mapper.selectBlogsInMap2();
		Assert.assertEquals(1,  blogs.get(1).get("id"));



	}
	@Test
	public void deleleteBlog() throws InterruptedException {
		Blog blog = new Blog().setName("insert").setAuthorName("meme2");
		Boolean success = mapper.insert(blog);
		Assert.assertEquals(success, true);
		sqlSession.commit();

		Thread.sleep(3000);
		boolean b = this.mapper.deleleteBlog(""+blog.getId());
		Assert.assertTrue(b);
	}

	@Test
	public void updateBlog() {
		boolean b = mapper.updateBlog(new Blog().setId(2).setName("updated2222") );
		Assert.assertTrue(b);

	}

	@Test
	public void updateBlog2() {
		int a = mapper.updateBlogReturnEffectiveLRow(new Blog().setId(2).setName("update only cell") );
		Assert.assertTrue(a>0);
	}
	@Test
	public void selectBlogOne2Many() throws IOException {
		Blog blog = mapper.selectBlogOne2Many("1");
		System.out.println(blog);
		Assert.assertEquals(blog.getId(), blog.getId());
	}

	@Test
	public void selectBlogsByArgs() {
		Blog blog1 = new Blog();

		List<Blog> blogs = mapper.selectBlogsByArgs(blog1);
		for (Blog blog : blogs) {
			System.out.println(blog);
		}
		Assert.assertTrue(blogs.size()>0);

	}
	@Test
	public void selectBlogsByArgs2() {
		Blog blog1 = new Blog();
		blog1.setId(1);
		List<Blog> blogs = mapper.selectBlogsByArgs(blog1);
		for (Blog blog : blogs) {
			System.out.println(blog);
		}
		Assert.assertTrue(blogs.size()>0);

	}
	@Test
	public void selectBlogsByArgs3() {
		Blog blog1 = new Blog();
		blog1.setId(1);
		blog1.setName("updated");
		blog1.setAuthorName("meme");
		List<Blog> blogs = mapper.selectBlogsByArgs(blog1);
		for (Blog blog : blogs) {
			System.out.println(blog);
		}
		Assert.assertTrue(blogs.size()>0);

	}

}
