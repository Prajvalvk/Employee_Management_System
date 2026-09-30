package com.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
@WebServlet("/admin")
public class AdminSignin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter p=resp.getWriter();
	resp.setContentType("text/html");
		String name=req.getParameter("name");
	String password=req.getParameter("password");

	if(name.equals("admin") && password.equals("admin@123")) {
		
		p.print("Login Successfully");
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		List<Employe> list=em.createQuery("select e from Employe e").getResultList();
		
		
		p.println("<html><body>");
		p.println("<h1>Employes Details</h1>");
		p.println("<table border='1' cellpadding='10'>");
		p.println("<tr>");
		p.println("<th>User Id</th>");
		p.println("<th>NAME</th>");
		p.println("<th>Email</th>");
		p.println("</tr>");
		for(Employe emp:list) {
//			p.println("ID :"+emp.getId());
//			p.println("name: "+emp.getName());
//			p.println("email: "+emp.getEmail());
			
			
			p.println("<tr>");
			p.println("<td>"+emp.getId()+"</td>");
			p.println("<td>"+emp.getName()+"</td>");
			p.println("<td>"+emp.getEmail()+"</td>");
			p.println("</tr>");
			
		
		}
		p.println("</table>");
		p.println("</body></html>");
	}
	else {
		p.println("invalid");
		req.getRequestDispatcher("adminsignin.html");
	}
	
	
	}
	

}
