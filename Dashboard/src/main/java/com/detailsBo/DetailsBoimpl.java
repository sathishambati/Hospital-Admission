package com.detailsBo;

import java.util.List;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modules.Patientinfo;

public class DetailsBoimpl implements DetailsBo{
	private static Connection connection =null;
	private static PreparedStatement statement =null;
	private static Statement createStatement = null;
	private final static String INSERT_QUERY = "Insert into `admisson` (`patientId`,`patientName`,`age`,`weight`,`height`,`city`,`diagnosis`,`doctorId`) values (?,?,?,?,?,?,?,?)";
	private final static String DELETE_QUERY = "Delete from `admisson` where `patientId`=?";
	private final static String UPDATE_QUERY = "Update `admisson` set `patientId` =? ,`patientName`=? ,`age` = ? ,`weight`=? ,`height`=?,`city`=?,`diagnosis`=?,`doctorId`=? where `patientId`=?";
	private final static String SELECT_QUERY = "Select * from `admisson` where `patientId` = ?";
	private final static String SELECT_ALL_QUERY = "Select * from `admisson`";
	
	public DetailsBoimpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hosiptaladministration", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int save(Patientinfo p) {
		// TODO Auto-generated method stub
		int i;
		try {
			statement = connection.prepareStatement(INSERT_QUERY);
			statement.setInt(1, p.getPatientId());
			statement.setString(2, p.getPatientName());
			statement.setInt(3, p.getAge());
			statement.setInt(4, p.getWeight());
			statement.setInt(5, p.getHeight());
			statement.setString(6, p.getCity());
			statement.setString(7,p.getDiagnosis());
			statement.setInt(8, p.getDoctorId());
			
			i = statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int patientId) {
		// TODO Auto-generated method stub
		int i;
		try {
			statement = connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1, patientId);
			i = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Patientinfo p) {
		delete(p.getPatientId());
		return 0;
	}

	@Override
	public int update(Patientinfo p) {
		int i;
		try {
			statement = connection.prepareStatement(UPDATE_QUERY);
			statement.setInt(1, p.getPatientId());
			statement.setString(2, p.getPatientName());
			statement.setInt(3, p.getAge());
			statement.setInt(4, p.getWeight());
			statement.setInt(5, p.getHeight());
			statement.setString(6, p.getCity());
			statement.setString(7,p.getDiagnosis());
			statement.setInt(8, p.getDoctorId());
			statement.setInt(9, p.getPatientId());
			
			i = statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Patientinfo get(int patientId) {
		ResultSet res;
		try {
			statement = connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, patientId);
			res = statement.executeQuery();
			if (res.next()) {
				int patientId1 = res.getInt("patientId");
				String patientName = res.getString("patientName");
				int age = res.getInt("age");
				int weight = res.getInt("weight");
				int height = res.getInt("height");
				String city = res.getString("city");
				String diagnosis = res.getString("diagnosis");
				int doctorId = res.getInt("doctorId");
				
				return new Patientinfo(patientId1,patientName,age,weight,height,city,diagnosis,doctorId);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Patientinfo> getAll() {
		ArrayList<Patientinfo> admissons = new ArrayList<Patientinfo>();
		try {
			createStatement = connection.createStatement();
			ResultSet res = createStatement.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next()) {
				int patientId = res.getInt("patientId");
				String patientName = res.getString("patientName");
				int age = res.getInt("age");
				int weight = res.getInt("weight");
				int height = res.getInt("height");
				String city = res.getString("city");
				String diagnosis = res.getString("diagnosis");
				int doctorId = res.getInt("doctorId");
				
				Patientinfo a = new Patientinfo(patientId,patientName,age,weight,height,city,diagnosis,doctorId);
				admissons.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admissons;
	}

}
