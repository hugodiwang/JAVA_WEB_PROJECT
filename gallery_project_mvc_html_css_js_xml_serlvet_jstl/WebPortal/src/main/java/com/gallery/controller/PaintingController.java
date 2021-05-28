package com.gallery.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gallery.service.PaintingService;
import com.gallery.utils.PageModel;

/**
 * Servlet implementation class PaintingController
 */
/**
 * main function is doGet, in which we receive http data(page, row), then 
 * recall service function to get pageModel. After that we put pagemodel into
 * the request attribute and re-send it to view(jsp).
 * 
 * @author dwang
 *
 */

@WebServlet("/pc")
public class PaintingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PaintingService paintingService = new PaintingService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaintingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getParameter("p");
		String rows = request.getParameter("r");
		String category = request.getParameter("c");
		if(page == null) page = "1";
		if(rows == null) rows = "2";
		PageModel pageModel =  paintingService.pagination(Integer.parseInt(page), Integer.parseInt(rows), category);
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		
	}

}
