package org.web;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.domain.Role;
import org.domain.Permission;
import org.service.Service;


@WebServlet("/createRole")
public class CreateRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service s = new Service();
		String roleName = request.getParameter("roleName");
		String[] pIds=request.getParameterValues("checkedIds[]");
		
		System.out.println("rolename= "+roleName);
		
		System.out.println("pid.length()= "+pIds.length);
		Role role = new Role();
		role.setRoleName(roleName);
		
		for(int i=0;i<pIds.length;i++) {
			System.out.println("pIds= "+pIds[i]);
			Permission perm = s.getPermission(Integer.valueOf(pIds[i]));
			role.getPermissionList().add(perm);
			
		}
		
		//role.setPermissionList(permList);
		
		boolean flag = s.createRole(role);
		String status;
		Boolean success;
		HttpSession session=request.getSession();
		if (flag) {
			success = true;
			status="Your Role has been successfully created.";
			System.out.println(status);
			session.setAttribute("status",status);
		} else {
				success = false;
				status="Error while creating Role!";
				System.out.println(status);
			}
		PrintWriter out = response.getWriter();
		out.print(String.format("{\"success\":\"%s\", \"status\":\"%s\"}", success, status));
		out.flush();
	}

}
