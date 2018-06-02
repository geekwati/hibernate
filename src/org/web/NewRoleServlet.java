package org.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.domain.Permission;
import org.service.Service;


@WebServlet("/newRole")
public class NewRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service s = new Service();
    	List<Object> l = s.getPermissionList();
    	ArrayList <Permission> list = new ArrayList<Permission>();
		for(Object ob : l)
			list.add((Permission)ob);
    	System.out.println(list);
    	RequestDispatcher view = null;
    	if(list.isEmpty())
    		view = request.getRequestDispatcher("jsp/permission/emptyList.jsp");
    	else {
    		request.setAttribute("listPerm",list);
    		view = request.getRequestDispatcher("jsp/role/new.jsp");
    	}
    	
		view.include(request,response);
	}

}
