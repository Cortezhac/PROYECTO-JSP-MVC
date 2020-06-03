/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function defecto(){
    var campoId = document.getElementById("id");
    var campoNombre = document.getElementById("nombre");
    var campoTipo = document.getElementById("tipo");
    var campoCompania = document.getElementById("compania");

    evaluar(campoId);
    evaluar(campoNombre);
    evaluar(campoTipo);
    evaluar(campoCompania);
}

function evaluar(campo){
    if(campo.value === ""){
        campo.value = campo.placeholder;
        
    }if(campo.value === "null"){
        campo.className = "error";
    }else{
        campo.className.removeClass= "error";
    }
}

