package servlets.hello;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TareaServlet
 */
@WebServlet("/MostrarResultados")
public class MostrarResultados extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MostrarResultados() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("buscarPorTarea")==null || request.getParameter("buscarPorTarea").isEmpty() ){
			MenuTareas resultado = MostrarTodos.listaTareas();
			request.setAttribute("listaDatos", resultado.getListaTarea());
			request.getRequestDispatcher("./resultadoTodos.jsp").forward(request, response);
		}
		else{
			MenuTareas resultado = MostrarTodos.listaPorTarea(request.getParameter("buscarPorTarea"));
			request.setAttribute("listaDatos", resultado.getListaTarea());
			request.getRequestDispatcher("./resultadoTodos.jsp").forward(request, response);
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
