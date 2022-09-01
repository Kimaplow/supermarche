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

<body>
	<div class='d-flex justify-content-center'>

		<form method="POST">

			<h1 class='text-center m-auto mt-5'>AJOUTER UN ARTICLE</h1>

			<div class="form-group div-btn-form">
			
				<label class="mt-2 fw-bold" for="codeBarre">Code barre</label>
				<input type="number" class="form-control" name="codeBarre" required />
				
				<label class="mt-3 fw-bold" for="reference">Référence</label>
				<input type="text" class="form-control" name="reference" required />
				
				<label class="mt-3 fw-bold" for="libelle">Libellé</label>
				<input type="text" class="form-control" name="libelle" required />
				
				<label class="mt-3 fw-bold" for="prix">Prix</label>
				<input type="number" class="form-control" name="prix" required />
				
				<label class="mt-3 fw-bold" for="tva">TVA</label>
				<select class="form-select" name="tva" required>
					<option value="" selected>-- tva --</option>
					<option value="0">5,50</option>
					<option value="1">20</option>
				</select>
				
			</div>

			<div class="d-flex mt-4">
				<button type="submit" class="btn btn-primary m-auto">Ajouter l'article</button>
			</div>
			
			<div class="text-center m-auto mt-3">
				<a href="<%=application.getContextPath()%>/Manage">Gérer les articles</a>
			</div>

		</form>

	</div>
</body>
</html>