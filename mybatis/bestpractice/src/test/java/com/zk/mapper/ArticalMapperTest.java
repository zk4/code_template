package com.zk.mapper;

import com.zk.entity.Artical;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class ArticalMapperTest {

	ArticalMapper mapper;

	@Before
	public void setUp() throws Exception {
		Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
		//   参数 true 自动提交事务
		SqlSession sqlSession = build.openSession(true);
		mapper = sqlSession.getMapper(ArticalMapper.class);
	}



	@Test
	public void selectAll() {
		List<Artical> articals = mapper.selectAll();
		Assert.assertTrue(articals.size()>0);
	}


	@Test
	public void selectAll2() {
		List<Artical> articals = mapper.selectAll2();
		System.out.println(articals);
		Assert.assertTrue(articals.size()>0);
	}

	@Test
	public void selectAll3() {
		List<Artical> articals = mapper.selectAll3();
		System.out.println(articals);
		Assert.assertTrue(articals.size()>0);
	}
}
