package br.edu.facear.service;

import java.io.IOException;
import java.sql.SQLException;

import br.edu.facear.dao.ClienteDAO;
import br.edu.facear.model.Cliente;

public class AutenticarUsuarioService {
	public Cliente autenticar(String email, String senha) throws ClassNotFoundException, IOException {
		
		ClienteDAO dao=new ClienteDAO();
		Cliente c = null;
		try {
			c = dao.autenticar(email, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
