import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
  
public class Renovation extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  

String a=request.getParameter("renloc");
String b=request.getParameter("renfname");
String c=request.getParameter("renlname");
String d=request.getParameter("rennumber"); 
String e=request.getParameter("renvdetails");
String f=request.getParameter("renvproblem"); 
String g=request.getParameter("rendt");          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","manager");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into renovren values(?,?,?,?,?,?,?)");  
  
ps.setString(1,a);  
ps.setString(2,b);  
ps.setString(3,c);  
ps.setString(4,d);  
ps.setString(5,e);  
ps.setString(6,f); 
ps.setString(7,g); 
          
int i=ps.executeUpdate();  
if(i>0) 
{
out.print("<h2><center>Your responce is recorded successfully..</center></h2>");
			RequestDispatcher rd=request.getRequestDispatcher("Renovation.html");
			rd.include(request,response);        
 }         
}
catch (ClassNotFoundException e2) {e2.printStackTrace();}  
catch (SQLException e1) {e1.printStackTrace();}  
          
 
}  
  
}  