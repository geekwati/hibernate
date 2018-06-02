package org.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.domain.Permission;
import org.service.Service;

@WebServlet("/createPermission")
public class CreatePermissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String permName = request.getParameter("permName");
		Permission perm = new Permission();
		perm.setPermissionName(permName);
		Service s = new Service();
		boolean flag = s.createPermission(perm);
		String status;
		Boolean success;
		HttpSession session=request.getSession();
		if (flag) {
			success = true;
			status="Your permission has been successfully created.";
			System.out.println(status);
			session.setAttribute("status",status);
		} else {
				success = false;
				status="Error while creating permission!";
				System.out.println(status);
			}
		PrintWriter out = response.getWriter();
		out.print(String.format("{\"success\":\"%s\", \"status\":\"%s\"}", success, status));
		out.flush();
	}
	

}
