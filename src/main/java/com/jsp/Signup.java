package com.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.persistence.*;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter p = resp.getWriter();
		p.print("<h1>Welcome</h1>");
		String name = req.getParameter("name");
		// String password=req.getParameter("password")
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		p.print("<h1>welcome mr " + name + "</h1>");

		EntityManagerFactory emf =Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Employe e = new Employe();
		e.setName(name);
		e.setEmail(email);
		e.setPassword(password);
		et.begin();
		em.persist(e);
		et.commit();

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	}

