package com.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.StudentBean;
import com.rays.model.StudentModel;
@WebServlet("/AddStudentctl.do")
public class AddStudentctl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("AddStudent.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  String name = req.getParameter("name");
		  String subject = req.getParameter("subject");
		  String collage = req.getParameter("collage");
		  String address = req.getParameter("address");
		  
		  try {
			  StudentBean bean = new StudentBean();
			  StudentModel model = new StudentModel();
			  
			  bean.setName(name);
			  bean.setSubject(subject);
			  bean.setCollage(collage);
			  bean.setAddress(address);
			model.add(bean);
			
			req.setAttribute("msg","Data insert successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  RequestDispatcher rd = req.getRequestDispatcher("AddStudent.jsp");
		  rd.forward(req, resp);
		  
	}
	
}
