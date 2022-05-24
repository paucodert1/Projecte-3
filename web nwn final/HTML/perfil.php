<?php
include '../PHP/function.php';
session_start();
con();
modificarDadesPerfil();
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="shortcut icon" href="../img/logo3.png" type="image/x-icon">
    <link rel="stylesheet" href="../css/estils.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
<header>
    <div id="menu-bar"><i class='bx bx-menu' ></i></div>
    <img class="logo" src="../img/logo_llarg2.png">
    </a>

    <nav class="navbar">
        <a href="../HTML/index.html">Inici</a>
        <a href="../HTML/productes.php">Botiga</a>
        <a href="../HTML/sobre-nosaltres.html">Nosaltres</a>
        <a href="../HTML/historial.php">Historial</a>
    </nav>

    <div class="icons">
        <a href="../HTML/carro.php"><i class='bx bx-shopping-bag'></i></a>
        <a href="../HTML/temps.php"><i class='bx bx-cloud-snow'></i></a>
        <a href="../HTML/perfil.php"><i class='bx bxs-user'></i></a>
        <a href="../PHP/tanca-sessio.php"><i class='bx bx-log-out'></i></a>
        
    </div>

</header>
    <!-- MAIN -->
    <div class="main">
        <div class="section">
            <form class="form" method="POST">
                <?php if (isset($_POST['submit'])) {
                echo $_SESSION['error2'];
                } ?>
                <div class="taula-perfil">
                    <h1>Informació personal</h1>
                    <!-- nom -->
                    <h2>Nom</h2>
                    <input type="text" value="<?php echo $_SESSION['nom']?>" name="nom">
                    <!-- cognom1 -->
                    <h2>Cognom1</h2>
                    <input type="text" value="<?php echo $_SESSION['cognom1']?>" name="cognom1">
                    <!-- cognom2 -->
                    <h2>Cognom2</h2>
                    <input type="text" value="<?php echo $_SESSION['cognom2']?>" name="cognom2">
                    <!-- dni -->
                    <h2>Dni</h2>
                    <input type="text" value="<?php echo $_SESSION['dni'] ?>" name="dni">
                    <!-- tel -->
                    <h2>Tel</h2>
                    <input type="text" value="<?php echo $_SESSION['tel']?>" name="tel">
                    <!-- data -->
                    <h2>Data naixement</h2>
                    <input type="text" value="<?php echo $_SESSION['data']?>" name="data">
                    <!-- Sexe -->
                    <h2>Gènere</h2>
                    <input type="text" value="<?php echo $_SESSION['sexe']?>" name="sexe">
                    
                    <h1>Informació bancària</h1>
                    <!-- cbb -->
                    <h2>IBAN</h2>
                    <input type="text" value="<?php echo $_SESSION['cbb']?>" name="cbb">
                    <!-- usuari -->
                    <h2>Email</h2>
                    <input type="text" value="<?php echo $_SESSION['email']?>" name="email">
                    <!-- usuari -->
                    <h2>Usuari</h2>
                    <input type="text" value="<?php echo $_SESSION['usuari']?>" name="usuari">
                    <!-- passwd -->
                    <h2>contrasenya</h2>
                    <input type="password" name="contra">
                    <br></br>
                    <button type="sumbit" name="submit">Guardar dades</button>
                </div>
            </form>
        </div>
    </div>
    <!-- FOOTER -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="footer-col">
                    <h4>Empresa</h4>
                    <ul>
                        <li><a href="../HTML/sobre-nosaltres.hmtl">Sobre nosaltres</a></li>
                        <li><a href="#">Nostres serveis</a></li>
                        <li><a href="#">Politica privacitat</a></li>
                        <li><a href="#">affiliate program</a></li>
                    </ul>
                </div>
                <div class="footer-col">
                    <h4>Suport</h4>
                    <ul>
                        <li><a href="#">FAQ</a></li>
                        <li><a href="#">Enviaments</a></li>
                        <li><a href="#">Devolucions</a></li>
                        <li><a href="#">Estat ordre</a></li>
                        <li><a href="#">Opcions pagament</a></li>
                    </ul>
                </div>
                <div class="footer-col">
                    <h4>Botiga online</h4>
                    <ul>
                        <li><a href="#">Busca</a></li>
                        <li><a href="#">Carro</a></li>
                        <li><a href="#">Esquis</a></li>
                        <li><a href="#">Botes</a></li>
                    </ul>
                </div>
                <div class="footer-col">
                    <h4>Segeix-nos</h4>
                    <div class="social-links">
                        <a href="https://www.facebook.com"><i class='bx bxl-facebook' style='font-size: 17px;'></i></a>
                        <a href="https://twitter.com/home"><i class='bx bxl-twitter' style='font-size: 17px;'></i></a>
                        <a href="https://www.instagram.com"><i class='bx bxl-instagram-alt' style='font-size: 17px;'></i></a>
                        <a href="https://www.linkedin.com"><i class='bx bxl-linkedin' style='font-size: 17px;'></i></a>
                    </div>
                </div>
            </div>
        </div>
   </footer>
    <script src="../JS/app.js"></script>
    <script src="../JS/productes.js"></script>
    <script src="../JS/header.js"></script>
</body>
</html>