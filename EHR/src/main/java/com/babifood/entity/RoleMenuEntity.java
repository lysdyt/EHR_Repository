package com.babifood.entity;

import org.springframework.stereotype.Component;

@Component
public class RoleMenuEntity {
	private String id;
	private String text;
	private String authority_code;
	private String flag;
	private String role_id;
	private String role_name;
	
	public RoleMenuEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthority_code() {
		return authority_code;
	}

	public void setAuthority_code(String authority_code) {
		this.authority_code = authority_code;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	
}
