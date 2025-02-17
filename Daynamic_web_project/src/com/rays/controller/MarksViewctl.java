package com.rays.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.MarksheetBean;
import com.rays.model.MarksheetModel;
@WebServlet("/MarksViewctl.do")
public class MarksViewctl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("marksAdd.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		int physics = Integer.parseInt(request.getParameter("physics"));
		int chemestry = Integer.parseInt(request.getParameter("chemestry"));
		int maths = Integer.parseInt(request.getParameter("maths"));

		MarksheetBean bean = new MarksheetBean();

		MarksheetModel model = new MarksheetModel();

		try {
			bean.setName(name);
			bean.setPhysics(physics);
			bean.setChemestry(chemestry);
			bean.setMaths(maths);

			model.add(bean);

			request.setAttribute("msg", "Data insert successfully");

			RequestDispatcher rd = request.getRequestDispatcher("marksAdd.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
