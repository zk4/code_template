package com.zk.entity;

import java.util.List;

public class Blog {
	Integer id;
	String name;
	String authorName;
	List<Artical> articalList;

	public List<Artical> getArticalList() {
		return articalList;
	}

	public Blog setArticalList(List<Artical> articalList) {
		this.articalList = articalList;
		return this;
	}

	public String getAuthorName() {
		return authorName;
	}

	public Blog setAuthorName(String authorName) {
		this.authorName = authorName;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public Blog setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}



	public Blog setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "Blog{" +
				"id=" + id +
				", name='" + name + '\'' +
				", authorName='" + authorName + '\'' +
				", articalList=" + articalList +
				'}';
	}
}
