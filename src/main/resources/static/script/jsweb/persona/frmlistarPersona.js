
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
	$("#txttipo").val("");
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
	$("#txttipo").val($(this).attr("data-tipo"));
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
	if($("#txttipo").val() === "" || $("#txttipo").val() > 3 || $("#txttipo").val() < 1){
		$("#errortipo").text("Ingrese la categoria de la persona: 1, 2 o 3");
	}else{$("#errortipo").text("");}
	
	if($("#txtnombre").val() === ""){
		$("#errornombre").text("Es obligatorio ingresar un nombre");
	}else{$("#errornombre").text("");}
	
	if($("#txtapellido").val() === ""){
		$("#errorapellido").text("Es obligatorio ingresar un apellido");
	}else{$("#errorapellido").text("");}
	
	if($("#txtdireccion").val() === ""){
		$("#errordireccion").text("Es obligatorio ingresar una direccion");
	}else{$("#errordireccion").text("");}
	
	if($("#txttelefono").val() === ""){
		$("#errortelefono").text("Es obligatorio ingresar un telefono");
	}else if($("#txttelefono").val().length < 9){
		$("#errortelefono").text("El numero de telefono ingresado no es v??lido");
		telefono = 2; 
	}else{$("#errortelefono").text("");}
	
	if($("#txtemail").val() === ""){
		$("#erroremail").text("Es obligatorio el email de la persona");
	}else{$("#erroremail").text("");}
	
	if($("#txtdni").val() === ""){
		$("#errordni").text("Es obligatorio el dni de la persona");
	}else if($("#txtdni").val().length < 8){
		$("#errordni").text("El DNI ingresado no es v??lido");
		dni = 2; 
	}else{$("#errordni").text("");}
	
	if($("#txtedad").val() === ""){
		$("#erroredad").text("Es obligatorio ingresar la edad");
	}else if($("#txtedad").val() >= 0 && $("#txtedad").val() <= 3 ){
		$("#erroredad").text("La edad ingresada no es valida");
	}else{$("#erroredad").text("");}
	
	if($("#txtgenero").val() === "0"){
		$("#errorgenero").text("Es seleccionar el genero de la persona");
	}else{$("#errorgenero").text("");}
	
	
	 if($("#txttipo").val() !== "" && $("#txttipo").val() < 4 && $("#txttipo").val() > 0 && $("#txtnombre").val() !== "" && $("#txtapellido").val() !== "" &&
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
						tipopersona: $("#txttipo").val(),
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
				if(resultado.respuesta){
					
					/*Swal.fire({
					//title: resultado.mensaje,
					confirmButtonText: 'Acepto',
					icon: 'info'
					});*/
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'success',
						  title: resultado.mensaje
						})
					ListarPersona();
				}else{
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'error',
						  title: resultado.mensaje
						})
				}
				$("#modalpersona").modal("hide");
			}
		});
	} else {
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/Persona/actualizarPersona",
			data: JSON.stringify({
				idpersona:$("#hddidpersona").val(),
				tipopersona: $("#txttipo").val(),
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
				if(resultado.respuesta){
					
					/*Swal.fire({
					//title: resultado.mensaje,
					confirmButtonText: 'Acepto',
					icon: 'info'
					});*/
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'success',
						  title: resultado.mensaje
						})
					ListarPersona();
				}else{
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'error',
						  title: resultado.mensaje
						})
				}
				$("#modalpersona").modal("hide");
			}
		});

	}
	
	$("#modalpersona").modal("hide");
	}
});
		
		

$(document).on("click", ".btneliminarpersona", function() {
	//alert($(this).attr("data-idpersona"));
	$("#mensajeeliminar").text("??Esta seguro de eliminar a:" +
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
				if(resultado.respuesta){
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})

						Toast.fire({
						  icon: 'success',
						  title: resultado.mensaje
						})
					ListarPersona();
				}else{
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    //toast.addEventListener('mouseenter', Swal.stopTimer)
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'error',
						  title: resultado.mensaje
						})
				}
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
				"<td>"+ value.tipopersona + "</td>"+
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
				" data-tipo='"+value.tipopersona+"'"+
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
				" data-tipo='"+value.tipopersona+"'"+
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


