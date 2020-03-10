package com.zk.mapper;

import com.zk.entity.Dept;

import java.util.List;

public interface DeptMapperExt extends  DeptMapper{
    public List<Dept> selectDepts();
}