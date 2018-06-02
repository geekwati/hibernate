package org.bl;


import java.util.List;

import org.dbutil.DBUtil;
import org.domain.Permission;

public class PermissionBl {
	DBUtil dbUtil = new DBUtil();
	
	public boolean create(Permission perm) {
		if(perm.getPermissionName().isEmpty()) {
			return false;
		}
		List<Object> l = dbUtil.getList("FROM Permission");
		for(Object ob : l) {
			if(((Permission)ob).getPermissionName().equals(perm.getPermissionName()))
				return false;
		}
			
		return dbUtil.save(perm);
	}
//	public static List<Permissions> getPermissions(){
//		List<Permissions> list = (List<Permissions>)DBUtil.getList("from Permissions");
//		return list;
//		
//	}
	public List<Object> getList() {
		List<Object> l = dbUtil.getList("FROM Permission");
		/*ArrayList <Permission> list = new ArrayList<Permission>();
		for(Object ob : l)
			list.add((Permission)ob); */
		return l;
	}
	public Permission getPermission(Integer pId) {
		Permission perm = new Permission();
		perm.setPmermissionId(pId);
		return (Permission)dbUtil.fetch(perm, pId);
	}
}
