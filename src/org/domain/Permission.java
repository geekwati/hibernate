package org.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name= "permissions")
public class Permission {
	@Id @GeneratedValue
	private int permissionId;
	private String permissionName;
	
//	@ManyToOne
//	private Roles role;
//	
//	public Roles getRole() {
//		return role;
//	}
//	public void setRole(Roles role) {
//		this.role = role;
//	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPmermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	
}
