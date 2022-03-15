package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.nt.service.IProductMgmtService;
import com.nt.service.ProductMgmtServiceImpl;
import com.nt.entity.Product;

@WebServlet("/controller")
public class MainControllerServlet  extends HttpServlet{	
	private IProductMgmtService service;
	
	public void init() {
		service=new ProductMgmtServiceImpl();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		      String pageSize=req.getParameter("pageSize");
		      String pgNo=req.getParameter("pgNo");
		       HttpSession ses=req.getSession();
		       int pageNo=0;
		      if(pageSize!=null) { //if submit button in clicked
		    	      ses.setAttribute("pageSize", pageSize);
		    	      pgNo="1";
		    	      pageNo=Integer.parseInt(pgNo);
		      }
		      else { //if hyper link is cliked
		    	  pageNo=Integer.parseInt(pgNo);
		    	   if(ses.getAttribute("pageSize")!=null)
		    	      pageSize=(String)ses.getAttribute("pageSize");
		    	   else
		    		   pageSize="3"; //defaultPageSize is 3
		      }
		
		     
		     //use service
		     try {
		    	 long pagesCount=service.getPagesCount(Integer.parseInt(pageSize));
		    	 List<Product> list= service.getPageData(pageNo, Integer.parseInt(pageSize));
		    	 //keep results in request scope
		    	 req.setAttribute("pageData", list);
		    	 req.setAttribute("pagesCount",pagesCount);
		    	 //forward to show_report.jsp
		    	 RequestDispatcher rd=req.getRequestDispatcher("/show_report.jsp");
		    		 rd.forward(req, res);
		     }
		     catch(Exception e) {
		    	 e.printStackTrace();
		    	 req.setAttribute("errMsg", e.getMessage());
		    	 RequestDispatcher rd=req.getRequestDispatcher("/error.jsp");
	    		 rd.forward(req, res);
		     }
	} //doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    doGet(req,res);
	}   //doPost(-,-)
	
}//class
