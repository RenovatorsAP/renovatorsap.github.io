import java.io.*;  
import java.sql.*;  
import javax.servlet.*;  
import javax.servlet.http.*;
public class MeRegisterServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String a=request.getParameter("uname");
String b=request.getParameter("psw");
String c=request.getParameter("mobno");
String d=request.getParameter("vname");
String e=request.getParameter("mailid");
String f=request.getParameter("state");
String g=request.getParameter("district");
String h=request.getParameter("mandal");
String i=request.getParameter("specialization");

          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","manager");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into renovatorsap values(?,?,?,?,?,?,?,?,?)");  
  
ps.setString(1,a);  
ps.setString(2,b);  
ps.setString(3,c);
ps.setString(4,d);  
ps.setString(5,e);  
ps.setString(6,f);  
ps.setString(7,g);  
ps.setString(8,h);  
ps.setString(9,i);    
  
          
int ii=ps.executeUpdate();  
if(ii>0)  {
			RequestDispatcher rd=request.getRequestDispatcher("regsuccess.html");
			rd.include(request,response);  
       
  }
else  
{
			RequestDispatcher rd=request.getRequestDispatcher("regfail.html");
			rd.include(request,response);  
}      
}
catch (ClassNotFoundException e2) {e2.printStackTrace();}  
catch (SQLException e1) {e1.printStackTrace();}  
          
 
}  
  
}  