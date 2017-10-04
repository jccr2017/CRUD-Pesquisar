package br.edu.facear.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Cliente;
import br.edu.facear.service.ClienteService;

/**
 * Servlet implementation class CadastrarServlet
 */
@WebServlet("/CadastrarServlet")
public class CadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarServlet() {
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
		
		//Obter do Banco de Dados
		;
		try {
			Cliente c = service.cadastrar( nome, email, cpf,
					 celular, idade, sexo, cidade,
					 escolaridade, qualificacoes, senha);
			
			request.setAttribute("cliente", c);
			
			//String nextPage="/cadastro.html";
			
			//if(c != null) {
				//nextPage="/principal.jsp";
			//}
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.html");
			rd.forward(request, response);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Colocar na área de memória da sessão

		
		
	}

}
