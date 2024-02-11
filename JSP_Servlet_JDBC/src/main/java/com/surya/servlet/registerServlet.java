package com.surya.servlet;

import java.io.IOException;

import com.surya.dao.User;
import com.surya.dao.UserDao;
import com.surya.dao.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        UserDao userDao = new UserDaoImpl();
        if (userDao.addUser(user)) {
            response.sendRedirect("index.jsp?registration=success");
        } else {
            response.sendRedirect("register.jsp?error=1");
        }
    }
}
