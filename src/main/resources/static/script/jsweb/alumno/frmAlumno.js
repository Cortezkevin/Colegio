$(document).on("click", "#btnagregaralumno", function() {
	$("#cbopersona").val("0");
	$("#cbousuario").val("0");

	$("#cboapoderado").val("0");

	$("#cbonivel").val("0");
	$("#cbogrado").val("0");

	$("#hddidalumno").val("0");
	$("#modalalumno").modal("show");
});

$(document).on("click", ".btnactualizaralumno", function() {
	$("#cbopersona").val($(this).attr("data-codpersona"));
	$("#cbousuario").val($(this).attr("data-codusuario"));

	$("#cboapoderado").val($(this).attr("data-codapoderado"));

	$("#cbonivel").val($(this).attr("data-codnivel"));
	$("#cbogrado").val($(this).attr("data-codgrado"));


	$("#hddidalumno").val($(this).attr("data-codalumno"));
	$("#modalalumno").modal("show");
});


$(document).on("click", "#btnregistraralumno", function() {

	var idpersona = $("#cbopersona").val();
	if (idpersona === "0") {
		$("#errorpersona").text("Es obligatorio seleccionar una persona.");
	}

	var idusuario = $("#cbousuario").val();
	if (idusuario === "0") {
		$("#errorusuario").text("Es obligatorio seleccionar un usuario.");
	}

	var idapoderado = $("#cboapoderado").val();
	if (idapoderado === "0") {
		$("#errorapoderado").text("Es obligatorio seleccionar un apoderado.");
	}

	var idnivel = $("#cbonivel").val();
	if (idnivel === "0") {
		$("#errornivel").text("Es obligatorio seleccionar un nivel.");
	}

	var idgrado = $("#cbogrado").val();
	if (idgrado === "0") {
		$("#errorgrado").text("Es obligatorio seleccionar un grado.");
	}
	if ($("#cbopersona").val() !== "0") {
		if ($("#hddidalumno").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Alumno/registrarAlumno",
				data: JSON.stringify({
					idpersona: $("#cbopersona").val(),
					idapoderado: $("#cboapoderado").val(),
					idusuario: $("#cbousuario").val(),
					idnivel: $("#cbonivel").val(),
					idgrado: $("#cbogrado").val()
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarAlumnos();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Alumno/registrarAlumno",
				data: JSON.stringify({
					idalumno: $("#hddidalumno").val(),
					idpersona: $("#cbopersona").val(),
					idapoderado: $("#cboapoderado").val(),					
					idusuario: $("#cbousuario").val(),
					idnivel: $("#cbonivel").val(),
					idgrado: $("#cbogrado").val()
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarAlumnos();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalalumno").modal("hide");
	}


});

$(document).on("click", ".btneliminaralumno", function() {
	//alert($(this).attr("data-codcurso"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar al alumno: " +
		$(this).attr("data-codpersona") + "?");
	$("#hddidalumnoeliminar").val($(this).attr("data-codalumno"));
	$("#modaleliminaralumno").modal("show");
});

$(document).on("click", "#btneliminaralumno", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Alumno/eliminarAlumno",
		data: JSON.stringify({
			idalumno: $("#hddidalumnoeliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarAlumnos();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminaralumno").modal("hide");
		}
	});
});
/*
$(document).on("input", "#txtcredcurso", function() {
	this.value = this.value.replace(/[^0-9]/g, '');
});*/

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

function ListarAlumnos() {
	$.ajax({
		type: "GET",
		url: "/Alumno/listarAlumnos",
		dataType: "json",
		success: function(resultado) {
			$("#tblalumno > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblalumno > tbody").append("<tr>" +
					"<td>" + value.idalumno + "</td>" +
					"<td>" + value.idpersona + "</td>" +					
					"<td>" + value.idapoderado + "</td>" +
					"<td>" + value.idusuario + "</td>" +
					"<td>" + value.idnivel + "</td>" +
					"<td>" + value.idgrado + "</td>" +
					"<td>" + value.estado + "</td>" +
					"<td><button type='button' class='btn btn-info btnactualizaralumno' " +
					" data-codalumno='" + value.idalumno + "'" +
					" data-codpersona='" + value.idpersona + "'" +					
					" data-codapoderado='" + value.idapoderado + "'" +
					" data-codusuario='" + value.idusuario + "'" +
					" data-codnivel='" + value.idnivel + "'" +
					" data-codgrado='" + value.idgrado + "'" +
					" data-estado='" + value.estado + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminaralumno' " +
					" data-codalumno='" + value.idalumno + "'" +
					" data-codpersona='" + value.idpersona + "'>Eliminar</button>" +
					"</td></tr>")
			})
		}
	})
}

$(document).on("click", ".btnverdetalle", function() {
	$.ajax({
		type: "GET",
		url: "/Alumno/listarDetalleAlumno",
		dataType: 'json',
		data: {
			idalumno: $(this).attr("data-codalumno"),
		},
		success: function(resultado) {
			$("#tbldetalle > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tbldetalle > tbody").append("<tr>" +
					"<td>" + value.apoderado  + "</td>" +
					"<td class='text-center'>" + value.nombres + "</td>" +
					"<td class='text-center'>" + value.apellidos + "</td>" +
					"<td class='text-center'>" + value.nombreusuario + "</td>" +
					"<td class='text-center'>" + value.nivel + "</td>" +
					"<td class='text-center'>" + value.grado + "</td>" +
				"</tr>")
			});
			$("#modaldetallealumno").modal("show");
		}
	});
});
