$(document).on("click", "#btnagregarcurso", function() {
	$("#cbonivel").val("0");
	$("#cbogrado").val("0");
	
	$("#txtnomcurso").val("");
	$("#txtdescripcion").val("");
	
	$("#hddidcurso").val("0");
	$("#modalcurso").modal("show");
});

$(document).on("click", ".btnactualizarcurso", function() {
	$("#cbonivel").val($(this).attr("data-idnivel"));
	$("#cbogrado").val($(this).attr("data-idgrado"));
	
	$("#txtnomcurso").val($(this).attr("data-nomcurso"));
	$("#txtdescripcion").val($(this).attr("data-descripcion"));
	$("#hddidcurso").val($(this).attr("data-idcurso"));
	$("#modalcurso").modal("show");
});

$(document).on("click", "#btnregistrarcurso", function() {
	var idnivel = $("#cbonivel").val();
	if (idnivel === "0") {
		$("#errornivel").text("Es obligatorio seleccionar un nivel.");
	}

	var idgrado = $("#cbogrado").val();
	if (idgrado === "0") {
		$("#errorgrado").text("Es obligatorio seleccionar un grado.");
	}
	
	if ($("#txtnomcurso").val() === "") {
		$("#errornomcurso").text("Es obligatorio el nombre del curso.");
	} else {
		$("#errornomcurso").text("");
	}
	if ($("#txtdescripcion").val() === "") {
		$("#errordescripcurso").text("Es obligatorio la descripcion del curso.");
	} else {
		$("#errordescripcurso").text("");
	}
	/*
	if ($("#txtestado").val() === "") {
		$("#errorestadocurso").text("Es obligatorio el estado del curso.");
	} else {
		$("#errorestadocurso").text("");
	}*/
	if ($("#txtnomcurso").val() !== "" && $("#txtdescripcion").val() !== "" && $("#txtestado").val() !== "" &&
	    $("#cbonivel").val() != "0" && $("#cbogrado").val() != "0") {
		if ($("#hddidcurso").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Curso/registrarCurso",
				data: JSON.stringify({
					idnivel: $("#cbonivel").val(),
					idgrado: $("#cbogrado").val(),
					nombre: $("#txtnomcurso").val(),
					descripcion: $("#txtdescripcion").val(),					
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarCursos();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Curso/registrarCurso",
				data: JSON.stringify({
					idcurso: $("#hddidcurso").val(),
					idnivel: $("#cbonivel").val(),
					idgrado: $("#cbogrado").val(),
					nombre: $("#txtnomcurso").val(),
					descripcion: $("#txtdescripcion").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarCursos();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalcurso").modal("hide");
	}


});

$(document).on("click", ".btneliminarcurso", function() {
	
	$("#mensajeeliminar").text("¿Está seguro de eliminar el curso: " +
		$(this).attr("data-nomcurso") + "?");
	$("#hddidcursoeliminar").val($(this).attr("data-idcurso"));
	$("#modaleliminarcurso").modal("show");
});

$(document).on("click", "#btneliminarcurso", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Curso/eliminarCurso",
		data: JSON.stringify({
			idcurso: $("#hddidcursoeliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarCursos();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarcurso").modal("hide");
		}
	});
});


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


function ListarCursos() {
	$.ajax({
		type: "GET",
		url: "/Curso/listarCursos",
		dataType: "json",
		success: function(resultado) {
			$("#tblcurso > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblcurso > tbody").append("<tr>" +
					"<td>" + value.idcurso + "</td>" +
					"<td>" + value.idnivel + "</td>" +
					"<td>" + value.idgrado + "</td>" +
					"<td>" + value.nombre + "</td>" +
					"<td>" + value.descripcion + "</td>" +
					"<td>" + value.estado + "</td>" +
					"<td><button type='button' class='btn btn-info btnactualizarcurso' " +
					" data-idcurso='" + value.idcurso + "'" +
					" data-idnivel='" + value.idnivel + "'" +
					" data-idgrado='" + value.idgrado + "'" +
					" data-nomcurso='" + value.nombre + "'" +
					" data-descripcion='" + value.descripcion + "'" +
					" data-estado='" + value.estado + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarcurso' " +
					" data-idcurso='" + value.idcurso + "'" +
					" data-idnivel='" + value.idnivel + "'" +
					" data-idgrado='" + value.idgrado + "'" +
					" data-nomcurso='" + value.nombre + "'" +
					" data-descripcion='" + value.descripcion + "'" +
					" data-estado='" + value.estado + "'>Actualizar</button>" +
					"</td></tr>")
			})

		}
	})
	
 	
}


