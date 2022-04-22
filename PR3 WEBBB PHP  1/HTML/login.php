<?php
include '../PHP/function.php';
con();
inicdesessio();
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Log In</title>
    <head>
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
                <div class="title">Inici de sesio</div>
              <form action="" method="POST">
                <div class="input-boxes">
                  <div class="input-box">
                    <i class="fas fa-envelope"></i>
                    <input type="text" placeholder="Introdueix el teu correu" name="Correu_e">
                  </div>
                  <div class="input-box">
                    <i class="fas fa-lock"></i>
                    <input type="password" placeholder="Introdueix la teva contrasenya" name="Contrasenya">
                  </div>
                  <div class="text"><a href="../HTML/index.html">Torna a la paguina principal</a></div>
                  <div class="text"><a href="../HTML/productes.html">Entra bobo</a></div>
                  <div class="button input-box">
                    <input type="submit" value="Seguent" name="submit">
                  </div>
                  <div class="text sign-up-text">No tens compte? <label for="flip">Registrat ara</label></div>
                </div>
            </form>
          </div>
            <div class="signup-form">
              <div class="title">Registre</div>
            <form action="#">
                <div class="input-boxes">
                  <div class="input-box">
                    <i class="fas fa-user"></i>
                    <input type="text" placeholder="Introdueix el teu nom" required>
                  </div>
                  <div class="input-box">
                    <i class="fas fa-envelope"></i>
                    <input type="text" placeholder="Introdueix el teu correu" required>
                  </div>
                  <div class="input-box">
                    <i class="fas fa-lock"></i>
                    <input type="password" placeholder="Introdueix la teva contrasenya" required>
                  </div>
                  <div class="button input-box">
                    <input type="submit" value="Seguent">
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