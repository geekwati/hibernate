package org.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.domain.UserDetail;
import org.service.Service;


@WebServlet("/showUser")
public class ShowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service s = new Service();
		Integer uId=Integer.valueOf(request.getParameter("uId"));
		System.out.println(uId);
		UserDetail user=s.getUser(uId);
		request.setAttribute("user",user);
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
		System.out.println(user.getRoleList());
		RequestDispatcher view=request.getRequestDispatcher("jsp/user-detail/detail.jsp");
		view.forward(request,response);
	}

}
