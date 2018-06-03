package org.service;

import java.util.List;


import org.bl.PermissionBl;
import org.bl.RoleBl;
import org.bl.UserDetailBl;
import org.domain.Permission;
import org.domain.Role;
import org.domain.UserDetail;

public class Service {
	public boolean createPermission(Permission perm) {
		PermissionBl permBl = new PermissionBl();
		boolean status= permBl.create(perm);
		return status;
		
	}
	public  List<Object> getPermissionList() {
		PermissionBl permBl = new PermissionBl();
		return permBl.getList();

	}
	public Permission getPermission(Integer pId) {
		PermissionBl permBl = new PermissionBl();
		
		return permBl.getPermission(pId);
	}
	public List<Object> getRoleList() {
		RoleBl roleBl = new RoleBl();
		return roleBl.getList();
	}
	public Role getRole(Integer rId) {
		RoleBl roleBl = new RoleBl();
		return roleBl.getRole(rId);
	}
	public boolean createRole(Role role) {
		RoleBl roleBl = new RoleBl();
		boolean status= roleBl.create(role);
		return status;
	}
	public List<Object> getUserList() {
		UserDetailBl userBl = new UserDetailBl();
		return userBl.getList();
	}
	public UserDetail getUser(Integer uId) {
		UserDetailBl roleBl = new UserDetailBl();
		return roleBl.getUser(uId);
	}
	public boolean createUser(UserDetail user) {
		UserDetailBl userBl = new UserDetailBl();
		boolean status= userBl.create(user);
		return status;
	}
	
	
}
