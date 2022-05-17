<?php
include '../PHP/function.php';
session_start();
con();
inicidesessio();
registre();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="../img/logo3.png" type="image/x-icon">
    <link rel="stylesheet" href="../css/login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap" rel="stylesheet">
    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> -->
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <title>Log In</title>
    
        <meta charset="UTF-8">
        <!--<title> Login and Registration Form in HTML & CSS | CodingLab </title>-->
        <link rel="stylesheet" href="style.css">
        <!-- Fontawesome CDN Link -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
       </head>
    <body>
      <div class="container">
        <input type="checkbox" id="flip">
        <div class="cover">
          <div class="front">
            <!--<img src="images/frontImg.jpg" alt="">-->
            <div class="text">
              <span class="text-1"><br></span>
              <span class="text-2"></span>
            </div>
          </div>
          <div class="back">
            <!--<img class="backImg" src="images/backImg.jpg" alt="">-->
            <div class="text">
              <span class="text-1"><br></span>
              <span class="text-2"></span>
            </div>
          </div>
        </div>
        <div class="forms">
            <div class="form-content">
              <div class="login-form">
                <div class="title">Inici de sessió</div>
              <form action="" method="POST">
                <div class="input-boxes">
                  <div class="input-box">
                    <i class='bx bxs-envelope'></i>
                    <input type="text" placeholder="Introdueix el teu correu" name="email">
                  </div>
                  <div class="input-box">
                    <i class='bx bxs-lock'></i>
                    <input type="password" placeholder="Introdueix la teva contrasenya" name="contra">
                  </div>
                  <div class="text"><a href="../HTML/index.html">Torna a la pàgina principal</a></div>
                  <!-- <div class="text"><a href="../HTML/productes.html">Entra bobo</a></div> -->
                  <div class="button input-box">
                    <input type="submit" value="Següent" name="submit">
                  </div>
                  <div class="text sign-up-text">No tens compte? <label for="flip">Registrat ara</label></div>
                </div>
            </form>
          </div>
            <div class="signup-form">
              <div class="title">Registre</div>
            <form action="" method="POST">
                <div class="input-boxes">
                  <!-- DNI -->
                  <div class="input-box">
                    <i class='bx bxs-id-card' ></i>
                    <input type="text" placeholder="Introdueix el teu dni" name="dni">
                  </div>
                  <!-- Nom -->
                  <div class="input-box">
                    <i class='bx bxs-rename'></i>
                    <input type="text" placeholder="Introdueix el teu nom" name="nom">
                  </div>
                  <!-- cognom1 -->
                  <div class="input-box">
                    <i class='bx bxs-rename'></i>
                    <input type="text" placeholder="Introdueix el teu primer cognom" name="cognom1">
                  </div>
                  <!-- cognom2 -->
                  <div class="input-box">
                    <i class='bx bxs-rename'></i>
                    <input type="text" placeholder="Introdueix el teu segon cognom" name="cognom2">
                  </div>
                  <!-- tel -->
                  <div class="input-box">
                    <i class='bx bxs-phone'></i>
                    <input type="text" placeholder="Introdueix el telèfon" name="tel">
                  </div>
                  <!-- data -->
                  <div class="input-box">
                    <i class='bx bxs-calendar-event'></i>
                    <input type="text" placeholder="Introdueix la data naixement" name="data">
                  </div>
                  <!-- email -->
                  <div class="input-box">
                    <i class='bx bxs-envelope' ></i>
                    <input type="text" placeholder="Introdueix el teu correu" name="email">
                  </div>
                  <!-- sexe -->
                  <div class="input-box">
                    <i class='bx bxl-github'></i>
                    <input type="text" placeholder="Introdueix el teu sexe" name="sexe">
                  </div>
                  <!-- CBB -->
                  <div class="input-box">
                    <i class='bx bxs-bank' ></i>
                    <input type="text" placeholder="Introdueix el teu compte bancari" name="cbb">
                  </div>
                  <!-- user -->
                  <div class="input-box">
                    <i class='bx bxs-user'></i>
                    <input type="text" placeholder="Introdueix el teu usuari" name="usuari">
                  </div>
                  <!-- pass -->
                  <div class="input-box">
                    <i class='bx bxs-lock'></i>
                    <input type="password" placeholder="Introdueix la teva contrasenya" name="contra">
                  </div>
                  <div class="button input-box">
                    <input type="submit" value="Següent" name="submit">
                  </div>
                  <div class="text sign-up-text">Ja tens un compte? <label for="flip">Inicia sessio ara</label></div>
                </div>
          </form>
        </div>
        </div>
        </div>
      </div>
      <script src="../JS/login.js"></script>
</body>
</html>