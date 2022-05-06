<?php
// session_start();

    function con() {
    $connexio = new mysqli ("localhost", "root", "Fat/3232", "nwn");
    // echo "connecta be";
    return $connexio;
    }

    function inicidesessio() {
        // echo "klk";
        if (isset($_POST['submit'])) {
            $sql = "SELECT * FROM clients WHERE correu_e = '" . $_POST['email'] ."' AND contrasenya = md5('" . $_POST['contra'] . "')";
            $result = con()->query($sql);

            // Els de la dreta son els de la bdd i els de la esquerra inven
            if ($result->num_rows > 0) {
                while ($row = $result->fetch_assoc()) {
                    $_SESSION['dni'] = $row['dni'];
                    $_SESSION['nom'] = $row['nom'];
                    $_SESSION['cognom1'] = $row['cognom_1'];
                    $_SESSION['cognom2'] = $row['cognom_2'];
                    $_SESSION['tel'] = $row['tel'];
                    $_SESSION['data'] = $row['data_naixement'];
                    $_SESSION['email'] = $row['correu_e'];
                    $_SESSION['sexe'] = $row['sexe'];
                    $_SESSION['cbb'] = $row['compte_Bancari'];
                    $_SESSION['usuari'] = $row['usuari'];
                    $_SESSION['contra'] = $row['contrasenya'];
                    header("Location: ../HTML/productes.php");
                }
            }
            else {
                $_SESSION['error'] = "dni o contrasenya incorrectes";
            }
        }
    }

    function registre(){

        if(!empty($_POST['dni']) && !empty($_POST['nom'])){

            $dni = $_POST['dni'];
            $nom = $_POST['nom'];
            $cognom1 = $_POST['cognom1'];
            $cognom2 = $_POST['cognom2'];
            $tel = $_POST['tel'];
            $datadate = $_POST['data'];
            // Crear per donar data
            $stringdata = strtotime($datadate);
            // Creem un nou format de data 
            $data = date("Y-m-d", $stringdata);

            $email = $_POST['email'];
            $sexe = $_POST['sexe'];
            $cbb = $_POST['cbb'];
            $usuari = $_POST['usuari'];
            $contra = $_POST['contra'];

            $insertar ="insert into clients value ('$dni', '$nom', '$cognom1','$cognom2','$tel','$data', '$email','$sexe', '$cbb', '$usuari', md5('$contra'))";

            $result = con()->query($insertar);

            return $result;

            header("Location: ../HTML/login.php");
        }
    }

    function obtenirProductes(){

            $sql = "SELECT * FROM productes";
            $result = con()->query($sql);
            return $result;

    }

    
?>
