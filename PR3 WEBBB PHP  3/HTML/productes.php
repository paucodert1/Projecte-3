<?php
include '../PHP/function.php';
session_start();
con();
obtenirProductes();
// modificarDadesPerfil();
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>productes</title>
    <link rel="shortcut icon" href="../img/logo3.png" type="image/x-icon">
    <link rel="stylesheet" href="../css/estils.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <div class="header">
        <!-- NAVBAR -->
        <div class="nav">
            <div class="logo">
                <img src="../img/logo_llarg2.png" alt="logo">
            </div>
            <ul class="nav-links">
                <li>
                    <a href="../HTML/index.html">Inici</a>
                </li>
                <li>
                    <a href="#">Nosaltres</a>
                </li>
                <li>
                    <a href="#">Temps</a>
                </li>
                <li>
                    <a href="#"><i class='bx bx-cart' style='font-size: 25px;'></i></a>
                </li>
                <li>
                    <div class="dropdown">
                        <a class="dropbtn"><i class='bx bx-user' style='font-size: 25px;'></i></a>
                        <div id="myDropdown" class="dropdown-content">
                          <a href="../HTML/perfil.php">Perfil</a>
                          <a href="../HTML/historial.html">Historials</a>
                          <a href="../HTML/index.html">Tancar Sessio</a>
                        </div>
                    </div>
                </li>
            </ul>
            <div class="burger">
                <div class="line1"></div>
                <div class="line2"></div>
                <div class="line3"></div>
            </div>
        </div>
    </div>
    <!-- MAIN -->
    <div class="main">
        <div class="section">
            <div class="contenidor-botiga">
                <?php 
                    $result = obtenirProductes();
                    while($row = $result -> fetch_assoc()){
                ?>
                <div class="caixa">
                    <img src="../img/esqui-salo.jpeg" alt="">
                    <h2><?php echo $row['model']?></h2>
                    <h2><?php echo $row['marca']?></h2>
                    <span><?php echo $row['preu']?>€</span>
                    <a href="#"><i class='bx bx-cart'></i></a>
                </div>
                <?php } ?>
            </div>
        </div>
    </div>
    <!-- FOOTER -->
    <div class="footer">
        <div class="footer-content">
            <p>Contactans a les nostres xarxes socials</p>
            <ul class="socials">
                <li><a href="#"><i class='bx bxl-facebook-circle' style='font-size: 20px;'></i></a></li>
                <li><a href="#"><i class='bx bxl-twitter' style='font-size: 20px;'></i></a></li>
                <li><a href="#"><i class='bx bxl-google-plus' style='font-size: 20px;'></i></a></li>
                <li><a href="#"><i class='bx bxl-youtube' style='font-size: 20px;'></i></a></li>
                <li><a href="#"><i class='bx bxl-linkedin' style='font-size: 20px;'></i></a></li>
                <li><a href="#"><i class='bx bxl-instagram-alt' style='font-size: 20px;'></i></a></li>
            </ul>
        </div>
        <div class="footer-bottom">
            <p>copyright &copy;2022 pauRubio & SergiPont. disenyat per <span>nwn</span></p>
        </div>
    </div>
    <script src="../JS/app.js"></script>
    <script src="../JS/productes.js"></script>

</body>
</html>