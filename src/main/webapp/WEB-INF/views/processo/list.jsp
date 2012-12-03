<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Processos Em Execução <br/>  
</h1>

  <a href="processo/new">Novo Processo</a> 

 <table border="1" style="width: 80%; " >
    <caption>Lista de processos</caption>
  <tr>
    <th>Nome</th>
    <th>Descrição</th>
    <th>Opção</th>
  </tr>
  <c:forEach  var="proc"  items="${ processos }">
  <tr>
    <td>${proc.nome }</td>
    <td>${proc.descricao }</td>
	<td><a href="processo/edit/${proc.id}"  >Editar</a>
		|
	    <a href="processo/delete/${proc.id}" onclick="return confirm('Deseja realmente deletar?');">Deletar</a></td>
	    
  </tr>
  </c:forEach>
</table>



</body>
</html>
