<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html>

<%@ page import="java.util.HashMap, magasin.Article, magasin.Supermarche" %>

<%-- On récupère les Supermarche et ses Articles --%>
<% ServletContext context = this.getServletContext(); %>
<% Supermarche sup = ((Supermarche)context.getAttribute("supermarche")); %>
<% HashMap<String, Article> articles = null; %>
<% if(sup != null) { articles = sup.getArticles();} %>

<%-- On récupère le panier --%>
<% Supermarche panier = (Supermarche)session.getAttribute("panier"); %>

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.2.0/darkly/bootstrap.min.css" />
<title>Accueil</title>
</head>
<body>
	<h1 class="text-center m-auto mt-5">ACCUEIL</h1>
	
	<%-- Si le Supermarche n'est pas null et vide --%>
	<% if(sup != null && !sup.isEmpty()) { %>
	
		<table class="table w-50 table-bordered text-center m-auto mt-2">	
			<thead class="table-secondary">
				<tr>
					<th>Code barre</th>
					<th>Reference</th>
					<th>Libelle</th>
					<th>Prix HT</th>
					<th>Ajout</th>
				</tr>
			</thead>
			
			<% for(HashMap.Entry<String, Article> art : articles.entrySet()) { %>
				<% Article a = art.getValue(); %>
				<tr>
					<td><%= a.getCodeBarre() %></td>
					<td><%= a.getReference() %></td>
					<td><%= a.getLibelle() %></td>
					<td><%= (double)a.getPrixHT()/100 %></td>
					<td>
						<form method="POST">
							<%-- Si l'Article est déjà dans le panier, le bouton devient disabled --%>
							<input type="submit" class="btn btn-primary" name="<%= a.getReference() %>" value="Ajouter au panier" <%= panier != null && panier.getOneArticle(a.getReference()) != null ? "disabled" : "" %>>
						</form>
					</td>
				</tr>
			<% } %>
			
		</table>
	
	<% } else { %>
		<h4 class="text-center m-auto mt-3">Pas d'article dans le magasin</h4>
	<% } %>
	
	<div class="text-center m-auto mt-3">
		<a href="<%= request.getContextPath ()%>/Manage">Gerer les articles</a>
	</div>
	
	<div class="text-center m-auto mt-3">
		<a href="<%= request.getContextPath ()%>/Basket">Voir le panier</a>
	</div>
	
</body>
</html>