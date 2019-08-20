import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;   
  
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String a=request.getParameter("state");
String b=request.getParameter("district");
String c=request.getParameter("mandal");

          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","manager");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into testren values(?,?,?)");  
  
ps.setString(1,a);  
ps.setString(2,b);  
ps.setString(3,c);  
  
          
int i=ps.executeUpdate();  
if(i>0)  {
out.print("<h2><center>You are successfully registered</center></h2>");
			RequestDispatcher rd=request.getRequestDispatcher("book_vehicle.html");
			rd.include(request,response);  
       
  }        
}
catch (ClassNotFoundException e2) {e2.printStackTrace();}  
catch (SQLException e1) {e1.printStackTrace();}  
          
 
}  
  
}  