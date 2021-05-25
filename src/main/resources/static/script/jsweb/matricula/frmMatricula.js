$(document).on("click", "#btnagregarmatricula", function() {
	$("#cboalumnos").val("0");
	$("#cbonivel").val("0");
	$("#cbogrado").val("0");
	$("#cboseccion").val("0");
	$("#txtnomfecha").val("0");

	$("#hddidmatricula").val("0");
	$("#modalmatricula").modal("show");
});
$(document).on("click", ".btnactualizarmatricula", function() {
	$("#cboalumnos").val($(this).attr("data-codalumno"));
	$("#cbonivel").val($(this).attr("data-codnivel"));
	$("#cbogrado").val($(this).attr("data-codgrado"));
	$("#cboseccion").val($(this).attr("data-codseccion"));
	$("#txtnomfecha").val($(this).attr("data-fecha"));

	$("#hddidmatricula").val($(this).attr("data-codmatricula"));
	$("#modalmatricula").modal("show");
});
$(document).on("click", "#btnregistrarmatricula", function() {
	var idalumno = $("#cboalumnos").val();
	if (idalumno === "0") {
		$("#erroralumno").text("Es obligatorio seleccionar una Almuno.");
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
	if ($("#txtnomfecha").val() === "") {
		$("#errornomfecha").text("Es obligatorio la fecha.");
	} else {
		$("#errornomfecha").text("");
	}
	if ($("#txtnomfecha").val() !== "") {
		if ($("#hddidmatricula").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Matriculas/registrarMatricula",
				data: JSON.stringify({
					idalumno: $("#cboalumnos").val(),
					idnivel: $("#cbonivel").val(),
					idgrado: $("#cbogrado").val(),
					idseccion: $("#cboseccion").val(),
					fecha: $("#txtnomfecha").val()
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarMatriculas();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Matriculas/registrarMatricula",
				data: JSON.stringify({
					idmatricula: $("#hddidmatricula").val(),
					idalumno: $("#cboalumnos").val(),
					idnivel: $("#cbonivel").val(),
					idgrado: $("#cbogrado").val(),
					idseccion: $("#cboseccion").val(),
					fecha: $("#txtnomfecha").val()
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarMatriculas();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalmatricula").modal("hide");
	} //cierre del if
});
$(document).on("click", ".btneliminarmatricula", function() {
	//alert($(this).attr("data-codcurso"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la matricula del alumno: " +
		$(this).attr("data-codalumno") + "?");
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
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarMatriculas();
			}
			mostrarMensaje(resultado.mensaje, estilo);
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
					"<td>" + value.idalumno + "</td>" +
					"<td>" + value.idnivel + "</td>" +
					"<td>" + value.idgrado + "</td>" +
					"<td>" + value.idseccion + "</td>" +
					"<td>" + value.fecha + "</td>" +
					"<td>" + value.estado + "</td>" +
					"<td><button type='button' class='btn btn-info btndetallematricula' " +
					" data-codmatricula='" + value.idmatricula + "'>Ver Detalle</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-info btnactualizarmatricula' " +
					" data-codmatricula='" + value.idmatricula + "'" +
					" data-codalumno='" + value.idalumno + "'" +
					" data-codnivel='" + value.idnivel + "'" +
					" data-codgrado='" + value.idgrado + "'" +
					" data-codseccion='" + value.idseccion + "'" +
					" data-fecha='" + value.fecha + "'" +
					" data-estado='" + value.estado + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarmatricula' " +
					" data-codmatricula='" + value.idmatricula + "'" +
					" data-codalumno='" + value.idalumno + "'>Eliminar</button>" +
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
					"<td>" + value.alumno  + "</td>" +
					"<td class='text-center'>" + value.nivel + "</td>" +
					"<td class='text-center'>" + value.grado + "</td>" +
					"<td class='text-center'>" + value.seccion + "</td>" +
				"</tr>")
			});
			$("#modaldetallematricula").modal("show");
		}
	});
});
