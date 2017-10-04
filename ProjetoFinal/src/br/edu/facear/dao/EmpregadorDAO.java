package br.edu.facear.dao;

import java.io.IOException;





import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.edu.facear.model.Empregador;

import br.edu.facear.service.EmpregadorService;

public class EmpregadorDAO extends GenericDAO {
	
	private PreparedStatement ps;
	
	private String CADASTRAR_SQL ="INSERT INTO empregador (nome,email,cpf,celular,"
			+ "idade,sexo,cidade,senha) values(?, ?, ?, ?,?,?,?,?);";

	
	private String LOGIN_SQL ="SELECT * FROM empregador WHERE EMAIL = ? AND SENHA = ?;";
	
	private String ALTERAR_CLIENTE="UPDATE  empregador SET nome=?,"
			+ "email=?,cpf=?,celular=?,idade=?,sexo=?,cidade=?,senha=? WHERE id=?;";
	
	private String SELECIONA="SELECT * FROM  empregador WHERE ID=?;";
	
	private String LISTAR_CLIENTE="SELECT * FROM  empregador;";
	
	private String EXCLUIR_CLIENTE="DELETE FROM  empregador WHERE ID=?;";
	
	
	
////////////////////////////////////
	
	public Empregador cadastrar(String nome,String email,String cpf,String celular,
			String idade,String sexo,String cidade,String senha)
					throws SQLException, ClassNotFoundException, IOException {
		Empregador c=null;
		
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
		ps.setString(8, senha);

		
		ps.executeUpdate();
		
		closeConnection();
		
		return c;
	}
	

	///////////////////////////////////////////////////////////////////////////////////
		
	public Empregador autenticar(String email, String senha) throws SQLException, ClassNotFoundException, IOException {
		Empregador c=null;
		//Abrir uma conexão
		openConnection();
		
		//Preparar o script
		ps = connect.prepareStatement(LOGIN_SQL);
		ps.setString(1, email);
		ps.setString(2, senha);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs != null)
			while(rs.next()) {
				c=new Empregador(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getString("cpf")
						,rs.getString("celular"),rs.getString("idade"),rs.getString("sexo")
						,rs.getString("cidade")
						,rs.getString("senha"));
			}
		
		//Fechar a conexão
		closeConnection();
		
		return c;
	}

	
	////////////////////////////////////////////////////////////////////////


public void alterar(String id,String nome, String email, String cpf,
		String celular,String idade,String sexo,String cidade,
String senha) throws 
SQLException, ClassNotFoundException, IOException {
	
	//Cliente c=new Cliente(id, nome, cpf, email, senha);
	
	Integer idempregador = Integer.parseInt(id);
	
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
	ps.setString(8, senha);
	ps.setInt(9, idempregador);
	
	ps.execute();
	
	//Fechar conexão
	closeConnection();
}



/////////////////////////////////////////////////////////////////////////


public Empregador obterEmpregadorPorId(Integer id) throws SQLException, ClassNotFoundException, IOException {
	Empregador c=null;
	EmpregadorService service=new EmpregadorService();
	
	List<Empregador> listaEmpregador=service.listaEmpregadores();
	
	openConnection();
	
	ps=connect.prepareStatement(SELECIONA);
	ps.setInt(1, id);
	
	for(int i=0;i<listaEmpregador.size();i++) {
		if(id==listaEmpregador.get(i).getId()) {
			c=listaEmpregador.get(i);
		}
	}
	
	closeConnection();
	
	return c;
}

//////////////////////////////////////////////////////////////////

public List<Empregador> listarEmpregadores() throws ClassNotFoundException, IOException, SQLException{
	List<Empregador> lista = new ArrayList<Empregador>();
	// Abrir conexão
	openConnection();
	
	// Executar o script
	ps = connect.prepareStatement(LISTAR_CLIENTE);
	ResultSet rs = ps.executeQuery();
	
	//Analisar o retorno do script
	if(rs != null){
		while(rs.next()){
			Empregador c = new Empregador(rs.getInt("id"),rs.getString("nome"),rs.getString("email"),rs.getString("cpf")
					,rs.getString("celular"),rs.getString("idade"),rs.getString("sexo")
					,rs.getString("cidade")
					,rs.getString("senha"));
			lista.add(c);
		}
	}
	
	closeConnection();
	
	return lista;
}



///////////////////////////////////////////////////////////////////

public void excluir(String id) throws SQLException, ClassNotFoundException, IOException {
	Integer idempregador=Integer.parseInt(id);
	
	//Abrir conexão
	openConnection();
	
	ps = connect.prepareStatement(EXCLUIR_CLIENTE);
	ps.setInt(1, idempregador);
	
	ps.execute();
	
	//Fechar conexão
	closeConnection();
}









}
	

