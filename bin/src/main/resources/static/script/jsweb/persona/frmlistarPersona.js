
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


$(document).on("click", "#btnagregarpersona", function() {
	$("#txtnombre").val("");
	$("#txtapellido").val("");
	$("#txtdireccion").val("");
	$("#txttelefono").val("");
	$("#txtemail").val("");
	$("#txtdni").val("");
	$("#txtedad").val("");
	$("#txtgenero").val("0");
	//("#txtestado").val("");
	$("#hddidpersona").val("0");

	$("#modalpersona").modal("show");
});

$(document).on("click", ".btnactualizarpersona", function() {
	$("#txtnombre").val($(this).attr("data-nombre"));
	$("#txtapellido").val($(this).attr("data-apellido"));
	$("#txtdireccion").val($(this).attr("data-direccion"));
	$("#txttelefono").val($(this).attr("data-telefono"));
	$("#txtemail").val($(this).attr("data-email"));
	$("#txtdni").val($(this).attr("data-dni"));
	$("#txtedad").val($(this).attr("data-edad"));
	$("#txtgenero").val($(this).attr("data-genero"));
	$("#txtestado").val($(this).attr("data-estado"));
	$("#hddidpersona").val($(this).attr("data-idpersona"));
	$("#modalpersona").modal("show");
});

$(document).on("click", "#btnregistrarpersona", function() {
	telefono = 1;
	dni = 1;
	if($("#txtnombre").val() === ""){
		$("#errornombre").text("Es obligatorio el nombre de la persona");
	}else{$("#errornombre").text("");}
	
	if($("#txtapellido").val() === ""){
		$("#errorapellido").text("Es obligatorio el apellido de la persona");
	}else{$("#errorapellido").text("");}
	
	if($("#txtdireccion").val() === ""){
		$("#errordireccion").text("Es obligatorio la direccion de la persona");
	}else{$("#errordireccion").text("");}
	
	if($("#txttelefono").val() === ""){
		$("#errortelefono").text("Es obligatorio el telefono de la persona");
	}else if($("#txttelefono").val().length < 9){
		$("#errortelefono").text("El numero de telefono ingresado no es válido");
		telefono = 2; 
	}else{$("#errortelefono").text("");}
	
	if($("#txtemail").val() === ""){
		$("#erroremail").text("Es obligatorio el email de la persona");
	}else{$("#erroremail").text("");}
	
	if($("#txtdni").val() === ""){
		$("#errordni").text("Es obligatorio el dni de la persona");
	}else if($("#txtdni").val().length < 8){
		$("#errordni").text("El DNI ingresado no es válido");
		dni = 2; 
	}else{$("#errordni").text("");}
	
	if($("#txtedad").val() === ""){
		$("#erroredad").text("Es obligatorio la edad de la persona");
	}else if($("#txtedad").val() >= 0 && $("#txtedad").val() <= 3 ){
		$("#erroredad").text("La edad ingresada no es valida");
	}else{$("#erroredad").text("");}
	
	if($("#txtgenero").val() === "0"){
		$("#errorgenero").text("Es seleccionar el genero de la persona");
	}else{$("#errorgenero").text("");}
	
	
	 if($("#txtnombre").val() !== "" && $("#txtapellido").val() !== "" &&
	 $("#txtdireccion").val() !== "" && $("#txttelefono").val() !== "" &&
	 $("#txtemail").val() !== "" && $("#txtdni").val() !== "" &&
	 $("#txtedad").val() !== "" &&  $("#txtedad").val() >= 3 &&
	 dni == 1 && telefono == 1 && $("#txtgenero").val() !== "0"){
		if ($("#hddidpersona").val() === "0") {
				$.ajax({
					type: "POST",
					contentType: "application/json",
					url: "/Persona/registrarPersona",
					data: JSON.stringify({
						nombres: $("#txtnombre").val(),
						apellidos: $("#txtapellido").val(),
						direccion: $("#txtdireccion").val(),
				        telefono: $("#txttelefono").val(),
				        email: $("#txtemail").val(),
				        dni: $("#txtdni").val(),
				        edad: $("#txtedad").val(),
				        genero: $("#txtgenero").val(),
				        //estado:$("#txtestado").val()

			}),
			success: function(resultado){
				var estilo = "danger";
				if(resultado.respuesta){
					estilo ="success";
					ListarPersona();
					
					//actualizar lista 
				}
				mostrarMensaje(resultado.mensaje, estilo);
			}
		});
	} else {
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/Persona/registrarPersona",
			data: JSON.stringify({
				idpersona:$("#hddidpersona").val(),
				nombres: $("#txtnombre").val(),
				apellidos: $("#txtapellido").val(),
				direccion: $("#txtdireccion").val(),
				telefono: $("#txttelefono").val(),
				email: $("#txtemail").val(),
				dni: $("#txtdni").val(),
				edad: $("#txtedad").val(),
				genero: $("#txtgenero").val(),
				//estado:$("#txtestado").val()

			}),
			success: function(resultado){
				var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarPersona();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			}
		});

	}
	
	$("#modalpersona").modal("hide");
	}
});
		
		

