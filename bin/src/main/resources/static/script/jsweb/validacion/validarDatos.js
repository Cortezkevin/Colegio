
//VALIDAR SOLO INGRESO DE NUMEROS
function validarNumeros(e) { // 1
tecla = (document.all) ? e.keyCode : e.which; // 2
if (tecla==8) return true; // 3				-->  onkeypress="return validarNumeros(event)"
patron =/[0-9]/; // 4
te = String.fromCharCode(tecla); // 5
return patron.test(te); // 6
}

//VALIDAR SOLO INGRESO DE LETRAS
function validarLetras(e) { // 1
tecla = (document.all) ? e.keyCode : e.which; // 2
if (tecla==8) return true; // 3				-->  onkeypress="return validarLetras(event)"
patron =/[A-Za-z\s]/; // 4
te = String.fromCharCode(tecla); // 5
return patron.test(te); // 6
}
