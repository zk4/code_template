package com.zk.mapper;

import com.zk.entity.Dept;
import com.zk.entity.DeptExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class DeptMapperExtTest {

    DeptMapperExt mapper;

    SqlSessionFactory build;

    SqlSession sqlSession;
    @Before
    public void setUp() throws Exception {
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
        build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //   参数 true 自动提交事务
        sqlSession = build.openSession(true);
        mapper = sqlSession.getMapper(DeptMapperExt.class);
    }
    @Test
    public void selectDepts() {
        List<Dept> depts = mapper.selectDepts();
        for (Dept dept : depts) {
            System.out.println(dept);
        }
        Assert.assertTrue(depts.size()>0);

    }

    @Test
    public void selectDeptsByExample() {
        DeptExample deptExample = new DeptExample();
        DeptExample.Criteria criteria = deptExample.createCriteria();
        DeptExample.Criteria criteria1 = criteria.andIdEqualTo(1);
        List<Dept> depts = mapper.selectByExample(deptExample);

        for (Dept dept : depts) {
            System.out.println(dept);
        }
        Assert.assertTrue(depts.size()>0);

    }

}