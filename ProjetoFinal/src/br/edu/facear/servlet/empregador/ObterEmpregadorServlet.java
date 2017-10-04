package br.edu.facear.servlet.empregador;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Empregador;

import br.edu.facear.service.EmpregadorService;

/**
 * Servlet implementation class ObterEmpregadorServlet
 */
@WebServlet("/ObterEmpregadorServlet")
public class ObterEmpregadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObterEmpregadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Empregador empregador=null;
		Integer idempregador =new Integer(0);
		
		//Obter parâmetro id pela URL e Converter id para Integer
		String id=request.getParameter("id");
		
		if(id!=null && !id.equals(""))
			idempregador=Integer.parseInt(id);
		
		//Lógica para chamar service
		EmpregadorService service=new EmpregadorService();
		try {
			empregador=service.obterEmpregadorPorId(idempregador);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("empregador", empregador);
		
		//Redirecionar para detalhesCliente.jsp
		String nextPage="/alterarempregador.jsp";
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
