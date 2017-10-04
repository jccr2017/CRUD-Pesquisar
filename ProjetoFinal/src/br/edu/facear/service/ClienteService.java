package br.edu.facear.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.dao.CadastrarDAO;
import br.edu.facear.dao.ClienteDAO;
import br.edu.facear.model.Cliente;

public class ClienteService {
	
	public Cliente cadastrar(String nome, String email, String cpf,
			String celular,String idade,String sexo,String cidade,
			String escolaridade,String qualificacoes,String senha) throws ClassNotFoundException, IOException {
		CadastrarDAO dao=new CadastrarDAO();
		Cliente c=null;
		
		try {
			c=dao.cadastrar( nome, email, cpf,
					 celular, idade, sexo, cidade,
					 escolaridade, qualificacoes, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	public List<Cliente> listaClientes() throws ClassNotFoundException, IOException{
		ClienteDAO dao=new ClienteDAO();
		List<Cliente> listaCliente=null;
		try {
			listaCliente = dao.listarClientes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaCliente;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Cliente obterClientePorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
		ClienteDAO dao=new ClienteDAO();
		Cliente c=dao.obterClientePorId(id);
		return c;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	public void excluir(String id) throws SQLException, ClassNotFoundException, IOException {
		ClienteDAO dao=new ClienteDAO();
		
		dao.excluir(id);
	}
	

	///////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void alterar(String id,String nome, String email, String cpf,
			String celular,String idade,String sexo,String cidade,
			String escolaridade,String qualificacoes,String senha) throws SQLException, ClassNotFoundException, IOException {
		ClienteDAO dao=new ClienteDAO();
		
		dao.alterar(id,nome, email, cpf,
				 celular, idade, sexo, cidade,
				 escolaridade, qualificacoes, senha);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<Cliente> procurar(String cidade) throws ClassNotFoundException, IOException{
		
		ClienteDAO dao=new ClienteDAO();
		ArrayList<Cliente> listaProcurar=null;
		
		
		try {
			listaProcurar = dao.procurar(cidade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaProcurar;
		
	}

	
}
