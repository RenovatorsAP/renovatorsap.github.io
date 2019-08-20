import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("mailid");
		String p=request.getParameter("userpass");
                
		
		if(LoginDao.validate(n, p)){
			RequestDispatcher rd=request.getRequestDispatcher("loginbookvehicle.html");
			rd.forward(request,response);
		request.setAttribute("mailid",n);
		RequestDispatcher rd1 = request.getRequestDispatcher("Bookvehicle");
		rd1.forward(request,response);
		}
		else{
			out.print("<h2><center>Sorry mailid or password error</center></h2>");
			RequestDispatcher rd=request.getRequestDispatcher("book_vehicle.html");
			rd.include(request,response);
		}
		
		out.close();
	}

}
