package com.zk.mapper;

import com.zk.entity.Artical;

import java.util.List;

public interface ArticalMapper {

	public List<Artical> selectAll();
	public List<Artical> selectAll2();
	//以下在企业里常用,分步查,但性能上有损耗
	public List<Artical> selectAll3();
}
