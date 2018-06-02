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
@Table (name="roles")
public class Role {
	@Id @GeneratedValue
	private int roleId;
	private String roleName;
	
	//@ElementCollection(fetch=FetchType.EAGER)
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@Fetch(value=FetchMode.SELECT)
	private Collection<Permission> permissionList = new ArrayList<Permission>();
		
	public Collection<Permission> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(Collection<Permission> permissionList) {
		this.permissionList = permissionList;
	}
//	public UserDetails getUser() {
//		return user;
//	}
//	public void setUser(UserDetails user) {
//		this.user = user;
//	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
