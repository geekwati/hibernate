package org.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="userdetails")
public class UserDetail {
	@Id @GeneratedValue
	private int userId;
	private String userName;
	private String phoneNo;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@Fetch(value=FetchMode.SELECT)
	private Collection<Role> roleList = new ArrayList<Role>();
	
	public Collection<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(Collection<Role> roleList) {
		this.roleList = roleList;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
