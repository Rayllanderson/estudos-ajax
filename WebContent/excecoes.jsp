<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exceções</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>

	<h3>Capturando Exceções com ajax</h3>
	<h4>Digite apenas números:</h4>
	<input type="text" value="teste" id="txtValor">
	<input type="button" onclick="testeJquery()" value="Testar">
	
<script type="text/javascript">

function testeJquery(){
	let valorInformado = $('#txtValor').val();
	
	$.ajax({
	    method: "POST",
    	    url: "CapturarExcecao",
	    data: { valorParam : valorInformado}
	}).done(function(response){
		alert(response)
	}).fail(function(xhr, status, errorThrown) {
	    alert(xhr.responseText);
	});
}

</script>
</body>
</html>