package webapplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/url4")
public class FirstServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter p = res.getWriter();
		p.print("Hello user...");
		
		RequestDispatcher r = req.getRequestDispatcher("url5");
		r.include(req, res);
//		r.forward(req, res);
		
	}
	
}
