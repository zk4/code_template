package com.zk.dao;

import com.zk.entity.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Tests for {@link CityMapper}.
 * 
 * @author wonwoo
 * @since 1.2.1
 */
@RunWith(SpringRunner.class)
@MybatisTest
public class CityMapperTest {

  @Autowired
  private CityMapper cityMapper;

  @Test
  public void findByStateTest() {
    City city = cityMapper.findByState("CA");
    assertThat(city.getId()).isEqualTo(1);
    assertThat(city.getName()).isEqualTo("San Francisco");
    assertThat(city.getState()).isEqualTo("CA");
    assertThat(city.getCountry()).isEqualTo("US");
  }

}