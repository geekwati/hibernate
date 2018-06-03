package org.bl;

import java.util.List;

import org.dbutil.DBUtil;
import org.domain.UserDetail;

public class UserDetailBl {
	DBUtil dbUtil = new DBUtil();
		
	public boolean create(UserDetail user) {
		if(user.getUserName().isEmpty()) {
			return false;
		}
		List<Object> l = getList();
		for(Object ob : l) {
			if(((UserDetail)ob).getUserName().equals(user.getUserName()))
				return false;
		}
			
		return dbUtil.save(user);
	}

	public List<Object> getList() {
		List<Object> l = dbUtil.getList("FROM UserDetail");
		return l;
	}
	public UserDetail getUser(Integer uId) {
		UserDetail user = new UserDetail();
		user.setUserId(uId);
		return (UserDetail)dbUtil.fetch(user, uId);
	}
}


