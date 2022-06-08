package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import valuta.Valuta;

import java.io.IOException;
import java.io.PrintWriter;

import crud.Lab2Crud;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfigInterface sevletConfig;
	Lab2Crud lab2Crud;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        this.sevletConfig = new ServletConfig();
        this.lab2Crud = sevletConfig.getCrud();
        lab2Crud.updateValuta(new Valuta("UAH", 1, "Ukraine"));
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		out.println("[" + lab2Crud.readValuta() + "]");

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valuta = request.getParameter("valuta");
		double count = Double.parseDouble(request.getParameter("count"));	
		String country = request.getParameter("country");

		
		lab2Crud.updateValuta(new Valuta(valuta, count, country));
	}

}
