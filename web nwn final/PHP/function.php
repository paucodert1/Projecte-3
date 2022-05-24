<?php
// session_start();

    function con() {
    $connexio = new mysqli ("localhost", "root", "1234", "nwn");
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

    function modificarDadesPerfil(){
       
    if(!empty ($_POST)){
        if (!empty($_POST['contra'])){
            $sql = "UPDATE clients set tel= '" . $_POST['tel'] . "' ,
            sexe= '" . $_POST['sexe'] . "' ,
            correu_e= '" . $_POST['email'] . "',
            usuari= '" . $_POST['usuari'] . "',
            contrasenya= '" . md5($_POST['contra']) . "'
            WHERE dni = '" . $_SESSION['dni']. "'";
            $result = con()->query($sql);
            $_SESSION['error2'] = "Cambiat de forma satisfactoria";

        } elseif(empty($_POST['contra'])){
            $sql = "UPDATE clients set tel= '" . $_POST['tel'] . "' ,
            sexe= '" . $_POST['sexe'] . "' ,
            correu_e= '" . $_POST['email'] . "' ,
            usuari= '" . $_POST['usuari'] . "'
            WHERE dni = '" . $_SESSION['dni']. "'";
            $result = con()->query($sql);
            $_SESSION['error2'] = "Cambiat de forma satisfactoria";
            
        } else{
            $_SESSION['error2'] = "No funciona el update";
        }
    }
}

function obtenirCursosIndividuals(){
    
    $sql = "SELECT C.id,C.nom,CI.dni,CI.hores,CI.data,CI.preu_final
            FROM cursos C, curse_i CI, clients CL
            WHERE C.id=CI.id and CI.dni=CL.dni and CL.dni = '" . $_SESSION['dni'] . "'";
    $result = con()->query($sql);
    return $result;
}



function obtenirCursosColectius(){
    
    $sql = "SELECT C.id,C.nom,CC.dni,CC.cant_persones,CC.preu_final,CC.preu_final
            FROM cursos C, curse_col CC, clients CL
            WHERE C.id=CC.id and CC.dni=CL.dni and CL.dni = '" . $_SESSION['dni'] . "'";
    $result = con()->query($sql);
    return $result;
}

function obtenirCursosCompeticio(){
    
    $sql = "SELECT C.id,C.nom,COM.dni,COM.preu_final
            FROM cursos C, curse_com COM, clients CL,federats F
            WHERE C.id=COM.id and COM.dni=F.dni and F.dni=CL.dni and CL.dni = '" . $_SESSION['dni'] . "'";
    $result = con()->query($sql);
    return $result;
}


    
?>
