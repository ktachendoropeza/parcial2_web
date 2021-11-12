<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Detalle de registro</title>
</head>
<body>
<?php 

	$registros = array(
		array("id" => 1, "nombre" => "Juan", "edad" => 25, "sexo" => "M"),
		array("id" => 2, "nombre" => "Luis", "edad" => 35, "sexo" => "M"),
		array("id" => 3, "nombre" => "Maria", "edad" => 55, "sexo" => "F"),
		array("id" => 4, "nombre" => "Claudia", "edad" => 19, "sexo" => "F"),
		array("id" => 5, "nombre" => "Blanca", "edad" => 89, "sexo" => "F"),
		array("id" => 6, "nombre" => "Pedro", "edad" => 56, "sexo" => "M"),
	);

	

	if (isset($_GET["id"])) {
		$id = $_GET["id"] - 1;
		echo "<h1>Datos de la persona</h1><hr>";
		echo "ID: ". $_GET["id"] . "<br>";
		echo "Nombre: ". $registros[$id]["nombre"] . "<br>";
		echo "edad: ". $registros[$id]["edad"] . "<br>";
		echo "sexo: ". $registros[$id]["sexo"] . "<br>";
	}
	else
	{
		echo "<h1>El dato de ID es requerido</h1>";
	}
 ?>
</body>
</html>