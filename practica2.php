<!DOCTYPE html >
<html lang="es">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="whidth=device-width, initial-scale=1.0">
		<meta name="keywords" content="HTML5, CSS, Javascript">
		<title>Título de la página</title>
	</head>
	<body>
	      <?php
                
                $numero = rand(1,4);
                $color =["#bdfcff","#487e8a","#7747b6","#4336f4"];
                $numcolor = rand(0,3);

                echo "numero generado =" . $numero ."<br>";
                echo "<div style='color:". $color[$numcolor]."'> color generado </div>";

                 if($numero == 1){
                ?>
                <h1 style="color: <?php echo $color[$numcolor]; ?>">Titulo de la pagina</h1>

             <?php }  elseif($numero ==2 ) { ?>
        
                <h2 style="color: <?php echo $color[$numcolor]; ?>">Titulo de la pagina 2</h2>

             <?php }  elseif($numero ==3 ) { ?>
        
                <h2 style="color: <?php echo $color[$numcolor]; ?>">Titulo de la pagina 3</h2>
              <?php } else { ?>
           
               <h4 style="color: <?php echo $color[$numcolor]; ?>">Titulo 4 de la pagina</h4>
             <?php } ?>
	</body>
</html>