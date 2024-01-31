package com.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.detailsBo.DetailsBoimpl;

import modules.Patientinfo;


@WebServlet("/")
public class hospitalservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DetailsBoimpl DetailsBoimpl;
       
	public void init() {
		DetailsBoimpl = new DetailsBoimpl();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(request, response);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertuser(request, response);
			break;
		case "/delete":
			deleteUser(request, response);
			break;
		case "/edits":
			showEditForm(request, response);
			break;
		case "/update":
			updateuser(request, response);
			break;
		default:
			listUser(request, response);
			break;
		}
		
	}
	protected void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	List<Patientinfo> listUser = DetailsBoimpl.getAll();
    	request.setAttribute("listUser", listUser);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
    	dispatcher.forward(request, response);
    }
	
	private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("admisson.jsp");
		dispatcher.forward(request, response);
		
	}
	protected void insertuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
		try {
	        String patientName = request.getParameter("patientName");
	        String ageStr = request.getParameter("age");
	        String weightStr = request.getParameter("weight");
	        String heightStr = request.getParameter("height");
	        String city = request.getParameter("city");
	        String diagnosis = request.getParameter("diagnosis");
	        String doctorIdStr = request.getParameter("doctorId");
	        
	        if (patientName == null || ageStr == null || weightStr == null || heightStr == null || city == null || diagnosis == null || doctorIdStr == null) {
	            // Handle the case where any required parameter is missing
	            // You may redirect the user to an error page or show an error message
	            response.sendRedirect("error.jsp");
	            return;
	        }
	        
	        int age = Integer.parseInt(ageStr);
	        int weight = Integer.parseInt(weightStr);
	        int height = Integer.parseInt(heightStr);
	        int doctorId = Integer.parseInt(doctorIdStr);
			
			
			Patientinfo admisson = new Patientinfo(patientName,age,weight,height,city,diagnosis,doctorId);
			DetailsBoimpl.save(admisson);
			response.sendRedirect("list");
			
		}
		catch(NumberFormatException e){
			response.sendRedirect("error.jsp");
			
		}
    }
	
	protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    // Retrieve the user ID from the request parameters
		    String patientIdStr = request.getParameter("patientId");

		    if (patientIdStr != null) {
		        // Convert the ID to an integer
		        int patientId = Integer.parseInt(patientIdStr);

		        // Call your DAO (Data Access Object) or service method to get user details by ID
		        Patientinfo existuser = DetailsBoimpl.get(patientId);

		        // Set the user details as an attribute in the request
		        request.setAttribute("user", existuser);

		        // Forward the request to the JSP file for editing
		        RequestDispatcher dispatcher = request.getRequestDispatcher("admisson.jsp");
		        dispatcher.forward(request, response);
		    } else {
		        // Handle the case where the ID is not provided
		        response.sendRedirect(request.getContextPath() + "/error.jsp");
		    }
		} catch (NumberFormatException e) {
			e.printStackTrace();
		    // Handle the case where the ID is not a valid integer
		    response.sendRedirect(request.getContextPath() + "/error.jsp");
		} catch (Exception e) {
		    // Handle other exceptions that might occur
		    e.printStackTrace(); // Log the exception for debugging
		    response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
}
    
	
	

	
//	protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String patientIdStr = request.getParameter("patientId");
//		if (patientIdStr == null){
//            // Handle the case where any required parameter is missing
//            // You may redirect the user to an error page or show an error message
//            response.sendRedirect("error.jsp");
//            return;
//		}
//        int patientId = Integer.parseInt(patientIdStr);
//    	Patientinfo existuser = DetailsBoimpl.get(patientId);
//    	RequestDispatcher dispatcher =request.getRequestDispatcher("admisson.jsp");
//    	request.setAttribute("user", existuser);
//    	dispatcher.forward(request,response);
//    }
	protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String patientIdStr = request.getParameter("id");

        if (patientIdStr != null) {
            try {
                int patientId = Integer.parseInt(patientIdStr);

                DetailsBoimpl.delete(patientId);

                response.sendRedirect(request.getContextPath() + "/list");
            } catch (NumberFormatException e) {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
    
	
	protected void updateuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
		try {
			int patientId = Integer.parseInt(request.getParameter("patientId"));
			String patientName = request.getParameter("patientName");
			int age = Integer.parseInt(request.getParameter("age"));
			int weight = Integer.parseInt(request.getParameter("weight"));
			int height = Integer.parseInt(request.getParameter("height"));
			String city = request.getParameter("city");
			String diagnosis = request.getParameter("diagnosis");
			int doctorId = Integer.parseInt(request.getParameter("doctorId"));
			
			
			Patientinfo admisson = new Patientinfo(patientId,patientName,age,weight,height,city,diagnosis,doctorId);
			DetailsBoimpl.update(admisson);
			response.sendRedirect("list");
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");			e.printStackTrace();
		} 
    }
	
	
	
	
	
	
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	


}
