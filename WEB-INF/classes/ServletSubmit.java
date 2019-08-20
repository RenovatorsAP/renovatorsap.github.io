import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;
public class ServletSubmit implements Servlet
{
ServletConfig config=null;
public void init(ServletConfig config)
{
this.config=config;
}
public void service(ServletRequest request,ServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<h1 alignment=center>Thank you,your responce is recorded..</h1>");  
out.println("<hr size=10 color=green width=80%>");  
out.println("</body></html>"); 
} 
public void destroy()
{ }
public ServletConfig getServletConfig()
{
return config;
} 
public String getServletInfo()
{
return null;
}
}

