package com.rays.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.StudentBean;
import com.rays.bean.UserBean;
import com.rays.model.StudentModel;
import com.rays.model.UserModel;


@WebServlet("/StudentList.do")
public class studentListctl extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();
		List list = new ArrayList();
		try {
			list = model.search(bean);
			req.setAttribute("list",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("StudentList.jsp");
		rd.forward(req, resp);
		  
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
		  StudentModel model = new StudentModel();
		  StudentBean bean = new StudentBean();
		String op = req.getParameter("operation");
		System.out.println("op = " + op);

		String[] ids = req.getParameterValues("ids");

		if (op.equals("delete")) {

			if (ids != null && ids.length > 0) {

				for (String id : ids) {

					try {
						model.delete(Integer.parseInt(id));
						
					} catch (Exception e) {
						// TODO: handle exception
					}

				}

			} else {
				System.out.println("select at least one record");
			}

		}

		try {
			List list = model.search(bean);
			req.setAttribute("list", list);
		} catch (Exception e) {
			// TODO: handle exception
		}
          resp.sendRedirect("StudentList.do");
		//RequestDispatcher rd = req.getRequestDispatcher("StudentList.jsp");
		//rd.forward(req, resp);
	}
		  
		
	}


