<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personne</title>
<link rel="stylesheet" href="./css/Main.css" />
<link rel="stylesheet" href="./css/Bootstrap.css" />
</head>
<body>
<section class="container">
		<h1 id="top"> Formulaire d'inscription</h1>
		<div>
			<form action="ServletPersonne">

				<div class="form-group row">
					<input type="hidden" name="id" value="${id}" /> 
					<label for="prenom">Prénom</label>
					<input id="prenom" class="form-control" placeholder="Entrer prénom"
						type="text" name="prenom" value="${prenom}" required />
				</div>
				<div class="form-group row">
					<label for="nom">Nom</label> 
					<input id="nom" class="form-control"
						placeholder="Entrer nom" type="text" name="nom" value="${nom}"
						required />
				</div>
				<div class="form-group row">
					<label for="age">Age</label> 
					<input id="age" class="form-control"
						placeholder="Entrer age" type="number" name="age" value="${age}"
						required />
				</div>
				<div class="bar">
					<button type="submit" class="btn btn-primary" name="valider"
						value="Valider">Valider</button>
				</div>

			</form>
		</div>
	</section>
	<section class="container">
		<h2>Liste des personnes</h2>
		<table class="table">
			<thead> 
				<tr>
					<td>ID</td>
					<td>Nom</td>
					<td>Prénom</td>
					<td>Age</td>
					<td>Modifier</td>
					<td>Supprimer</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${! empty personne}">
					<c:forEach items="${personne}" var="x">
						<tr>
							<td><c:out value="${x.id}" /></td>
							<td><c:out value="${x.nom}" /></td>
							<td><c:out value="${x.prenom}" /></td>
							<td><c:out value="${x.age}" /></td>
							<td><a href="ModifierPers?id=${x.id}">Modifier</a></td>
							<td><a href="SupprimerPers?id=${x.id}">Supprimer</a></td>

						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</section>
</body>
</html>