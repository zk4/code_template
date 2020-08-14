package com.zk.dao;

import com.zk.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Eddú Meléndez
 */
@Mapper
public interface CityMapper {

  @Select("select id, name, state, country from city where state = #{state}")
  public City findByState(@Param("state") String state);

}