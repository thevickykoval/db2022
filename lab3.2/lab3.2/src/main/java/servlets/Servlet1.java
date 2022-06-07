package servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import valuta.Valuta;
import file.FileIO;



/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1/*")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Valuta> valutaList = new ArrayList<Valuta>();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	public Servlet1() {
		super();
		valutaList.add(new Valuta(1, "UAH", 1, "Ukraine"));
		FileIO.saveToFile(valutaList);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setContentType("application/json");
		//valutaList.clear();
		new FileIO();
		valutaList = FileIO.loadFromFile();
		response.getWriter().println(valutaList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Valuta valuta = Helpers.valutaParse(request);
		valuta.setId(Helpers.getNextId(valutaList));
		valutaList.add(valuta);
		new FileIO();
		FileIO.saveToFile(valutaList);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Valuta valuta = Helpers.valutaParse(request);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		response.setContentType("application/json");
		int index = Helpers.getIndexByValutaId(id, valutaList);
		valutaList.set(index,valuta);
		new FileIO();
		FileIO.saveToFile(valutaList);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		response.setContentType("application/json");
		int index = Helpers.getIndexByValutaId(id, valutaList);
		valutaList.remove(index);
		new FileIO();
		FileIO.saveToFile(valutaList);
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		setAccessControlHeaders(response);
		response.setStatus(HttpServletResponse.SC_OK);
		
	}
	
	 private void setAccessControlHeaders(HttpServletResponse resp) {
		 resp.setHeader("Access-Control-Allow-Origin", "http://localhost:50509");
		  resp.setHeader("Access-Control-Allow-Origin", "*");
	      resp.setHeader("Access-Control-Allow-Methods", "*");
	      resp.setHeader("Access-Control-Allow-Headers", "*");
	  }

}