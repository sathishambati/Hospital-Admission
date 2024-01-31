package com.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.detailsBo.DetailsBoimpl;
import modules.Patientinfo;

public class run extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		String patientName = request.getParameter("patientName");
		int age = Integer.parseInt(request.getParameter("age"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		int height = Integer.parseInt(request.getParameter("height"));
		String city = request.getParameter("city");
		String diagnosis = request.getParameter("diagnosis");
		int doctorId = Integer.parseInt(request.getParameter("doctorId"));
		
		
		DetailsBoimpl adm = new DetailsBoimpl();
		Patientinfo admisson = new Patientinfo(patientId,patientName,age,weight,height,city,diagnosis,doctorId);
		adm.save(admisson);
		
	}

}
