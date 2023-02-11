package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.logdao;
import vo.logvo;
import dao.regdao;
import vo.regvo;

/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String s1=request.getParameter("fname");
		String s2=request.getParameter("lname");
		String s3=request.getParameter("un");
		String s4=request.getParameter("pas");
		logvo v=new logvo();
		v.setUname(s3);
		v.setPassword(s4);
		logdao d=new logdao();
		d.insert(v);
		regvo v1=new regvo();
		v1.setFname(s1);
		v1.setLname(s2);
		regdao s=new regdao();
		s.insert(v1);
		v1.setUid(v);
		
		
	}

}
