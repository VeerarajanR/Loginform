package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entry.Doctor;
import entry.User;


public class DoctorDAO {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/hospital?characterEncoding=latin1";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "7708703155";

	private static final String INSERT_USERS_SQL = "INSERT INTO doctordetails" + "  (name, type, time) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,name,type,time from doctordetails where id =?";
	private static final String SELECT_ALL_USERS = "select * from doctordetails";
	private static final String DELETE_USERS_SQL = "delete from doctordetails where id = ?;";
	private static final String UPDATE_USERS_SQL = "update userdetails set name = ?,email= ?,mobile=?, type =?,time=? where id = ?";

	public DoctorDAO() {
	}

	protected static  Connection getConnection() {
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

	public void insertDoctor(User user) throws SQLException {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getMobile());
			preparedStatement.setString(4, user.getType());
			preparedStatement.setString(5, user.getTime());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Doctor selectDoctor(int id) {
		Doctor doctor = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String type = rs.getString("type");
				String time = rs.getString("time");
				doctor = new Doctor(id, name, type, time);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return doctor;
	}

	public static  List<Doctor> selectAllDoctors() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Doctor> doctors = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				String time = rs.getString("time");
				doctors.add(new Doctor(id, name, type, time));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return doctors;
	}

	public boolean deleteDoctor(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateDoctor(User user) throws SQLException {
         boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getMobile());
			statement.setString(4, user.getType());
			statement.setString(5, user.getTime());
			statement.setInt(6, user.getId());
			

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
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

}

