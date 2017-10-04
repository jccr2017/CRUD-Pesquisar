package br.edu.facear.dao;

import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Cliente;

import br.edu.facear.service.ClienteService;

public class ClienteDAO extends GenericDAO {
	private PreparedStatement ps;
	private String LOGIN_SQL ="SELECT * FROM tb_cliente WHERE EMAIL = ? AND SENHA = ?;";
	
	private String LISTAR_CLIENTE="SELECT * FROM  tb_cliente;";
	private String EXCLUIR_CLIENTE="DELETE FROM  tb_cliente WHERE ID=?;";
	private String ALTERAR_CLIENTE="UPDATE  tb_cliente SET nome=?,email=?,cpf=?,celular=?,idade=?,sexo=?,cidade=?,escolaridade=?,qualificacoes=?,senha=? WHERE id=?;";
	private String CADASTRAR_SQL ="INSERT INTO tb_cliente (nome,email,cpf,celular,\"\r\n" + 
			"			+ \"idade,sexo,cidade,escolaridade,qualificacoes,senha) values(?, ?, ?, ?,?,?,?,?,?,?);";
	private String SELECIONA="SELECT * FROM  tb_cliente WHERE ID=?;";
	
	//private String PROCURAR="SELECT * FROM produto WHERE  nome LIKE ?";
	
	public Cliente autenticar(String email, String senha) throws SQLException, ClassNotFoundException, IOException {
		Cliente c=null;
		//Abrir uma conexão
		openConnection();
		
		//Preparar o script
		ps = connect.prepareStatement(LOGIN_SQL);
		ps.setString(1, email);
		ps.setString(2, senha);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs != null)
			while(rs.next()) {
				c=new Cliente(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getString("cpf")
						,rs.getString("celular"),rs.getString("idade"),rs.getString("sexo")
						,rs.getString("cidade"),rs.getString("escolaridade"),rs.getString("qualificacoes")
						,rs.getString("senha"));
			}
		
		//Fechar a conexão
		closeConnection();
		
		return c;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	

	public Cliente cadastrar(String nome, String email, String cpf,
			String celular,String idade,String sexo,String cidade,
			String escolaridade,String qualificacoes,String senha) throws SQLException, ClassNotFoundException, IOException {
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

		
		ResultSet rs=ps.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				
				c=new Cliente(rs.getInt("id"), rs.getString(rs.getString("nome")),
						rs.getString(rs.getString("email")), rs.getString(rs.getString("cpf")),
						 rs.getString(rs.getString("celular")), rs.getString(rs.getString("idade")),
						 rs.getString(rs.getString("sexo")),
						 rs.getString(rs.getString("cidade")), rs.getString(rs.getString("escolaridade")),
						 rs.getString(rs.getString("qualificacoes")), rs.getString(rs.getString("senha")));
			}
		}
		
		//Fechar conexão
		closeConnection();
		
		return c;
	}

	///////////////////////////////////////////////////////////////////////////////////////////
	
	public List<Cliente> listarClientes() throws ClassNotFoundException, IOException, SQLException{
		List<Cliente> lista = new ArrayList<Cliente>();
		// Abrir conexão
		openConnection();
		
		// Executar o script
		ps = connect.prepareStatement(LISTAR_CLIENTE);
		ResultSet rs = ps.executeQuery();
		
		//Analisar o retorno do script
		if(rs != null){
			while(rs.next()){
				Cliente c = new Cliente(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getString("cpf")
						,rs.getString("celular"),rs.getString("idade"),rs.getString("sexo")
						,rs.getString("cidade"),rs.getString("escolaridade"),rs.getString("qualificacoes")
						,rs.getString("senha"));
				lista.add(c);
			}
		}
		
		closeConnection();
		
		return lista;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	public Cliente obterClientePorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
		Cliente c=null;
		ClienteService service=new ClienteService();
		List<Cliente> listaCliente=service.listaClientes();
		
		openConnection();
		
		ps=connect.prepareStatement(SELECIONA);
		ps.setInt(1, id);
		
		for(int i=0;i<listaCliente.size();i++) {
			if(id==listaCliente.get(i).getId()) {
				c=listaCliente.get(i);
			}
		}
		
		closeConnection();
		
		return c;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public void excluir(String id) throws SQLException, ClassNotFoundException, IOException {
		Integer idCliente=Integer.parseInt(id);
		
		//Abrir conexão
		openConnection();
		
		ps = connect.prepareStatement(EXCLUIR_CLIENTE);
		ps.setInt(1, idCliente);
		
		ps.execute();
		
		//Fechar conexão
		closeConnection();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	public void alterar(String id,String nome, String email, String cpf,
			String celular,String idade,String sexo,String cidade,
			String escolaridade,String qualificacoes,String senha) throws SQLException, ClassNotFoundException, IOException {
		//Cliente c=new Cliente(id, nome, cpf, email, senha);
		
		Integer idCliente = Integer.parseInt(id);
		
		//Abrir conexão
		openConnection();
		
		ps = connect.prepareStatement(ALTERAR_CLIENTE);
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
		ps.setInt(11, idCliente);
		
		ps.execute();
		
		//Fechar conexão
		closeConnection();
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////
	
	//private String PROCURAR="SELECT * FROM tb_cliente WHERE cidade LIKE '%?%';";
	
	private String PROCURAR="SELECT * FROM tb_cliente WHERE cidade LIKE ?;";
	
	
	public ArrayList<Cliente> procurar(String cidade) throws SQLException, ClassNotFoundException, IOException{
		
		openConnection();
		
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		ps = connect.prepareStatement(PROCURAR);
	
		ps.setString(1,"%"+cidade+"%");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			
			Cliente cliente=new Cliente();
			
			
			cliente.setId(rs.getInt("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setEmail(rs.getString("email"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setCelular(rs.getString("celular"));
			cliente.setIdade(rs.getString("idade"));
			cliente.setSexo(rs.getString("sexo"));
			cliente.setCidade(rs.getString("cidade"));
			cliente.setEscolaridade(rs.getString("escolaridade"));
			cliente.setQualificacoes(rs.getString("qualificacoes"));
			cliente.setSenha(rs.getString("senha"));

			//comando para adicionar produto em produtos instância do List
			
			lista.add(cliente);
			

	
		}
		
		
		return lista;
		
	}
	
}
