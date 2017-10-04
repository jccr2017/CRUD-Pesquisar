package br.edu.facear.service;

import java.io.IOException;



import java.sql.SQLException;
import java.util.List;


import br.edu.facear.dao.EmpregadorDAO;

import br.edu.facear.model.Empregador;

public class EmpregadorService {
	
	public Empregador cadastrar(String nome,String email,String cpf,
			String celular,String idade,String sexo,String cidade,String senha) throws ClassNotFoundException, IOException {
		EmpregadorDAO dao=new EmpregadorDAO();
		Empregador c=null;
		
		try {
			c=dao.cadastrar( nome, email, cpf,
					 celular, idade, sexo, cidade,senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	
	public Empregador autenticar(String email, String senha) throws ClassNotFoundException, IOException {
		
		EmpregadorDAO dao=new EmpregadorDAO();
		Empregador c = null;
		try {
			c = dao.autenticar(email, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/////////////////////////////////////////////////////////////
	
	public void alterar(String id,String nome, String email, String cpf,
			String celular,String idade,String sexo,String cidade,String senha) throws SQLException, ClassNotFoundException, IOException {
		EmpregadorDAO dao=new EmpregadorDAO();
		
		dao.alterar(id,nome, email, cpf,
				 celular, idade, sexo, cidade,
				 senha);
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	public Empregador obterEmpregadorPorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
		EmpregadorDAO dao=new EmpregadorDAO();
		Empregador c=dao.obterEmpregadorPorId(id);
		return c;
	}
	
	
	///////////////////////////////////////////////////////]
	
	
	public List<Empregador> listaEmpregadores() throws ClassNotFoundException, IOException{
		EmpregadorDAO dao=new EmpregadorDAO();
		List<Empregador> listaEmpregador=null;
		try {
			listaEmpregador = dao.listarEmpregadores();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaEmpregador;
	}
	
	////////////////////////////////////////////////////////////////////////////////
	
	public void excluir(String id) throws SQLException, ClassNotFoundException, IOException {
		EmpregadorDAO dao=new EmpregadorDAO();
		
		dao.excluir(id);
	}
	
	

}
