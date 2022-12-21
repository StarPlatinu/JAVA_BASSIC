package fa.training.dao;

import java.sql.Connection;
import fa.training.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fa.training.entity.employee;
import fa.training.util.DBConnection;

public class employeeDao {
	public  employee getAccount(String account, String password) {
		PreparedStatement prepareStatement = null;
		java.sql.ResultSet rs = null;
		try {
			Connection connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement("SELECT * FROM employee WHERE account = ? AND password = ?");
			prepareStatement.setString(1, account);
			prepareStatement.setString(2, new Validation().encodedPassword(password));
			rs = prepareStatement.executeQuery();
			while (rs.next()) {
				employee emp = employee.builder()
						.employeeId(rs.getInt(1))
						.account(rs.getString(2))
						.department(rs.getString(3))
						.employeeAddress(rs.getString(4))
						.employeeBirthdate(rs.getString(5))
						.employeeEmail(rs.getString(6))
						.employeeName(rs.getString(7))
						.employeePhone(rs.getString(8))
						.password(new Validation().decodePassword(rs.getString(9)))
						.sex(rs.getString(10))
						.role(rs.getInt(11))
						.build();
				return emp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return null;
	}

	public static List<employee> getAll() {
		List<employee> list = new ArrayList<>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			Connection connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement("Select * from employee");
			rs = prepareStatement.executeQuery();
			while (rs.next()) {
				employee emp = employee.builder()
						.employeeId(rs.getInt(1))
						.account(rs.getString(2))
						.department(rs.getString(3))
						.employeeAddress(rs.getString(4))
						.employeeBirthdate(rs.getString(5))
						.employeeEmail(rs.getString(6))
						.employeeName(rs.getString(7))
						.employeePhone(rs.getString(8))
						.password(rs.getString(9))
						.sex(rs.getString(10))
						.role(rs.getInt(11))
						.build();
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return list;
	}

	public List<employee> getListByPage(List<employee> list, int start, int end) {
		List<employee> arr = new ArrayList<>();
		for (int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
	}
	
	public employee getEmployeeByEmail(String account, String password) {
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement("select * from employee where account = ? and password = ?");
			prepareStatement.setString(1, account);
			prepareStatement.setString(2, password);
			rs = prepareStatement.executeQuery();
			while (rs.next()) {
		employee emp = employee.builder()
				.employeeId(rs.getInt(1))
				.account(rs.getString(2))
				.department(rs.getString(3))
				.employeeAddress(rs.getString(4))
				.employeeBirthdate(rs.getString(5))
				.employeeEmail(rs.getString(6))
				.employeeName(rs.getString(7))
				.employeePhone(rs.getString(8))
				.password(rs.getString(9))
				.sex(rs.getString(10))
				.role(rs.getInt(11))
				.build();
				return emp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return null;
	}

	public List<employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		List<employee> list = new ArrayList<>();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection
					.prepareStatement("Select * from employee where employeeName like '%" + name + "%'");
			rs = prepareStatement.executeQuery();
			while (rs.next()) {
					employee emp = employee.builder()
						.employeeId(rs.getInt(1))
						.account(rs.getString(2))
						.department(rs.getString(3))
						.employeeAddress(rs.getString(4))
						.employeeBirthdate(rs.getString(5))
						.employeeEmail(rs.getString(6))
						.employeeName(rs.getString(7))
						.employeePhone(rs.getString(8))
						.password(rs.getString(9))
						.sex(rs.getString(10))
						.role(rs.getInt(11))
						.build();
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, rs);
		}
		return list;
	}

	public void addEmployee(employee emp) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement = null;

		try {
			Connection connection = DBConnection.SQLCONNECTION.getConnection();
			prepareStatement = connection.prepareStatement(
					"INSERT INTO [dbo].[employee]\r\n"
					+ "           ([account]\r\n"
					+ "           ,[department]\r\n"
					+ "           ,[employeeAddress]\r\n"
					+ "           ,[employeeBirthdate]\r\n"
					+ "           ,[employeeEmail]\r\n"
					+ "           ,[employeeName]\r\n"
					+ "           ,[employeePhone]\r\n"
					+ "           ,[password]\r\n"
					+ "           ,[sex]\r\n"
					+ "           ,[role])\r\n"
					+ "     VALUES\r\n"
					+ "           (?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?\r\n"
					+ "           ,?)");
			prepareStatement.setString(1, emp.getAccount());
			prepareStatement.setString(2,emp.getDepartment());
			prepareStatement.setString(3, emp.getEmployeeAddress());
			prepareStatement.setString(4, emp.getEmployeeBirthdate());
			prepareStatement.setString(5, emp.getEmployeeEmail());
			prepareStatement.setString(6, emp.getEmployeeName());
			prepareStatement.setString(7, emp.getEmployeePhone());
			prepareStatement.setString(8, emp.getPassword());
			prepareStatement.setString(9, emp.getSex());
			prepareStatement.setInt(10, emp.getRole());
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResource(null, prepareStatement, null);
		}
	}

}
