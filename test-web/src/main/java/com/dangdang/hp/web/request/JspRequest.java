package com.dangdang.hp.web.request;

public class JspRequest {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "JspRequest [name=" + name + "]";
	}

}
