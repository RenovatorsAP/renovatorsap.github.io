import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Forgotpsw extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String a=request.getParameter("favcolsignup");
String b=request.getParameter("favnumbersignup"); 
String c=request.getParameter("emailsignup");
String d=request.getParameter("passwordsignup"); 
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","manager");  
  
PreparedStatement ps=con.prepareStatement(  
"update renovlog set pass=? where favcol=? and favno=? and mailid=?");  
  
ps.setString(1,d);  
ps.setString(2,a);  
ps.setString(3,b);  
ps.setString(4,c);  
  
          
int i=ps.executeUpdate();  
		if(i>0)  
		{
		RequestDispatcher rd=request.getRequestDispatcher("resetsuccess.html");
			rd.forward(request,response);
		}
		else{
			out.print("<h2><center>Sorry!! Incorrect details</center></h2>");
			RequestDispatcher rd=request.getRequestDispatcher("forgotpassword.html");
			rd.include(request,response);
		}
       
          
}
catch (ClassNotFoundException e2) {e2.printStackTrace();}  
catch (SQLException e1) {e1.printStackTrace();}  
          
 
}  
  }