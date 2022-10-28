package com.etc.my.dto;

/**
 * 分页查询封装的类
 */
public class PageDto {
	private Integer page ;//当前页
	private Integer size ;//当前页条数
	private Integer maxPage ;//最大页
	private String key = "";//查询的关键字
	private Object keyWords;//查询的多个关键字
	private Object olist;//查询出来的数据

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(Object keyWords) {
		this.keyWords = keyWords;
	}

	public Object getOlist() {
		return olist;
	}

	public void setOlist(Object olist) {
		this.olist = olist;
	}

}
