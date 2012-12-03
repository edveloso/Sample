<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Esta é a página de formulário</h1>
	
	
	  <c:choose>
		<c:when test="${empty processo.id}">
    		<c:set var="action" value="save" />
    		<c:set var="task" value="../processo/tarefa" />
    	</c:when>
    	<c:otherwise>
    		<c:set var="action" value="../update" />
    		<c:set var="task" value="../../processo/tarefa" />
    	</c:otherwise> 
	  </c:choose>

	<f:form action="${action}" modelAttribute="processo"> 

		<c:if test="${not empty processo.id}">
		  <f:hidden path="id"/> 
			<f:label path="id">Id</f:label>
		    ${processo.id} 
			<br />
		</c:if>

		<f:label path="nome">Nome</f:label>
		<f:input path="nome" />
		<br />

		<f:label path="descricao">Descrição</f:label>
		<f:input path="descricao" />
		<br />
		<f:button value="Salvar">Salvar2</f:button>
	</f:form>


   <br/> Completar tarefa <a href="${task}">Go</a> 

</body>
</html>
