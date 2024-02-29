package servlete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import db.DBconnection;


 
@WebServlet("/login")
public class LoginServlete extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	
	DBconnection db=new DBconnection();
	String name=request.getParameter("uname");
	String pass=request.getParameter("pass");
	System.out.println("======");
	boolean isUserValid=db.validateUser(name, pass);
	
	if(isUserValid==true)
	{
		HttpSession session=request.getSession();
		session.setAttribute(name, "uname");
		session.setAttribute(pass, "pass");
		
		System.out.println(" session" + session);
	}
	}

}
