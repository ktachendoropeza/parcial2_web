<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Práctica 5. Intercambio de variable PHP</title>
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
	?>
	<h1>Tabla de registros</h1><hr>
	<table border=1>
		<thead>
			<tr>
				<td>ID</td>
				<td>Nombre</td>
				<td>Edad</td>
				<td>Sexo</td>
				<td>Detalle</td>
			</tr>
		</thead>
		<tbody>
			<?php 
				for ($i=0; $i < count($registros); $i++) { 
					echo "<tr>";
						echo "<td>".$registros[$i]["id"]."</td>";
						echo "<td>".$registros[$i]["nombre"]."</td>";
						echo "<td>".$registros[$i]["edad"]."</td>";
						echo "<td>".$registros[$i]["sexo"]."</td>";
						echo "<td><a href='practica5_detalle.php?id=".$registros[$i]["id"]."'>Ver detalle</a></td>";
					echo "</tr>";
				}
			?>
		</tbody>
	</table>
</body>
</html>