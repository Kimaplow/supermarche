<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<%@ page import="java.util.HashMap, magasin.Article, magasin.Supermarche" %>

<%-- On récupère les Supermarche et ses Articles --%>
<% ServletContext context = this.getServletContext(); %>
<% Supermarche sup = ((Supermarche)context.getAttribute("supermarche")); %>
<% HashMap<String, Article> articles = null; %>
<% if(sup != null) { articles = sup.getArticles();} %>

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.2.0/darkly/bootstrap.min.css" />
<title>Gestion des articles</title>
</head>
<body>
	<h1 class="text-center m-auto mt-5">GERER LES ARTICLES</h1>
	
	<%-- Si le Supermarche n'est pas null et vide --%>
	<% if(sup != null && !sup.isEmpty()) { %>
	
		<table class="table w-50 table-bordered text-center m-auto mt-2">	
			<thead class="table-secondary">
				<tr>
					<th>Code barre</th>
					<th>Reference</th>
					<th>Libelle</th>
					<th>Prix HT</th>
					<th>TVA</th>
					<th>Modification</th>
					<th>Suppression</th>
				</tr>
			</thead>
			
			<% for(HashMap.Entry<String, Article> art : articles.entrySet()) { %>
				<% Article a = art.getValue(); %>
				<tr>
					<td><%= a.getCodeBarre() %></td>
					<td><%= a.getReference() %></td>
					<td><%= a.getLibelle() %></td>
					<td><%= (double)a.getPrixHT()/100 %></td>
					<td><%= a.getTVA() == 550 ? ("5,5%") : ("20%")%></td>
					<td><a href="<%= request.getContextPath()%>/Manage/UpdateArticle?ref=<%= a.getReference() %>" class="btn btn-primary">Modifier</a></td>
					<td><form method="POST"><input type="submit" class="btn btn-primary" name="<%= a.getReference() %>" value="Supprimer"></form></td>
				</tr>
			<% } %>
			
		</table>
	
	<% } else { %>
		<h4 class="text-center m-auto mt-3">Pas d'article dans le magasin</h4>
	<% } %>
	
	<div class="text-center m-auto mt-3">
		<a href="<%=application.getContextPath()%>/Manage/AddArticle">Ajouter un article</a>
	</div>
	
	<div class="text-center m-auto mt-3">
		<a href="<%=application.getContextPath()%>/Home">Revenir à l'accueil</a>
	</div>
	
</body>
</html>