package academy;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.Properties;

/**
 * Servlet implementation class SetTeacherList
 */
@WebServlet("/SetTeacherList")
public class SetTeacherList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetTeacherList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int Teachid = Integer.parseInt(request.getParameter("Tid"));
		String Fstname = request.getParameter("Fstname");
		String Lstname = request.getParameter("lstname");
		int status=0;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnacademy", "root", "RuethS54%sO$");
			//Connection con = DBConnection.initializeDatabase();
			InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            Properties props = new Properties();
            props.load(in);
            
            DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
            //out.println("DB Connection initialized.<br>");
            
            Connection con = conn.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //stmt.executeUpdate("insert into teachers (Tid, FstName , LstName) values (?,?,?)");


			PreparedStatement ps = con.prepareStatement("insert into teachers (Tid, FstName , LstName) values (?,?,?)");
			ps.setInt(1,Teachid);
			ps.setString(2,Fstname);
			ps.setString(3, Lstname);

			if(status>0) {
				out.print("<p>>Successfully Inserted</p>");
				request.getRequestDispatcher("TeacherTable").include(request, response);
			}else {
				out.print("<p>Sorry! unable to save records:</p>");
				request.getRequestDispatcher("SecondPg.jsp").include(request, response);
			}
			ps.close();
            conn.closeConnection();
            //out.println("DB Connection closed.<br>");

		
		}catch (ClassNotFoundException e) {
            e.printStackTrace();
		} catch (SQLException e) {
            e.printStackTrace();
		}catch (Exception e) {
			out.print(e);
		}
	}

}
