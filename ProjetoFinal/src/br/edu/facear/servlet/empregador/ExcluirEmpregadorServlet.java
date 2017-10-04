package br.edu.facear.servlet.empregador;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Cliente;
import br.edu.facear.service.ClienteService;
import br.edu.facear.service.EmpregadorService;

/**
 * Servlet implementation class ExcluirEmpregadorServlet
 */
@WebServlet("/ExcluirEmpregadorServlet")
public class ExcluirEmpregadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirEmpregadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String id=request.getParameter("id");
		
		EmpregadorService service=new EmpregadorService();
		
		try {
			service.excluir(id);
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String nextPage="/inicial.html";
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher(nextPage);
		rd.forward(request, response);
		
		
		
		
		
		
	}

}
