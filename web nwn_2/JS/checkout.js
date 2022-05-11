document.addEventListener("DOMContentLoaded", iniciar);

function iniciar(){

    let btnBorra = document.getElementById("borra");
    btnBorra.addEventListener("click", borraDades);

    carregarDades();

}

function esborraItem( id ){

    if(confirm("Estàs segur que vols esborar el Producte?")){
        localStorage.removeItem(id)

        carregarDades();
        esborrarCamps();
    }

}

function borraDades(){

    if(confirm("Estàs segur que vols esborrar?")){

        localStorage.clear();
        
        carregarDades();
        esborrarCamps();
    }
}
function carregarDades(){

    let clau;
    let info;
    let obj;

    document.getElementById("productes_carrito").innerHTML = "";

    for(i=0; i < localStorage.length; i++){

        clau = localStorage.key(i);
        info = localStorage.getItem(clau);

        obj = JSON.parse(info);
        document.getElementById("productes_carrito").innerHTML += `<tr>
                                                                        <td>
                                                                            <div class="info-carro">
                                                                                <img src="${obj.img}" alt="">
                                                                                <div>
                                                                                    <p>${obj.model}</p>
                                                                                    <small>${obj.marca}</small>
                                                                                    <p><input type="button"  id="elimina" value="Eliminar" onclick="esborraItem(${clau})"></p>
                                                                                </div>
                                                                            </div>
                                                                        </td>
                                                                        <td><input type="number" value="1"></td>
                                                                        <td><p>${obj.preu}</p></td>
                                                                    </tr>`;


    }

}