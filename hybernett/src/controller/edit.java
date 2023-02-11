package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vo.vo;
import dao.dao;

/**
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id1=Integer.parseInt(request.getParameter("id"));
		vo v=new vo();
		v.setId(id1);
		dao d=new dao();
		List ls1=d.edit(v);
		HttpSession s=request.getSession();
		s.setAttribute("list", ls1);
		System.out.println(ls1.size());
		System.out.println("HII");
		response.sendRedirect("edit.jsp");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String s1=request.getParameter("fn");
		String s2=request.getParameter("ln");
		int id2=Integer.parseInt(request.getParameter("id"));
		vo v1=new vo();
		v1.setFname(s1);
		v1.setLname(s2);
		v1.setId(id2);
		dao d1=new dao();
		d1.update(v1);
	response.sendRedirect("search.jsp");
	}

}
