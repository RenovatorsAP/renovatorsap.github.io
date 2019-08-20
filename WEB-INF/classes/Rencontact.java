import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
  
public class Rencontact extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  

String a=request.getParameter("conname");
String b=request.getParameter("consurname");
String c=request.getParameter("conmailid");
String d=request.getParameter("conmsg"); 
String e=request.getParameter("condt");
        
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","manager");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into renovcon values(?,?,?,?,?)");  
  
ps.setString(1,a);  
ps.setString(2,b);  
ps.setString(3,c);  
ps.setString(4,d);  
ps.setString(5,e);  
          
int i=ps.executeUpdate();  
if(i>0) 
{
out.print("<h2><center>Your responce is recorded successfully..</center></h2>");
			RequestDispatcher rd=request.getRequestDispatcher("Contact.html");
			rd.include(request,response);        
 }         
}
catch (ClassNotFoundException e2) {e2.printStackTrace();}  
catch (SQLException e1) {e1.printStackTrace();}  
          
 
}  
  
}  