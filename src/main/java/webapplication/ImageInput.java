package webapplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/image")
@MultipartConfig
public class ImageInput extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Part inpfile = req.getPart("name");
			String filename = inpfile.getSubmittedFileName();
			InputStream is = inpfile.getInputStream();
//			resp.getWriter().print("Program is done");
			String savePath = getServletContext().getRealPath("/") + "uploads"; // Change 'uploads' to your desired //
																				// directory
			File uploadDir = new File(savePath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs(); // Create directory if it doesn't exist
			}
			File outputFile = new File(uploadDir, filename);
			FileOutputStream fos = new FileOutputStream(outputFile);
			byte[] buffer = new byte[1024];
			int bytesRead = is.read(buffer);
			while (bytesRead != -1) {
				fos.write(buffer, 0, bytesRead);
			}

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:///newtable?user=root&password=root");
			PreparedStatement ps = con.prepareStatement("INSERT INTO image values(?,?,?)");
			ps.setInt(1, 3);
			ps.setString(2, "ImagebyInp");
			ps.setBinaryStream(3, is);
			int count = ps.executeUpdate();
			con.close();
			resp.getWriter().print(count);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
