package com.rays.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;
@WebServlet("/FirstViewctl")
public class FirstViewctl  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("FirstView.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String loginId  = request.getParameter("loginId");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		
		try {
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setLoginId(loginId);
			bean.setPassword(password);
			bean.setAddress(address);
			bean.setDob(sdf.parse(dob));
			
			model.Add(bean);
			 request.setAttribute("msg", "Data Insert Sucessfully");
			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
			  
			  rd.forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
 	}

}
