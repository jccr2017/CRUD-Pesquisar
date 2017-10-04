<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Clientes</title>


<style type="text/css">


#nav {
       padding:30px;
       /*float:left;*/
       width:100%;
       background-color:#363636;
}

#nav ul {
        font:16px arial,tahoma,verdana;
		list-style:none;
		margin:0;
		padding:0;
}
#nav ul li {
         float:left;
		 position:relative;
		 display:block;
}
#nav ul li a {
           color:#555;
		   background:#fff;
		   text-decoration:none;
		   margin:0 1px;
		   padding:15px 20px;
		   border-top:1px solid #555;
		   display:block;
}
#nav li ul {
          display:none;
}
#nav ul li a:hover {
                 background:#066;
				 color:#fff;
}
#nav li:hover ul {
               display:block;
			   position:relative;
}
#nav li:hover li {
              float:none;
			  font-size:12px;
}
#nav li:hover a {
              background:#333;
			  color:#fff;
}
#nav li:hover li a:hover {
                      background:#222;
}

body {
  font: 75%/1.6 "Myriad Pro", Frutiger, "Lucida Grande", "Lucida Sans", "Lucida Sans Unicode", Verdana, sans-serif;
}
table {
  border-collapse: collapse;
  width: 90em;
  border: 1px solid #666;
  		position:absolute;
		left:10%;
		top:40%;


  
}
thead {
  background: #ccc url(https://www.devfuria.com.br/html-css/tabelas/bar.gif) repeat-x left center;
  border-top: 1px solid #a5a5a5;
  border-bottom: 1px solid #a5a5a5;
}

thead tr:hover {
  background-color: transparent;
  color: inherit;
}
tr:nth-child(even) {
    background-color: #edf5ff;
}

th {
  font-weight: normal;
  text-align: left;
}
th, td {
  padding: 0.1em 1em;
}

</style>




</head>
<body>

<%@ include file="Menuempregador.jsp" %>

 <body bgcolor="#E8E8E8">  
 
 <center>

<form action="/ProjetoFinal/ProcurarServlet" method="get">

Digite a cidade:
<input type="text" id="cidade" name="cidade" value=""/>

<input type="submit" value="procurar"/>


</form>
</center>

 



<!--  ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,, -->

<br>
<c:choose>
	<c:when test="${not empty listaClientes}">
		<table>
			<tr>
				<th><strong>Id</strong></th>
				<th><strong>Nome</strong></th>
				<th><strong>Email</strong></th>
				<th><strong>Cpf</strong></th>
				<th><strong>Celular</strong></th>
				<th><strong>Idade</strong></th>
				<th><strong>Sexo</strong></th>
				<th><strong>Cidade</strong></th>
				<th><strong>Escolaridade</strong></th>
				<th><strong>Qualificações</strong></th>
				
				
				
				<!--  
				<th>Excluir </th> 
				<th>Senha</th>
				<th>Exemplo</th>
				-->
				
				
			
			</tr>
			<c:forEach var="cliente" items="${listaClientes}">
			<tr>
				<td>${cliente.id}</td>
				<td>${cliente.nome}</td>
				<td>${cliente.email}</td>
				<td>${cliente.cpf}</td>
				<td>${cliente.celular}</td>
				<td>${cliente.idade}</td>
				<td>${cliente.sexo}</td>
				<td>${cliente.cidade}</td>
				<td>${cliente.escolaridade}</td>
				<td>${cliente.qualificacoes}</td>
				
				<!--  
				
				<td>${cliente.senha}</td>
				 -->
				
			
				
				
				
				
				<!-- 
				
					
					<td>
				
					<a href="/ProjetoFinal/ExcluirClienteServlet?id=${cliente.id}">Excluir</a>
					</td>
				
				<td> <a href="/ProjetoFinal/ObterClienteServlet?id=${cliente.id}">Exibir</a> </td>
				
				 -->
				
		
										
		
			</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	Não tem ninguem!!!
	</c:otherwise>
</c:choose>



</body>
</html>