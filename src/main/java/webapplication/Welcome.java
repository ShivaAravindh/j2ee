package webapplication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/welcome")
public class Welcome extends HttpServlet{
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession ses = req.getSession();
	String mail =(String) ses.getAttribute("email");
	
	if(mail!=null)
		req.getRequestDispatcher("Welcome.html").forward(req, resp);
	else
		req.getRequestDispatcher("LoginClass.html").forward(req, resp);
}
}
