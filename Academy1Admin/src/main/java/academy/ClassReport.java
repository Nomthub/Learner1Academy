package academy;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class ClassReport
 */
@WebServlet("/ClassReport")
public class ClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 
		String Clsid = request.getParameter("Cid");
		int Classid = Integer.valueOf(Clsid);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnacademy", "root", "RuethS54%sO$");
			//Connection con = DBConnection.initializeDatabase();
			
			Statement stmt = con.createStatement();  
			PreparedStatement ps = con.prepareStatement("select students.stid, students.FstName, students.LstName, subject.Subid, subject.Subname, subject.Tid from students, subject\r\n"
					+ "where students.Cid=? and subject.Cid=?");
			ps.setInt(1,Classid);
			
			out.print("<table width=50% border=1>");
			out.print("<caption>Class Record Result : </caption>");
			
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumn = rsmd.getColumnCount();
			out.print("<tr>");
			
			for(int i=1; i<totalColumn; i++) {
				out.print("<th>" + rsmd.getColumnName(i)+"<th>");
			}
			out.print("<tr>");
			while(rs.next()) {
				out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getInt(6)+"</td></tr>");
			}
			out.print("</table>");
			con.close();
			
		}catch (Exception e) {
			out.print(e);
		}
	}

}
