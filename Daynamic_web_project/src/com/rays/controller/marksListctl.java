package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.MarksheetBean;
import com.rays.bean.UserBean;
import com.rays.model.MarksheetModel;
import com.rays.model.UserModel;

@WebServlet("/marksListctl.do")
public class marksListctl extends HttpServlet{

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	MarksheetBean bean = new MarksheetBean();
	MarksheetModel model = new MarksheetModel();
	
	try {
		List list = model.search();
		
		request.setAttribute("list", list);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	RequestDispatcher rd = request.getRequestDispatcher("marksView.jsp");
	rd.forward(request, response);
}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    MarksheetBean bean = new MarksheetBean();
    MarksheetModel model = new MarksheetModel();
	String op = request.getParameter("operation");
	System.out.println("op = " + op);

	String[] ids = request.getParameterValues("ids");
	

	if (op.equals("delete")) {

		if (ids != null && ids.length > 0) {

			for (String id : ids) {

				try {
					System.out.println("Run");
					System.out.println(id);
					model.Delete(Integer.parseInt(id));
				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		} else {
			System.out.println("select at least one record");
		}

	}

        response.sendRedirect("marksListctl.do");
}
	
	
	}

