package academy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n = request.getParameter("t1");
		String pwd = request.getParameter("t2");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if(n.equals("Admin") && pwd.equals("@dm!n")) {
			HttpSession hs = request.getSession();
			hs.setAttribute("uname", n);
			
			response.sendRedirect("WelcomePg.jsp");
		}
		else {
			out.println("<font color=red size=6 face=Admin> Sorry! username or password incorrect... Try again</font>");
			RequestDispatcher rd = request.getRequestDispatcher("LoginPg.jsp");
			rd.include(request, response);
		}
	}

}
