package net.javaguides.usermanagement.dao;
//this DAO class provides CRUD database operations for the table users in the database.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.usermanagement.model.User;

public class UserDao {

	private String jdbcURL="jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername="root";
	private String jdbcPassword="abcd";
	
	private static final String INSERT_USERS_SQL="INSERT INTO users" + "(name, email, country)VALUES"+ "(?, ?, ?);";
	
	private static final String SELECT_USER_BY_ID="select id, name, email, country from user where id=?";
	private static final String SELECT_ALL_USERS ="select * from users ";
	private static final String DELETE_USERS_SQL="delete from users where id=?;";
	private static final String UPDATE_USERS_SQL ="update users set name=?, email=?, country=? where id=?;";
			
	protected Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return connection;
	}
			//Create or insert user
	public void insertUser(User user)throws SQLException{
		try(Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL)){
			preparedStatement.setString(1,  user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3,  user.getCountry());
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	        //update user
	public boolean updateUser(User user)throws SQLException{
		boolean rowUpdated;
		try(Connection connection=getConnection();
				PreparedStatement statement=connection.prepareStatement(UPDATE_USERS_SQL);){
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setInt(4,user.getId());
			
			rowUpdated=statement.executeUpdate()>0;
			
			
		}
		
		return rowUpdated;
	}
	        //select user by  id
	public User selectUser(int id) {
		User user=null;
		// Step1: Establishing a Connection
		try(Connection connection=getConnection();
				//step2:  Creating a statement using Connection object
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);){
		preparedStatement.setInt(1, id);
		System.out.println(preparedStatement);
		//step3: execute the query or update query
		ResultSet rs=preparedStatement.executeQuery();
		
		//Step4: process the Resultset object
		while(rs.next()) {
			String name=rs.getString("name");
			String email=rs.getString("email");
			String country=rs.getString("country");
			user=new User(id, name, email, country);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	       //select users
	public  List<User> selectAllUsers(){
		List<User> users =new ArrayList<>();
		try(Connection connection=getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);){
			System.out.println(preparedStatement);
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String country=rs.getString("country");
				users.add(new User(id, name, email, country));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	       //delete users
	public boolean deleteUser(int id)throws SQLException{
		boolean rowDeleted;
		try(Connection connection=getConnection();
			   PreparedStatement statement=connection.prepareStatement(DELETE_USERS_SQL);){
			statement.setInt(1, id);
			rowDeleted=statement.executeUpdate()>0;
		}
		return rowDeleted;
	}
}
