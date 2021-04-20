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
import com.learners.hibernate.DAO.TeacherDAO;
import com.learners.hibernate.entity.Myclass;
import com.learners.hibernate.entity.Student;
import com.learners.hibernate.entity.SubjectClass;

/**
 * Servlet implementation class ClassServlet
 */
@WebServlet("/ClassServlet")
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		List<String> myclass = new ClassDAO().getClassList();
		RequestDispatcher dispatcher;
		switch (action) {
		case "student":
			List<String> students = new StudentDAO().getStudentList();
			request.setAttribute("listclass", myclass);
			request.setAttribute("liststudent", students);
			dispatcher = request.getRequestDispatcher("class_student.jsp");
			dispatcher.forward(request, response);
			break;
		case "subject":
			List<String> subjects = new SubjectClassDAO().getClassWiseSubject(null);
			request.setAttribute("listclass", myclass);
			request.setAttribute("listsubject", subjects);
			dispatcher = request.getRequestDispatcher("class_subject.jsp");
			dispatcher.forward(request, response);
			break;
		case "teacher":
			List<String> teachers = new SubjectClassDAO().getClassTeacher(null);
			request.setAttribute("listclass", myclass);
			request.setAttribute("listteacher", teachers);
			dispatcher = request.getRequestDispatcher("class_teacher.jsp");
			dispatcher.forward(request, response);
			break;
		default:
			listClass(request,response);
			break;
		}
	}

	private void listClass(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<String> myclass = new ClassDAO().getClassList();
		List<String> teacher = new TeacherDAO().getTeacherList();
		List<String> subject = new SubjectDAO().getSubjectList();
		request.setAttribute("listclass", myclass);
		request.setAttribute("listteacher", teacher);
		request.setAttribute("listsubject", subject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class_list.jsp");
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
		List<String> myclass = new ClassDAO().getClassList();
		RequestDispatcher dispatcher;
		switch (action) {
		case "assign_teacher":
			String subject = request.getParameter("subject");
			String mclass = request.getParameter("class");
			String teacher = request.getParameter("teacher");
			SubjectClass subjectClass = new SubjectClass(mclass,subject,teacher);
			new SubjectClassDAO().insertData2(subjectClass);
			listClass(request,response);
			break;
		case "student":
			String classname = request.getParameter("class");
			List<String> students = new StudentDAO().getClassWiseStudent(classname);
			request.setAttribute("listclass", myclass);
			request.setAttribute("liststudent", students);
			dispatcher = request.getRequestDispatcher("class_student.jsp");
			dispatcher.forward(request, response);
			break;
		case "subject":
			String parclass = request.getParameter("class");
			List<String> subjects = new SubjectClassDAO().getClassWiseSubject(parclass);
			request.setAttribute("listclass", myclass);
			request.setAttribute("listsubject", subjects);
			dispatcher = request.getRequestDispatcher("class_subject.jsp");
			dispatcher.forward(request, response);
			break;
		case "teacher":
			String parmclass = request.getParameter("class");
			List<String> teachers = new SubjectClassDAO().getClassTeacher(parmclass);
			request.setAttribute("listclass", myclass);
			request.setAttribute("listteacher", teachers);
			dispatcher = request.getRequestDispatcher("class_teacher.jsp");
			dispatcher.forward(request, response);
			break;
		default:
			listClass(request,response);
			break;
		}
	}

}
