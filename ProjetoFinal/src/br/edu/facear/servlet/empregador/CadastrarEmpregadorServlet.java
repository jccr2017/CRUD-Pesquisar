package br.edu.facear.servlet.empregador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Empregador;
import br.edu.facear.service.EmpregadorService;

/**
 * Servlet implementation class CadastrarEmpregadorServlet
 */
@WebServlet("/CadastrarEmpregadorServlet")
public class CadastrarEmpregadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarEmpregadorServlet() {
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
        String senha=request.getParameter("senha");
        
        EmpregadorService service= new EmpregadorService();
        
        
		try {
			Empregador c = service.cadastrar( nome, email, cpf,
					 celular, idade, sexo, cidade, senha);
			
			request.setAttribute("empregador", c);
			
			//String nextPage="/cadastro.html";
			
			//if(c != null) {
				//nextPage="/principal.jsp";
			//}
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/indexempregador.html");
			rd.forward(request, response);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
