package com.rays.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import com.mysql.cj.Session;
import com.rays.bean.UserBean;
import com.rays.model.UserModel;
@WebServlet("/Loginctl")
public class Loginctl  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String op = req.getParameter("operation");

		System.out.println("op = " + op);

		HttpSession session = req.getSession();

		if (op != null) {
			session.invalidate();
			req.setAttribute("msg", "user logout successfully");
		}

		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String loginId  =req.getParameter("loginId");
		String password = req.getParameter("password");
		
		UserBean user = new UserBean();
		UserModel model  = new UserModel();
		HttpSession session = req.getSession();
		
		user.setLoginId(loginId);
		user.setPassword(password);
		
		try {
		 user = model.Loginid(loginId, password);
		 
		 if(user != null) {
			 req.setAttribute("msg","Login succesfully");
			 session.setAttribute("user", user);
			 RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
			 rd.forward(req, resp);
		 }
		 else {
			req.setAttribute("msg","Login id and pasword invalid");
			RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
			rd.forward(req, resp);
		 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
