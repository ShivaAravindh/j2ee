package webapplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/url6")
public class ThirdServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter p = res.getWriter();
		p.print("Bye...");
		
		RequestDispatcher r = req.getRequestDispatcher("/url4");
		r.include(req, res);
		
	}
	
}
