package com.zk.mapper;

import com.zk.entity.Dept;
import com.zk.entity.DeptExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Dept
     *
     * @mbg.generated Tue Mar 10 13:09:23 CST 2020
     */
    long countByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Dept
     *
     * @mbg.generated Tue Mar 10 13:09:23 CST 2020
     */
    int deleteByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Dept
     *
     * @mbg.generated Tue Mar 10 13:09:23 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Dept
     *
     * @mbg.generated Tue Mar 10 13:09:23 CST 2020
     */
    int insert(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Dept
     *
     * @mbg.generated Tue Mar 10 13:09:23 CST 2020
     */
    int insertSelective(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Dept
     *
     * @mbg.generated Tue Mar 10 13:09:23 CST 2020
     */
    List<Dept> selectByExample(DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Dept
     *
     * @mbg.generated Tue Mar 10 13:09:23 CST 2020
     */
    Dept selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Dept
     *
     * @mbg.generated Tue Mar 10 13:09:23 CST 2020
     */
    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Dept
     *
     * @mbg.generated Tue Mar 10 13:09:23 CST 2020
     */
    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Dept
     *
     * @mbg.generated Tue Mar 10 13:09:23 CST 2020
     */
    int updateByPrimaryKeySelective(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Dept
     *
     * @mbg.generated Tue Mar 10 13:09:23 CST 2020
     */
    int updateByPrimaryKey(Dept record);
}