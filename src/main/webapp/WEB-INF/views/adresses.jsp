<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<title>Formulaire adresse</title>
</head>
<body>
	<h2>CRUD ADRESSES</h2>
	<div>
		<f:form modelAttribute="adresse" method="POST" action="saveAdresse">
			<table>
				<tr>
					<td><f:hidden path="idadresse"/> </td>
				</tr>
				<tr>
					<td>NUM RUE:</td>
					<td><f:input path="numRue" /></td>
					<td><f:errors path="numRue" cssClass="error"/></td>
				</tr>
				<tr>
					<td>NOM RUE:</td>
					<td><f:input path="nomRue" /></td>
					<td><f:errors path="nomRue" cssClass="error"/></td>
				</tr>
				<tr>
					<td>CODE POSTAL:</td>
					<td><f:input path="cp" /></td>
					<td><f:errors path="cp" cssClass="error"/></td>
				</tr>
				<tr>
					<td>VILLE:</td>
					<td><f:input path="ville" /></td>
					<td><f:errors path="ville" cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="enregistrer" /></td>
				</tr>
			</table>
		</f:form>
	</div>
	<div id="listProduits">
		<table class="table1">
			<tr>
				<th>ID</th>
				<th>NUM RUE</th>
				<th>NOM RUE</th>
				<th>CP</th>
				<th>VILLE</th>
				<th>SUPPRIMER</th>
				<th>MODIFIER</th>
			</tr>
			<c:forEach var="a" items="${adresses}">
				<tr>
					<td>${a.idadresse}</td>
					<td>${a.numRue}</td>
					<td>${a.nomRue}</td>
					<td>${a.cp}</td>
					<td>${a.ville}</td>
					<td><a href="deleteAdresse?idadresse=${a.idadresse}">supprimer</a></td>
					<td><a href="editAdresse?idadresse=${a.idadresse}">editer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>