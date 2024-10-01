package webapplication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginClass extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username = req.getParameter("username");
	String email = req.getParameter("email");
	
	if(username.equals("shiva")&&email.equals("shiva@gmail.com")) {
	HttpSession session = req.getSession();
	session.setAttribute("email" , email);
	req.getRequestDispatcher("Welcome.html").forward(req, resp);
	}
	else
		req.getRequestDispatcher("LoginClass.html").forward(req, resp);
}
}
