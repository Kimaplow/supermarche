<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<%@ page import="java.util.HashMap, magasin.Article, magasin.Supermarche, java.lang.Boolean, java.text.DecimalFormat, java.math.RoundingMode" %>

<%-- On récupère le panier et sas Article --%>
<% Supermarche sup = (Supermarche)request.getAttribute("supermarche"); %>
<% HashMap<String, Article> articles = null; %>
<% if(sup != null) { articles = sup.getArticles();} %>

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.2.0/darkly/bootstrap.min.css" />
<title>Panier</title>
</head>
<body>

	<h1 class="text-center m-auto mt-5">PANIER</h1>
	
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
					<th>Prix TTC</th>
					<th>Suppression</th>
				</tr>
			</thead>
			<%-- On déclare un Article, le prixTTC pour l'Article, la sommeTTC et pour les deux TVA, et un format pour l'affichage --%>
			<% Article a = null; %>
			<% double prixTTC = 0; %>
			<% double sommeTTC = 0; %>
			<% double sommeTvaCinq = 0; %>
			<% double sommeTvaVingt = 0; %>
			<% DecimalFormat df = new DecimalFormat("#.##"); %>
			<% df.setRoundingMode(RoundingMode.HALF_EVEN); %>
			<%-- Pour chaque Article --%>
			<% for(HashMap.Entry<String, Article> art : articles.entrySet()) { %>
				<% a = art.getValue(); %>
				<%-- On calcule son prix et la TVA payée selon la TVA --%>
				<% if(a.getTVA() == 550) { %>
					<% prixTTC = (double)(a.getPrixHT() * 1.055);%>
					<% sommeTvaCinq += prixTTC - a.getPrixHT(); %>
				<% } else { %>
					<% prixTTC = (double)(a.getPrixHT() * 1.2); %>
					<% sommeTvaVingt += prixTTC - a.getPrixHT(); %>
				<% } %>
				<% sommeTTC += prixTTC; %>
				<%-- On affiche l'Article --%>
				<tr>
					<td><%= a.getCodeBarre() %></td>
					<td><%= a.getReference() %></td>
					<td><%= a.getLibelle() %></td>
					<td><%= df.format((double)a.getPrixHT()/100) %></td>
					<td><%= a.getTVA() == 550 ? ("5,5%") : ("20%")%></td>
					<td><%= df.format(prixTTC/100) %></td>
					<td><form method="POST"><input type="submit" class="btn btn-primary" name="<%= a.getReference() %>" value="Supprimer du panier"></form></td>
				</tr>
			<% } %>
			
		</table>
		
		<div class="card border-secondary mt-4 mb-3 w-25 m-auto">
  			<div class="card-header text-center">Récapitulatif</div>
  			<div class="card-body">
    			<p class="card-text text-success text-center"><strong>Total</strong> : <%= df.format(sommeTTC/100) %> euros</p>
    			<p class="card-text text-warning text-center"><strong>TVA 5,50%</strong> : <%= df.format(sommeTvaCinq/100) %> euros</p>
    			<p class="card-text text-warning text-center"><strong>TVA 20%</strong> : <%= df.format(sommeTvaVingt/100) %> euros</p>
  			</div>
  		</div>
	
	<% } else { %>
		<h4 class="text-center m-auto mt-3">Pas d'article dans le panier :(</h4>
	<% } %>
	
	<div class="text-center m-auto mt-3">
		<a href="<%= request.getContextPath ()%>/Home">Revenir à l'accueil</a>
	</div>

</body>
</html>