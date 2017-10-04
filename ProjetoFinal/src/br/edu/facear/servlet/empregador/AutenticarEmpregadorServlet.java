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
 * Servlet implementation class AutenticarEmpregadorServlet
 */
@WebServlet("/AutenticarEmpregadorServlet")
public class AutenticarEmpregadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarEmpregadorServlet() {
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
		
		String email=request.getParameter("email");
		String senha=request.getParameter("senha");
	
		EmpregadorService service=new EmpregadorService();
		
		//Obter do Banco de Dados
		
		try {
			
			Empregador c = service.autenticar(email, senha);
			
			
			request.setAttribute("empregador", c);
			request.getSession().setAttribute("empregador",c);
			
			String nextPage = "/index.html";
			
			if(c != null) {
				nextPage = "/principalempregador.jsp";
				
			RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
			rd.forward(request, response);
				
			}else {
				
				nextPage = "/loginincorreto.html";
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
				rd.forward(request, response);
				
				
				
			}

			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
