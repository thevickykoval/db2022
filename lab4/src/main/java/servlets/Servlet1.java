package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbs.SqlCRUD;
import valuta.Valuta;

import java.io.IOException;
import java.sql.SQLException;




@WebServlet("/Servlet1/*")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LabCRUDInterface<Valuta> crud = new SqlCRUD();
    
   
	
	public void init(ServletConfig config) throws ServletException {
		crud = new SqlCRUD();
		
	}
	public void destroy() {
		try {
			((SqlCRUD) crud).getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setContentType("application/json");
		response.getWriter().println(crud.read());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Valuta valuta = Helpers.valutaParse(request);
		crud.create(valuta);
		doGet(request, response);
	}


	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		Valuta valuta = Helpers.valutaParse(request);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		response.setContentType("application/json");
		crud.update(id, valuta);
		doGet(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		response.setContentType("application/json");
		crud.delete(id);
		doGet(request, response);
	}


	
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		response.setStatus(HttpServletResponse.SC_OK);
		
	}
	
	 private void setAccessControlHeaders(HttpServletResponse resp) {
		  resp.setHeader("Access-Control-Allow-Origin", "*");
	      resp.setHeader("Access-Control-Allow-Methods", "*");
	      resp.setHeader("Access-Control-Allow-Headers", "*");
	  }

}