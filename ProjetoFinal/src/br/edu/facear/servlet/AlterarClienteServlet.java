package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.service.ClienteService;

/**
 * Servlet implementation class AlterarClienteServlet
 */
@WebServlet("/AlterarClienteServlet")
public class AlterarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String nome=request.getParameter("nome");
		String email=request.getParameter("email");
		String cpf=request.getParameter("cpf");
		String celular=request.getParameter("celular");
		String idade=request.getParameter("idade");
		String sexo=request.getParameter("sexo");
		String cidade=request.getParameter("cidade");
		String escolaridade=request.getParameter("escolaridade");
		String qualificacoes=request.getParameter("qualificacoes");
		String senha=request.getParameter("senha");
		
		ClienteService service=new ClienteService();
		
		try {
			service.alterar( id,nome, email, cpf,
					 celular, idade, sexo, cidade,
					 escolaridade, qualificacoes, senha);
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String nextPage="/ObterClienteServlet";
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher(nextPage);
		rd.forward(request, response);
		
		
		
		
		
		
	}

}
