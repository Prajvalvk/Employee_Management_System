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
@WebServlet("/register")
public class UserSignin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter p=resp.getWriter();
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		
		List<Employe> list = em.createQuery(
			    "select e from Employe e where e.name=:n and e.password=:p",
			    Employe.class)
			    .setParameter("n", name)
			    .setParameter("p", password)
			    .getResultList();

			if (!list.isEmpty()) {
			    p.println("Welcome " + name);
			} else {
				resp.setContentType("text/html");
			

				p.println("<h3>Invalid Credentials</h3>");

				RequestDispatcher dispatcher = req.getRequestDispatcher("signin.html");
				dispatcher.include(req, resp);
			}
	}
}
