package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginFormServlet
 */
@WebServlet("/login")
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginFormServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	out.print("<html><body>hello</body></html>");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginUser = "alejandro";
		String loginPass = "serna";
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		if (user.equals(loginUser) && pass.equals(loginPass) ) {
			writer.println("<h1>Succes</h1>");
		} else {
			writer.println("<h1>Login Failed</h1>");
		}
	}

}
