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

import org.domain.UserDetail;
import org.service.Service;


@WebServlet("/getUserList")
public class GetUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service s = new Service();
    	List<Object> l = s.getUserList();
    	ArrayList <UserDetail> list = new ArrayList<UserDetail>();
		for(Object ob : l)
			list.add((UserDetail)ob);
    	System.out.println(list);
    	RequestDispatcher view = null;
    	if(list.isEmpty())
    		view = request.getRequestDispatcher("jsp/user-detail/emptyList.jsp");
    	else {
    		request.setAttribute("list",list);
    		view = request.getRequestDispatcher("jsp/user-detail/list.jsp");
    	}
    	
		view.include(request,response);
	}

}
