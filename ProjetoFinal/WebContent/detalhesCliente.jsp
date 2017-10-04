<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhes</title>

</head>
<body>


<%@ include file="Menufuncionario.jsp" %>


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



	<form action="/ProjetoFinal/AlterarClienteServlet" method="post">
	<center>
	
	
	
		ID:<input type="text" id="id" name="id" value="${cliente.id}" readonly="readonly"/>
		</br>
		</br>
		NOME:<input type="text" id="nome" name="nome" value="${cliente.nome}"/>

		EMAIL:<input type="text" id="email" name="email" value="${cliente.email}"/>
		</br>
		</br>
		CPF:<input type="text" id="cpf" name="cpf" value="${cliente.cpf}"/>

		CELULAR:<input type="text" id="celular" name="celular" value="${cliente.celular}"/>
		</br>
		</br>
		IDADE:<input type="text" id="idade" name="idade" value="${cliente.idade}" />

		SEXO:<input type="text" id="sexo" name="sexo" value="${cliente.sexo}"/>
		</br>
		</br>
		CIDADE:<input type="text" id="cidade" name="cidade" value="${cliente.cidade}"/>

		ESCOLARIDADE:<input type="text" id="escolaridade" name="escolaridade" value="${cliente.escolaridade}"/>
		</br>
		</br>
		


QUALIFICAÇÕES:<input  style="height: 30px" size="50" type="text" id="qualificacoes" name="qualificacoes" value="${cliente.qualificacoes}"/>
</br>
</br>


		SENHA:<input type="text" id="senha" name="senha" value="${cliente.senha}"/>
		
		</br>
		</br>
		<input type="submit" value="Alterar"/>
		
		</center>
	</form>


</body>
</html>