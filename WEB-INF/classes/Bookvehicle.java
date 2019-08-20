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
 
  
public class Bookvehicle extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
String n=(String)request.getAttribute("mailid");
          
String a=request.getParameter("bvtype");
String b=request.getParameter("bvname");
String c=request.getParameter("bvpurpose");
String d=request.getParameter("bvnofv"); 
String e=request.getParameter("bvdt");
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:XE","system","manager");  

PreparedStatement ps1=con.prepareStatement("select name from renovlog where mailid=?");
ps1.setString(1,n);

ResultSet rs=ps1.executeQuery();  
ResultSetMetaData rsmd=rs.getMetaData();
String nm =rsmd.getColumnName(1);

PreparedStatement ps=con.prepareStatement("insert into renovbookvehicle values(?,?,?,?,?,?,?)");  
  
ps.setString(1,nm);  
ps.setString(2,n);  
ps.setString(3,a);  
ps.setString(4,b);  
ps.setString(5,c);  
ps.setString(6,d);  
ps.setString(7,e); 
          
int i=ps.executeUpdate(); 
 
if(i>0) 
{
 
			RequestDispatcher rd=request.getRequestDispatcher("bookvehiclesuccess.html");
			rd.forward(request,response);
	}
		out.close();
       
          
}
catch (ClassNotFoundException e2) {e2.printStackTrace();}  
catch (SQLException e1) {e1.printStackTrace();}  
          
 
}  
  
}  