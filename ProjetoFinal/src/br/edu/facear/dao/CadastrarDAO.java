package br.edu.facear.dao;

import java.io.IOException;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import br.edu.facear.model.Cliente;

public class CadastrarDAO extends GenericDAO {
	
	private PreparedStatement ps;
	
	private String CADASTRAR_SQL ="INSERT INTO tb_cliente (nome,email,cpf,celular,"
			+ "idade,sexo,cidade,escolaridade,qualificacoes,senha) values(?, ?, ?, ?,?,?,?,?,?,?);";
	
	public Cliente cadastrar(String nome, String email, String cpf,
			String celular,String idade,String sexo,String cidade,
			String escolaridade,String qualificacoes,String senha)
					throws SQLException, ClassNotFoundException, IOException {
		Cliente c=null;
		
		//Abrir conexão
		openConnection();
		
		//Preparar script
		ps = connect.prepareStatement(CADASTRAR_SQL);
		ps.setString(1, nome);
		ps.setString(2, email);
		ps.setString(3, cpf);
		ps.setString(4, celular);
		ps.setString(5, idade);
		ps.setString(6, sexo);
		ps.setString(7, cidade);
		ps.setString(8, escolaridade);
		ps.setString(9, qualificacoes);
		ps.setString(10, senha);

		
		ps.executeUpdate();
		
		/*ResultSet rs=ps.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				c=new Cliente(rs.getInt("id"), rs.getString(rs.getString("nome")), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"));
			}
		}*/
		
		//Fechar conexão
		closeConnection();
		
		return c;
	}
}
