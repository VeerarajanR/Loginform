package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entry.Login;
import entry.User;


public class LoginDAO {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "7708703155";

	private static final String INSERT_USERS_SQL = "insert into userlogin(name,email,password) values(?,?,?)";
	private static final String SELECT_ALL_USERS = "select * from userlogin where email = ? and password = ?";
	private static final String SELECT_ALL_existingUSERS = "select * from userlogin where email = ?";
	private static final String SELECT_ALL_Doctors = "select * from doctordetails where name = ? and password = ?";
	private static final String UPDATE_USERS_SQL = "update userlogin set password = ? where email = ?";
	
	protected static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public void insertUser(Login login) throws SQLException {
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, login.getName());
			preparedStatement.setString(2, login.getEmail());
			preparedStatement.setString(3, login.getPassword());
			
			
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public static boolean selectAllUsers(String email,String password) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		boolean status = false;
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			status = rs.next();
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		return status;
	}
	
	public static boolean selectAllDoctors(String email,String password) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		boolean status = false;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Doctors);) {
			
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			status = rs.next();
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		return status;
	}
	
	private static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		
	}
	
}
	public static String getname(String email,String name) throws SQLException {
		
		
		try (Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from userlogin");) {
			
						
			           ResultSet nrs = ps.executeQuery();
						
			           while (nrs.next()) {
							String n = nrs.getString("email");
							
							if (email.equals(n)) {
								name = nrs.getString("name");
							}
							}
}
		return name;
}
	public static boolean existinguser(String email) {
		
		boolean status = false;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_existingUSERS);) {
			
			preparedStatement.setString(1, email);
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			status = rs.next();
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		return status;
	}
	
	public static  boolean passforget(String email,String password) {
		
		boolean status = false;
		
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
			
			preparedStatement.setString(1,password);
			preparedStatement.setString(2,email);
			
			int i = preparedStatement.executeUpdate();
			if (i>0) {
			status = true;
			}
		

		} catch (SQLException e) {
			printSQLException(e);
		}
		return status ;
	}
		
	}
		


