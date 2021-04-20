package com.learners;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learners.hibernate.DAO.ClassDAO;
import com.learners.hibernate.DAO.StudentDAO;
import com.learners.hibernate.DAO.SubjectClassDAO;
import com.learners.hibernate.DAO.SubjectDAO;
import com.learners.hibernate.entity.SubjectClass;

/**
 * Servlet implementation class SubjectSurvlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		listSubjects(request,response);
	}

	private void listSubjects(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<String> subject = new SubjectDAO().getSubjectList();
		List<String> myclass = new ClassDAO().getClassList();
		request.setAttribute("listsubject", subject);
		request.setAttribute("listclass", myclass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject_list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String action = request.getParameter("action");
		switch (action) {
		case "assign_class":
			String subject = request.getParameter("subject");
			String mclass = request.getParameter("class");
			String teacher = "";
			SubjectClass subjectClass = new SubjectClass(mclass,subject,teacher);
			new SubjectClassDAO().insertData(subjectClass);
			listSubjects(request,response);
			break;

		default:
			listSubjects(request,response);
			break;
		}
	}
	
	

}
