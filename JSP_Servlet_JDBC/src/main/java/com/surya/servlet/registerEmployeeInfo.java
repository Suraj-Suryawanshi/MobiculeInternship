package com.surya.servlet;

import java.io.PrintWriter;
import java.io.IOException;


import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;

import com.surya.dao.Employee;
import com.surya.dao.EmployeeDao;
import com.surya.dao.EmployeeDaoImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  

/**
 * Servlet implementation class RegisterEmployeeInfo
 */
@WebServlet("/registerEmployeeInfo")
public class registerEmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerEmployeeInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//    	
//    	EmployeeDAO ed = new EmployeeDAOImplementation();
//    	response.setContentType("text/html");
//    	Printwriter out = response.getWriter();
//    	
//    	
//    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		EmployeeDao ed = new EmployeeDaoImpl();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String birthdate = request.getParameter("birthdate");	
		
		String name = firstname + " " + lastname;
//		System.out.println("Name is::"+ name);
		
		String joiningdate = request.getParameter("joiningdate");
//		int salary = Integer.parseInt(request.getParameter("salary"));
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		
		String display = ed.getEmployee(firstname, lastname, birthdate, joiningdate, salary);
//		String display = ed.getEmployee(name, birthdate, joiningdate, salary);
		
//		System.out.println("Display is ::"+ display);
		
		out.println(display);
		
		RequestDispatcher qs = request.getRequestDispatcher("employee.jsp");
		qs.include(request, response);
		
    }

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EmployeeDao ed = new EmployeeDaoImpl();
			
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String birthdate = request.getParameter("birthdate");
		
		String joiningdate = request.getParameter("joiningdate");
		String salary = request.getParameter("salary");
		
		String qualification = request.getParameter("qualification");
		
		String submitType = request.getParameter("submit");
						
//		System.out.println(firstname + lastname);
//		System.out.println(gender);
//		System.out.println(submitType);
//		System.out.println("JD :"+ joiningdate + "   Salary:" + salary);
		
		Employee emp = new Employee();
		
		
		if(submitType.equals("Submit")) {
						
			emp.setFirstname(firstname);
			emp.setLastname(lastname);
			emp.setGender(gender);
			emp.setBirthdate(birthdate);
			
//			  try {
//				Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
//				emp.setBirthdate(date1);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}  
			
			emp.setJoiningdate(joiningdate);
//			emp.setSalary(Integer.parseInt(salary));
			emp.setSalary(Double.parseDouble(salary));
			
			emp.setQualification(qualification);
			
			ed.insertEmployee(emp);
			
			System.out.println("Insertion Complete !!!");
			
//			System.out.println("Insertion Complete !!!");
			
//			Employee record = ed.getEmployee(firstname, lastname, birthdate);
//			System.out.println("Record is ::"+ record);
			
			doGet(request, response);
			
			
		}

	}

}