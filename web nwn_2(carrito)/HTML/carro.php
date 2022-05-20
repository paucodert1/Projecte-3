
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carro</title>
    <link rel="shortcut icon" href="../img/logo3.png" type="image/x-icon">
    <link rel="stylesheet" href="../css/estils.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <!-- HEADER -->
<header>
    <div id="menu-bar"><i class='bx bx-menu' ></i></div>
    <img class="logo" src="../img/logo_llarg2.png">
    </a>

    <nav class="navbar">
        <a href="../HTML/index.html">Inici</a>
        <a href="../HTML/productes.php">Botiga</a>
        <a href="../HTML/sobre-nosaltres.html">Nosaltres</a>
        <a href="#">Historial</a>
    </nav>

    <div class="icons">
        <a href="../HTML/carro.html"><i class='bx bx-shopping-bag'></i></a>
        <a href="../HTML/temps.php"><i class='bx bx-cloud-snow'></i></a>
        <a href="../HTML/perfil.php"><i class='bx bxs-user'></i></a>
        <a href="../PHP/tanca-sessio.php"><i class='bx bx-log-out'></i></a>
        
    </div>
</header>
    <!-- MAIN -->
    <div class="main">
        <div class="section">
            <!-- detalls de el contingut de el carro -->
            <div class="paguina-carro">
                <table>
                    <thead>
                        <tr>
                            <th>Producte</th>
                            <th>Quantitat</th>
                            <th>Preu</th>
                        </tr>
                    </thead>
                    <tbody id="productes_carrito">
                    </tbody>
                </table>
                <div id="preu-total">
                </div>
                <input type="button" value="Buidar carrito" id="borra">
            </div>
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
    <script src="../JS/header.js"></script>
    <script src="../JS/checkout.js"></script>
</body>
</html>