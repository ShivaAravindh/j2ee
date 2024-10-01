package webapplication;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/signup")
public class SignUp extends HttpServlet {


@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("username");
	String pass = req.getParameter("password");
	long contact =Long.parseLong(req.getParameter("contact"));
	String email = req.getParameter("email");
//	try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection("jdbc:mysql:///newtable?user=root&password=root");
//		String query = "insert into demodatabase values(?,?,?,?)";
//		PreparedStatement ps = con.prepareStatement(query);
//		ps.setString(1, name);
//		ps.setString(2, pass);
//		ps.setLong(3, contact );
//		ps.setString(4, email);
//		int count = ps.executeUpdate();
//		resp.getWriter().print("------"+count+"------");
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} 
	
	try {
		if(check(name)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///newtable?user=root&password=root");
			String query = "insert into demodatabase values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.setLong(3, contact );
			ps.setString(4, email);
			int count = ps.executeUpdate();
			resp.getWriter().print("------"+count+"------");
		}
		else {
			resp.getWriter().print("Username is already present");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private boolean check(String name) throws Exception {
	String res = null ;
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql:///newtable?user=root&password=root");
	Statement s = con.createStatement();
	String query = "select name from demodatabase";
	ResultSet r = s.executeQuery(query);
	while(r.next()) {
		res = r.getString(1);
	}
	if(res.equals(name)) {
		return false;
	}
	return true;
	
}
	
}
