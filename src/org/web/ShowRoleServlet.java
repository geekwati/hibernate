package org.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.domain.Role;
import org.service.Service;


@WebServlet("/showRole")
public class ShowRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service s = new Service();
		Integer rId=Integer.valueOf(request.getParameter("rId"));
		System.out.println(rId);
		Role role=s.getRole(rId);
		request.setAttribute("role",role);
		System.out.println(role.getRoleId());
		System.out.println(role.getRoleName());
		System.out.println(role.getPermissionList());
		RequestDispatcher view=request.getRequestDispatcher("jsp/role/detail.jsp");
		view.forward(request,response);
	}

}
