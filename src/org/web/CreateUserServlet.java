package org.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.domain.UserDetail;
import org.domain.Role;
import org.service.Service;


@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service s = new Service();
		String userName = request.getParameter("userName");
		String[] rIds=request.getParameterValues("checkedIds[]");
		
		System.out.println("userName= "+userName);
		
		System.out.println("rid.length()= "+rIds.length);
		UserDetail user = new UserDetail();
		user.setUserName(userName);
		
		for(int i=0;i<rIds.length;i++) {
			System.out.println("rIds= "+rIds[i]);
			Role role = s.getRole(Integer.valueOf(rIds[i]));
			user.getRoleList().add(role);
			
		}
		
		//role.setPermissionList(permList);
		
		boolean flag = s.createUser(user);
		String status;
		Boolean success;
		HttpSession session=request.getSession();
		if (flag) {
			success = true;
			status="Your User has been successfully created.";
			System.out.println(status);
			session.setAttribute("status",status);
		} else {
				success = false;
				status="Error while creating User!";
				System.out.println(status);
			}
		PrintWriter out = response.getWriter();
		out.print(String.format("{\"success\":\"%s\", \"status\":\"%s\"}", success, status));
		out.flush();
	}

}
