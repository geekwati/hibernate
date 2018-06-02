package org.bl;

import java.util.List;

import org.dbutil.DBUtil;
import org.domain.Role;

public class RoleBl {
	DBUtil dbUtil = new DBUtil();
	
	public boolean create(Role role) {
		if(role.getRoleName().isEmpty()) {
			return false;
		}
		List<Object> l = dbUtil.getList("FROM Role");
		for(Object ob : l) {
			if(((Role)ob).getRoleName().equals(role.getRoleName()))
				return false;
		}
			
		return dbUtil.save(role);
	}

	public List<Object> getList() {
		List<Object> l = dbUtil.getList("FROM Role");
		return l;
	}
	public Role getRole(Integer rId) {
		Role role = new Role();
		role.setRoleId(rId);
		return (Role)dbUtil.fetch(role, rId);
	}
}
