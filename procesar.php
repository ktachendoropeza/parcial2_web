<?php
$nombre = $_POST['Nombre'];
$correo = $_POST['correo'];
$edad = $_POST['edad'];

echo "Nombre: " . $nombre . "<br/>";
echo "correo: " . $correo . "<br/>";
echo "edad: " . $edad . "<br/>"; 

$pregunta1 =$_POST['Pregunta1'];
$pregunta2 =$_POST['Pregunta2'];
$pregunta3 =$_POST['Pregunta3'];
$pregunta4 =$_POST['Pregunta4'];
$pregunta5 =$_POST['Pregunta5'];
$pregunta6 =$_POST['Pregunta6'];
$pregunta7 =$_POST['Pregunta7'];
$pregunta8 =$_POST['Pregunta8'];
$pregunta9 =$_POST['Pregunta9'];
$pregunta10 =$_POST['Pregunta10'];


$mensaje = "";

$puntos = 0;



if($pregunta1 == "v")
{
	$puntos = $puntos + 2;
}
if($pregunta2 == "v")
{
	$puntos = $puntos + 2;
}
if($pregunta3 == "v")
{
	$puntos = $puntos + 2;
}
if($pregunta4 == "v")
{
	$puntos = $puntos + 2;
}
if($pregunta5 == "f")
{
	$puntos = $puntos + 2;
}
if($pregunta6 == "v")
{
	$puntos = $puntos + 2;
}
if($pregunta7 == "v")
{
	$puntos = $puntos + 2;
}
if($pregunta8 == "v")
{
	$puntos = $puntos + 2;
}
if($pregunta9 == "f")
{
	$puntos = $puntos + 2;
}
if($pregunta10 == "f")
{
	$puntos = $puntos + 2;
}




if(($puntos == 2) || ($puntos == 6))
{
	$mensaje="No le sabes papu";
} else if(($puntos ==6 ) || ($puntos == 8))
{
	$mensaje="un papu de closet";
} else if(($puntos ==8 ) || ($puntos == 10))
{
	$mensaje="c Mr graso sos";
} 


echo "Puntuacion= $puntos <br> $mensaje <br>";
echo "<b>respuestas</b><br>";
echo "1.-2013<br>2.-Mr graso<br>3.-Para referirce a cuando<br>4.-un meme simplificado al punto de ser gracioso o incomodo<br>5.-un termino utilizado en sdlg para mienbros del grupo<br>";

?>