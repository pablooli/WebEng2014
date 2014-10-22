package servlets.hello;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class TareaServlet
 */
@WebServlet("/TareaServlet")
public class TareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TareaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("task")==null || request.getParameter("context")==null
			|| request.getParameter("proyect")==null || request.getParameter("priority")==null)
			response.sendRedirect("./index.jsp");
			//request.getRequestDispatcher("./index.jsp").forward(request, response);
		else{
			AnadirTarea.AddTarea(request.getParameter("task"),
				request.getParameter("context"),
				request.getParameter("proyect"),
				request.getParameter("priority"));


		response.sendRedirect("./");
		//request.getRequestDispatcher("./index.jsp").forward(request, response);
		}
	}		
		
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,  response);
		// TODO Auto-generated method stub
	}

}
