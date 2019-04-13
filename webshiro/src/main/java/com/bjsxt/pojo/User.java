package com.bjsxt.pojo;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{
	private long id;
	private String username;
	private String password;
	private String photo;
	
	private List<Menu> menus;
//	private List<Role> roles;
//	private List<Permission> permission;
	
	
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", photo=" + photo + ", menus="
				+ menus + "]";
	}
	
}	
