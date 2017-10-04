package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Cliente;
import br.edu.facear.model.Empregador;
import br.edu.facear.service.ClienteService;
import br.edu.facear.service.EmpregadorService;

/**
 * Servlet implementation class ObterExcluirC
 */
@WebServlet("/ObterExcluirC")
public class ObterExcluirC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObterExcluirC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		Cliente cliente=null;
		
		//Obter par�metro id pela URL e Converter id para Integer
		Integer idCliente=Integer.parseInt(request.getParameter("id"));
		
		//L�gica para chamar service
		ClienteService service=new ClienteService();
		try {
			cliente=service.obterClientePorId(idCliente);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("cliente", cliente);
		
		//Redirecionar para detalhesCliente.jsp
		String nextPage="/excluirfuncionario.jsp";
		RequestDispatcher rd= getServletContext().getRequestDispatcher(nextPage);
		rd.forward(request, response);
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
