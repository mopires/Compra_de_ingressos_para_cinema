<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cadastro</title>
</head>
<body>
	
	<form action="efetuaCadastro" method="post">
		
		<input type="text" 		name="cpf"   		>
		<input type="text" 		name="nome" 		>
		<input type="text" 		name="estudante" 	>
		<input type="password" 	name="senha"		>
		<input type="submit" 	value="Enviar">
		
	</form>


</body>
</html>