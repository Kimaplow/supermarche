<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="magasin.Article" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.2.0/darkly/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Ajouter un article</title>
</head>

<% Article art = (Article) request.getAttribute("article"); %>

<body>
	<div class='d-flex justify-content-center'>

		<form method="POST">

			<h1 class='text-center m-auto mt-5'>MODIFIER UN ARTICLE</h1>
			
			<%-- Si l'article existe --%>
			<% if(art != null) { %>

			<div class="form-group div-btn-form">
			
				<label class="mt-2 fw-bold" for="codeBarre">Code barre</label>
				<input type="number" class="form-control" name="codeBarre" placeholder="<%= art.getCodeBarre() %>" />
				
				<label class="mt-3 fw-bold" for="reference">Référence</label>
				<input type="text" class="form-control" name="reference" placeholder="<%= art.getReference() %>" />
				
				<label class="mt-3 fw-bold" for="libelle">Libellé</label>
				<input type="text" class="form-control" name="libelle" placeholder="<%= art.getLibelle() %>" />
				
				<label class="mt-3 fw-bold" for="prix">Prix</label>
				<input type="number" class="form-control" name="prix" placeholder="<%= art.getPrixHT() %>" />
				
				<label class="mt-3 fw-bold" for="tva">TVA</label>
				<select class="form-select" name="tva">
					<option value="3" selected>-- tva --</option>
					<option value="0">5,50</option>
					<option value="1">20</option>
				</select>
				
				<input type="hidden" name="ref" value="<%= art.getReference() %>"/>
				
			</div>

			<div class="d-flex mt-4">
				<button type="submit" class="btn btn-primary m-auto">Modifier l'article</button>
			</div>
			<% } else { %>
				<h4 class="text-center m-auto mt-3">Article non trouvé :(</h4>
			<% } %>
			
			<div class="text-center m-auto mt-3">
				<a href="<%=application.getContextPath()%>/Manage">Gérer les articles</a>
			</div>

		</form>

	</div>
</body>
</html>