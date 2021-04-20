package com.learners;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learners.hibernate.DAO.UsersDAO;
import com.learners.hibernate.entity.Users;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// System.out.println("Home Servlet Get");
		String action = request.getParameter("action");
		RequestDispatcher dispatcher;
		switch (action) {
		case "logout":
			request.getSession().invalidate();
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		// System.out.println("Home Servlet Post");
		request.getSession().invalidate();
		String action = request.getParameter("action");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		switch (action) {
		case "login":
			List<Users> users = new UsersDAO().getUser(email, password);
			String name = null;
			for (Users user : users) {
				name = user.getName();
			}
			System.out.println(name);
			if (!users.isEmpty()) {
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(300);
				session.setAttribute("name", name);
				session.setAttribute("email", email);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			break;

		default:
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		}
	}

}
