$(document).on("click", "#btnagregarpersona", function() {
	$("#txtnombre").val("");
	$("#txtapellido").val("");
	$("#txtdireccion").val("");
	$("#txttelefono").val("");
	$("#txtemail").val("");
	$("#txtdni").val("");
	$("#txtedad").val("");
	$("#txtgenero").val("");
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
	if($("#txtnombre").val() === ""){
		$("#errornombre").text("Es obligatorio el nombre de la persona");
	}else{
		$("#errornombre").text("");
	}
	
	if($("#txtapellido").val() === ""){
		$("#errorapellido").text("Es obligatorio el apellido de la persona");
	}else{
		$("#errorapellido").text("");
	}
	
	if($("#txtdireccion").val() === ""){
		$("#errordireccion").text("Es obligatorio la direccion de la persona");
	}else{
		$("#errordireccion").text("");
	}
	
	if($("#txttelefono").val() === ""){
		$("#errortelefono").text("Es obligatorio el telefono de la persona");
	}else{
		$("#errortelefono").text("");
	}
	
	if($("#txtemail").val() === ""){
		$("#erroremail").text("Es obligatorio el email de la persona");
	}else{
		$("#erroremail").text("");
	}
	
	if($("#txtdni").val() === ""){
		$("#errordni").text("Es obligatorio el dni de la persona");
	}else{
		$("#errordni").text("");
	}
	
	if($("#txtedad").val() === ""){
		$("#erroredad").text("Es obligatorio la edad de la persona");
	}else{
		$("#erroredad").text("");
	}
	
	if($("#txtgenero").val() === ""){
		$("#errorgenero").text("Es obligatorio el genero de la persona");
	}else{
		$("#errorgenero").text("");
	}
	
	 if($("#txtnombre").val() !== "" && $("#txtapellido").val !== "" &&
	 $("#txtdireccion").val() !== "" && $("#txttelefono").val() !== "" &&
	 $("#txtemail").val() !== "" && $("#txtdni").val() !== "" &&
	 $("#txtedad").val() !== "" ){
		
		if ($("#hddidpersona").val() === "0") {
				$.ajax({
					type: "POST",
					contentType: "application/json",
					url: "/Persona/registrarPersona",
					data: JSON.stringify({
						nombre: $("#txtnombre").val(),
						apellido: $("#txtapellido").val(),
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
				nombre: $("#txtnombre").val(),
				apellido: $("#txtapellido").val(),
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
				"<td>"+ value.nombre + "</td>"+
				"<td>"+ value.apellido + "</td>"+
				"<td>"+ value.direccion + "</td>"+
				"<td>"+ value.telefono + "</td>"+
				"<td>"+ value.email + "</td>"+
				"<td>"+ value.dni + "</td>"+
				"<td>"+ value.edad + "</td>"+
				"<td>"+ value.genero + "</td>"+
				"<td>"+ value.estado + "</td>"+
				
				"<td><button type='button' class='btn btn-info btnactualizarpersona'"+
				" data-idpersona='"+value.idpersona+"'"+
				" data-nombre='"+value.nombre+"'"+
				" data-apellido='"+value.apellido+"'"+
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
				" data-nombre='"+value.nombre+"'"+
				" data-apellido='"+value.apellido+"'"+
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


