package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.pool2.DestroyMode;

import dao.LoginDAO;

import entry.Login;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO logindao;
	
	public void init() {
		logindao = new LoginDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		try {
			switch (action) {
			case "/reg":
				insertUser(request,response);
				break;
			case "/check":
                checkUser(request, response);
			case "/forget":
                passwordforget(request, response);
				break;
			case "/":
				response.sendRedirect("login.jsp");
				break;
			default:
				break;
			}
			
		} catch (Exception e) {
		  
		}
		
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		Login newUser = new Login(name, email, password);
		
		
		if ((email != "") && (name != "") ){
			if (password.equals(cpassword)) {
			
		if (LoginDAO.existinguser(email)) {
			 request.setAttribute("error", "This User Already Exist");
			 RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");  
		     rd.forward(request,response); 
			
		}
		else {
			
			logindao.insertUser(newUser);
			response.sendRedirect("login.jsp");
			
		}
			}
			else {
				 request.setAttribute("cerror", "Miss Match password & Conform Password");
				 RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");  
			     rd.forward(request,response); 
				
			}
		}
		else {
			 request.setAttribute("error", "Please Fill The values");
			 RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");  
		     rd.forward(request,response); 
		}
		
	}
	private void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		String email = request.getParameter("email");
		String dremail = "Dr."+(request.getParameter("email"));
		String password = request.getParameter("password");
		
		 if (LoginDAO.selectAllUsers(email,password)) {
			 String name = null;
			String name1 = LoginDAO.getname(email,name);
			 request.setAttribute("email", name1);
			 RequestDispatcher rd=request.getRequestDispatcher("/user");  
		      rd.forward(request,response);

			
		 }
		 else if (LoginDAO.selectAllDoctors(dremail,password)) {
			 request.setAttribute("name", dremail);
			 RequestDispatcher rd=request.getRequestDispatcher("DoctorServlet");  
		      rd.forward(request,response);

			
		 }
		 
		 
		 else {			 
	     request.setAttribute("error", "Check your username and password");
		 RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
	     rd.forward(request,response); 
	     }
		
	    
		
		
		
	}
	
	private void passwordforget(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
		if (LoginDAO.passforget(email,password)) {
			response.sendRedirect("login.jsp");
		}
		else {
			request.setAttribute("error", "This Email didn't register");
			 RequestDispatcher rd=request.getRequestDispatcher("forget.jsp");  
		     rd.forward(request,response); 
		     }
			
		}
		
	}

	
	


