package com.zk.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zk.entity.Dept;
import com.zk.entity.DeptExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class DeptMapperTest {
    DeptMapper mapper;

    @Before
    public void setUp() throws Exception {
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
        //   参数 true 自动提交事务
        SqlSession sqlSession = build.openSession(true);
        mapper = sqlSession.getMapper(DeptMapper.class);
    }

    @Test
    public void selectAll() {
        List<Dept> depts = mapper.selectByExample(null);
        for (Dept dept : depts) {
            System.out.println(dept);
        }
    }

    @Test
    public void selectWhere() {
        DeptExample deptExample = new DeptExample();
        DeptExample.Criteria criteria = deptExample.createCriteria();
        criteria.andIdEqualTo(1);
        List<Dept> depts = mapper.selectByExample(deptExample);
        for (Dept dept : depts) {
            System.out.println(dept);
        }
    }

    @Test
    public void selectWhereOr() {
        DeptExample ex = new DeptExample();
        DeptExample.Criteria criteria = ex.createCriteria();
        criteria.andIdEqualTo(1);
        DeptExample.Criteria or = ex.or();
        or.andDeptEqualTo("a");

        List<Dept> depts = mapper.selectByExample(ex);
        for (Dept dept : depts) {
            System.out.println(dept);
        }
    }

    @Test
    public void selectPage() {
        PageHelper.startPage(1,1);
        List<Dept> depts = mapper.selectByExample(null);
        for (Dept dept : depts) {
            System.out.println(dept);
        }
        //navigatePages 相当于 google 搜索下面的 1 2,3, 代表页的导航.
        PageInfo<Dept> deptPageInfo = new PageInfo<>(depts,2);
        System.out.println(deptPageInfo);
    }
}
