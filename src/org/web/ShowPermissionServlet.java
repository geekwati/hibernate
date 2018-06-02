package org.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.domain.Permission;
import org.service.Service;

@WebServlet("/showPermission")
public class ShowPermissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service s = new Service();
		Integer pId=Integer.valueOf(request.getParameter("pId"));
		System.out.println(pId);
		Permission perm=s.getPermission(pId);
		request.setAttribute("perm",perm);
		System.out.println(perm.getPermissionId());
		System.out.println(perm.getPermissionName());
		
		RequestDispatcher view=request.getRequestDispatcher("jsp/permission/detail.jsp");
		view.forward(request,response);
	}

}
