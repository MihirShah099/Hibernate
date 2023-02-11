package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.countridao;
import dao.dao;
import dao.statedao;
import vo.statevo1;
import vo.countryvo;

/**
 * Servlet implementation class editstate
 */
@WebServlet("/editstate")
public class editstate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editstate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id1=Integer.parseInt(request.getParameter("id"));
		countryvo v1=new countryvo();
		
		countridao v2=new countridao();
		List ls = v2.search(v1);
		System.out.println("list size:"+ls.size());
		
		HttpSession u=request.getSession();
		u.setAttribute("ls",ls);
		System.out.println(id1);
		
		statevo1 v=new statevo1();
		v.setId(id1);
		
		statedao d=new statedao();
		List ls1=d.edit(v);
		
		HttpSession s=request.getSession();
		s.setAttribute("list", ls1);
		
		response.sendRedirect("editstate.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		countryvo v1=new countryvo();
		int id=Integer.parseInt(request.getParameter("id"));
		v1.setId(id);
		
		statevo1 v2=new statevo1();
		int id1=Integer.parseInt(request.getParameter("id1"));
		String sname=request.getParameter("stat2");
		v2.setId(id1);
		v2.setStat(sname);
		v2.setCid(v1);
	statedao d=new statedao();
	d.update(v2);
	
	response.sendRedirect("statesearch.jsp");
	
	}

}
