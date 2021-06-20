$(document).on("click", "#btnagregarmatricula", function() {
	$("#cbopersonas").val("0");
	$("#cboapoderados").val("0");
	$("#cbonivel").val("0");
	$("#cbogrado").val("0");
	$("#cboseccion").val("0");
	$("#txtnomusuario").val("");
	$("#txtcontrasena").val("");
	$("#txtmonto").val("");
	$("#txtnomfecha").val("");

	$("#hddidmatricula").val("0");
	$("#modalmatricula").modal("show");
});
$(document).on("click", ".btnactualizarmatricula", function() {
	$("#cbopersonas").val($(this).attr("data-codpersona"));
	$("#cboapoderados").val($(this).attr("data-codapoderado"));
	
	$("#cbonivel").val($(this).attr("data-codnivel"));
	$("#cbogrado").val($(this).attr("data-codgrado"));
	$("#cboseccion").val($(this).attr("data-codseccion"));
	
	$("#txtnomusuario").val($(this).attr("data-nombreusuario"));
	$("#txtcontrasena").val($(this).attr("data-contrasena"));
	$("#txtmonto").val($(this).attr("data-monto"));
	$("#txtnomfecha").val($(this).attr("data-fecha"));

	$("#hddidmatricula").val($(this).attr("data-codmatricula"));
	$("#modalmatricula").modal("show");
});
$(document).on("click", "#btnregistrarmatricula", function() {
	var idpersona = $("#cbopersonas").val();
	if (idpersona === "0") {
		$("#errorpersona").text("Es obligatorio seleccionar una Persona.");
	}
	var idnivel = $("#cbonivel").val();
	if (idnivel === "0") {
		$("#errornivel").text("Es obligatorio seleccionar una Nivel.");
	}
	var idgrado = $("#cbogrado").val();
	if (idgrado === "0") {
		$("#errorgrado").text("Es obligatorio seleccionar una Grado.");
	}
	var idseccion = $("#cboseccion").val();
	if (idseccion === "0") {
		$("#errorseccion").text("Es obligatorio seleccionar una Seccion.");
	}
	if ($("#txtnomusuario").val() === "") {
		$("#errornomusuario").text("Es obligatorio un usuario.");
	} else {
		$("#errornomusuario").text("");
	}
	if ($("#txtcontrasena").val() === "") {
		$("#errornomcontrasena").text("Es obligatorio una contraseña.");
	} else {
		$("#errornomcontrasena").text("");
	}
	if ($("#txtmonto").val() === "") {
		$("#errormonto").text("Es obligatorio una contraseña.");
	} else {
		$("#errormonto").text("");
	}
	if ($("#txtnomfecha").val() === "") {
		$("#errornomfecha").text("Es obligatorio la fecha.");
	} else {
		$("#errornomfecha").text("");
	}
	if ($("#txtnomfecha").val() !== "" && $("#txtmonto").val() !== "" && $("#txtcontrasena").val() !== "" && $("#txtnomusuario").val() !== "" 
			&& $("#cboseccion").val() !== "0" && $("#cbogrado").val() !== "0" && $("#cbonivel").val() !== "0") {
		if ($("#hddidmatricula").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Matriculas/registrarMatricula",
				data: JSON.stringify({
					idpersona: $("#cbopersonas").val(),
					idapoderado: $("#cboapoderados").val(),
					idnivel: $("#cbonivel").val(),
					idgrado: $("#cbogrado").val(),
					idseccion: $("#cboseccion").val(),
					nombreusuario: $("#txtnomusuario").val(),
					contrasena: $("#txtcontrasena").val(),
					monto: $("#txtmonto").val(),
					fecha: $("#txtnomfecha").val()
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
					ListarMatriculas();
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
				$("#modalmatricula").modal("hide");
			}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Matriculas/registrarMatricula",
				data: JSON.stringify({
					idmatricula: $("#hddidmatricula").val(),
					idpersona: $("#cbopersonas").val(),
					idapoderado: $("#cboapoderados").val(),
					idnivel: $("#cbonivel").val(),
					idgrado: $("#cbogrado").val(),
					idseccion: $("#cboseccion").val(),
					nombreusuario: $("#txtnomusuario").val(),
					contrasena: $("#txtcontrasena").val(),
					monto: $("#txtmonto").val(),
					fecha: $("#txtnomfecha").val()
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
					ListarMatriculas();
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
				$("#modalmatricula").modal("hide");
			}
			});
		}
		$("#modalmatricula").modal("hide");
	} //cierre del if
});
$(document).on("click", ".btneliminarmatricula", function() {
	//alert($(this).attr("data-codcurso"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la matricula de la persona: " +
		$(this).attr("data-codpersona") + "?");
	$("#hddidmatriculaeliminar").val($(this).attr("data-codmatricula"));
	$("#modaleliminarmatricula").modal("show");
});
$(document).on("click", "#btneliminarmatricula", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Matriculas/eliminarMatricula",
		data: JSON.stringify({
			idmatricula: $("#hddidmatriculaeliminar").val()
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
					ListarMatriculas();
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
				$("#modaleliminarmatricula").modal("hide");
			}
	});
});
function ListarMatriculas() {
	$.ajax({
		type: "GET",
		url: "/Matriculas/listarMatriculas",
		dataType: "json",
		success: function(resultado) {
			$("#tblmatricula > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblmatricula > tbody").append("<tr>" +
					"<td>" + value.idmatricula + "</td>" +
					"<td>" + value.idpersona + "</td>" +
					"<td>" + value.idapoderado + "</td>" +
					//"<td>" + value.idnivel + "</td>" +
					//"<td>" + value.idgrado + "</td>" +
					//"<td>" + value.idseccion + "</td>" +
					"<td>" + value.nombreusuario + "</td>" +
					"<td>" + value.contrasena + "</td>" +
					"<td>" + value.monto + "</td>" +
					"<td>" + value.fecha + "</td>" +
					"<td>" + value.estado + "</td>" +
					"<td><button type='button' class='btn btn-info btndetallematricula' " +
					" data-codmatricula='" + value.idmatricula + "'>Ver Detalle</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-info btnactualizarmatricula' " +
					" data-codmatricula='" + value.idmatricula + "'" +
					" data-codpersona='" + value.idpersona + "'" +
					" data-codapoderado='" + value.idapoderado + "'" +
					" data-codnivel='" + value.idnivel + "'" +
					" data-codgrado='" + value.idgrado + "'" +
					" data-codseccion='" + value.idseccion + "'" +
					" data-nombreusuario='" + value.nombreusuario + "'" +
					" data-contrasena='" + value.contrasena + "'" +
					" data-monto='" + value.monto + "'" +
					" data-fecha='" + value.fecha + "'" +
					" data-estado='" + value.estado + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarmatricula' " +
					" data-codmatricula='" + value.idmatricula + "'" +
					" data-codpersona='" + value.idpersona + "'>Eliminar</button>" +
					"</td></tr>")
			})
		}
	})
}
function mostrarMensaje(mensaje, estilo) {
	$("#mensaje").html("");
	$("#mensaje").append("<div class='alert alert-" + estilo
		+ " alert-dismissible fade show' role='alert'>"
		+ "<strong>" + mensaje + "</strong>"
		+ "<button type='button' class='close' data-dismiss='alert'"
		+ " aria-label='Close'>"
		+ "<span aria-hidden='true'>&times;</span></button></div>"
	);
}




$(document).on("click", ".btndetallematricula", function() {
	
	$.ajax({
		type: "GET",
		url: "/Matriculas/listarDetalleMatricula",
		dataType: 'json',
		data: {
			idmatricula: $(this).attr("data-codmatricula"),
		},
		success: function(resultado) {
			$("#tbldetalle > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tbldetalle > tbody").append("<tr>" +
					"<td>" + value.persona  + "</td>" +
					"<td class='text-center'>" + value.apoderado + "</td>" +
					"<td class='text-center'>" + value.nivel + "</td>" +
					"<td class='text-center'>" + value.grado + "</td>" +
					"<td class='text-center'>" + value.seccion + "</td>" +
					"<td class='text-center'>" + value.usuario + "</td>" +
				"</tr>")
			});
			$("#modaldetallematricula").modal("show");
		}
	});
});
