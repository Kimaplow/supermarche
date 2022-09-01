<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.2.0/darkly/bootstrap.min.css" />
</head>
<body>

	<div class='d-flex justify-content-center'>

		<form method="POST">

			<h1 class='text-center m-auto mt-5'>Connexion</h1>

			<div class="form-group div-btn-form">
				<label class="mt-2 fw-bold" for="id">Identifiant</label>
				<input type="text" class="form-control" name="id" required />
				<label class="mt-3 fw-bold" for="password">Mot de passe</label>
				<input type="password" class="form-control" name="password" required />
			</div>

			<div class="d-flex mt-4">
				<button type="submit" class="btn btn-primary m-auto">SE CONNECTER</button>
			</div>

		</form>

	</div>
	
	<div class="text-center m-auto mt-3">
		<a href="<%=application.getContextPath()%>/Home">Revenir à l'accueil</a>
	</div>

</body>
</html>