package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DoctorDAO;
import dao.UserDAO;
import entry.Doctor;
import entry.User;

@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private DoctorDAO doctorDAO;
	
	public void init() {
		doctorDAO = new DoctorDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/uinsert":
				insertDoctor(request, response);
				break;
			case "/delete":
				deleteDoctor(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/uupdate":
				updateDoctor(request, response);
				break;
			default:
				listDoctor(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listDoctor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = UserDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/userlist.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("userform.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Doctor existingUser = doctorDAO.selectDoctor(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("userform.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertDoctor(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String type = request.getParameter("type");
		String time = request.getParameter("time");
		User newUser = new User(name, email, mobile,type,time);
		doctorDAO.insertDoctor(newUser);
		response.sendRedirect("DoctorServlet");
	}

	private void updateDoctor(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String type = request.getParameter("type");
		String time = request.getParameter("time");
		User apvalues = new User(id, name, email, mobile,type,time);
		doctorDAO.updateDoctor(apvalues);
		
		response.sendRedirect("DoctorServlet");
	}

	private void deleteDoctor(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		doctorDAO.deleteDoctor(id);
		response.sendRedirect("DoctorServlet");

	}

}