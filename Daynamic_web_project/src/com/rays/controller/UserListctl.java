package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserListctl.do")
public class UserListctl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		try {
			int pageNo = 1;
			int pageSize = 5;
			List list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageSize", pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		String op = request.getParameter("operation");
		System.out.println("op = " + op);
		int pageNo = 1;
		int pageSize = 5;
		String[] ids = request.getParameterValues("ids");
		

		if (op.equals("delete")) {

			if (ids != null && ids.length > 0) {

				for (String id : ids) {

					try {
						model.delete(Integer.parseInt(id));

					} catch (Exception e) {
						// TODO: handle exception
					}

				}

			}
		}

		if (op.equals("next")) {

			System.out.println("in next condition");

			pageNo = Integer.parseInt(request.getParameter("pageNo"));

			System.out.println("pageNo == " + pageNo);

			pageNo++;

		}

		if (op.equals("previous")) {

			pageNo = Integer.parseInt(request.getParameter("pageNo"));

			pageNo--;

		}
		
		if(op.equals("search")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String loginId = request.getParameter("loginId");
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setAddress(address);
			bean.setLoginId(loginId);
       		}

		try {
			List list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("pageSize", pageSize);
		} catch (Exception e) {
			// TODO: handle exception
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		rd.forward(request, response);
	}

}
