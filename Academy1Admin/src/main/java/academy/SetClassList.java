package academy;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetClassList
 */
@WebServlet("/SetClassList")
public class SetClassList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetClassList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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


			PreparedStatement ps = con.prepareStatement("insert into class (Cid, ClsName) values (?,?)");
			ps.setInt(1,Teachid);
			ps.setString(2,Fstname);
			ps.setString(3, Lstname);

			if(status>0) {
				out.print("<p>>Successfully Inserted</p>");
				request.getRequestDispatcher("ClassTable").include(request, response);
			}else {
				out.print("<p>Sorry! unable to save records:</p>");
				request.getRequestDispatcher("SecondPg.jsp").include(request, response);
			}
			ps.close();
            conn.closeConnection();
            //out.println("DB Connection closed.<br>");
		}catch (Exception e) {
			out.print(e);
		}
	}

}
