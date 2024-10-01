package webapplication;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/formdata")
public class Newform extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = arg0.getParameter("username");
		Long cont = Long.parseLong(arg0.getParameter("contact"));
//		String cont = arg0.getParameter("contact");
		arg1.getWriter().println("hello  " + name );
		arg1.getWriter().println( "Contact no "+cont);
		
	}
	

}