$(document).on("click", ".btneliminarpersona", function() {
	//alert($(this).attr("data-idpersona"));
	$("#mensajeeliminar").text("¿Esta seguro de eliminar a:" +
		$(this).attr("data-nombre") + "?");
	$("#hddidpersonaeliminar").val($(this).attr("data-idpersona"));
	$("#modaleliminarpersona").modal("show");
});

$(document).on("click", "#btneliminarpersona", function() {
		$.ajax({
			type: "DELETE",
			contentType: "application/json",
			url: "/Persona/eliminarPersona",
			data: JSON.stringify({
				idpersona: $("#hddidpersonaeliminar").val(),
				

			}),
			success: function(resultado){
				var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarPersona();
			}
			mostrarMensaje(resultado.mensaje, estilo);
				$("#modaleliminarpersona").modal("hide");
			}
		});
	

});

$(document).on("input", "#txttelefono", "#txtdni", "#txtedad",function(){
	this.value = this.value.replace(/[^0-9]/g, '');
});
function mostrarMensaje(mensaje, estilo) {
	$("#mensaje").html("");
	$("#mensaje").append("<div class='alert alert-" + estilo
		+" alert-dismissible fade show' role='alert'>"
		+"<strong>" + mensaje + "</strong>"
		+"<button type='button' class='close' data-dismiss='alert'"
		+" aria-label='Close'>"
		+"<span aria-hidden='true'>&times;</span></button></div>"
	);
}


function mostrarMensaje(mensaje, estilo) {
	$("#mensaje").html("");
	$("#mensaje").append("<div class='alert alert-"+ estilo
		+ " alert-dismissible fade show' role='alert'>"
		+ "<strong>"+ mensaje+ "</strong>"
		+ "<button type='button' class='close' data-dismiss='alert'"
		+ " aria-label='Close'>"
		+ "<span aria-hidden='true'>&times;</span></button></div>"
	);
}

function ListarPersona(){
	$.ajax({
		type: "GET",
		url: "/Persona/listarPersona",
		dataType: "json",
		success:function(resultado){
			$("#tblpersona > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblpersona > tbody").append("<tr>"+
				"<td>"+ value.idpersona + "</td>"+
				"<td>"+ value.nombres + "</td>"+
				"<td>"+ value.apellidos + "</td>"+
				"<td>"+ value.direccion + "</td>"+
				"<td>"+ value.telefono + "</td>"+
				"<td>"+ value.email + "</td>"+
				"<td>"+ value.dni + "</td>"+
				"<td>"+ value.edad + "</td>"+
				"<td>"+ value.genero + "</td>"+
				"<td>"+ value.estado + "</td>"+
				
				"<td><button type='button' class='btn btn-info btnactualizarpersona'"+
				" data-idpersona='"+value.idpersona+"'"+
				" data-nombre='"+value.nombres+"'"+
				" data-apellido='"+value.apellidos+"'"+
				" data-direccion='"+value.direccion+"'"+
				" data-telefono='"+value.telefono+"'"+
				" data-email='"+value.email+"'"+
				" data-dni='"+value.dni+"'"+
				" data-edad='"+value.edad+"'"+
				" data-genero='"+value.genero+"'"+
				" data-estado='"+value.estado+"'>Actualizar</button>"+
				"</td>"+
				
				"<td><button type='button' class='btn btn-danger btneliminarpersona'"+
				" data-idpersona='"+value.idpersona+"'"+
				" data-nombre='"+value.nombres+"'"+
				" data-apellido='"+value.apellidos+"'"+
				" data-direccion='"+value.direccion+"'"+
				" data-telefono='"+value.telefono+"'"+
				" data-email='"+value.email+"'"+
				" data-dni='"+value.dni+"'"+
				" data-edad='"+value.edad+"'"+
				" data-genero='"+value.genero+"'>Eliminar</button>"+
				"</td></tr>")
			})
				
			
		}
	})
}


