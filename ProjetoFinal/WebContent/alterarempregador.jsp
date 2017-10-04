<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Empregador</title>

<!--  
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
</style>


-->




</head>
<body>

<%@ include file="Menuempregador.jsp" %>

<body bgcolor="#E8E8E8"> 





</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>





	<form action="/ProjetoFinal/AlterarEmpregadorServlet" method="post">
	
	<center> 
		ID:<input type="text" id="id" name="id" value="${empregador.id}" readonly="readonly"/>
		<br>
		<br>
		NOME:<input type="text" id="nome" name="nome" value="${empregador.nome}"/>
		
		EMAIL:<input type="text" id="email" name="email" value="${empregador.email}"/>
			<br>
		<br>
		CPF:<input type="text" id="cpf" name="cpf" value="${empregador.cpf}"/>
		CELULAR:<input type="text" id="celular" name="celular" value="${empregador.celular}"/>
			<br>
		<br>
		IDADE:<input type="text" id="idade" name="idade" value="${empregador.idade}" />
			<br>
		<br>
		SEXO:<input type="text" id="sexo" name="sexo" value="${empregador.sexo}"/>
		
		CIDADE:<input type="text" id="cidade" name="cidade" value="${empregador.cidade}"/>
		</br>
		</br>
		SENHA:<input type="text" id="senha" name="senha" value="${empregador.senha}"/>
			<br>
		<br>
		
		<input type="submit" value="Alterar"/>
		
		</center>
	</form>



</body>
</html>