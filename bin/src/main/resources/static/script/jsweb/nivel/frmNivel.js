$(document).on("click", "#btnagregarnivel", function() {
	$("#txtnomnivel").val("");
	$("#hddidnivel").val("0");
	$("#modalnivel").modal("show");
});

$(document).on("click", ".btnactualizarnivel", function() {
	$("#txtnomnivel").val($(this).attr("data-nomnivel"));
	$("#hddidnivel").val($(this).attr("data-codnivel"));
	$("#modalnivel").modal("show");
});

$(document).on("click", "#btnregistrarnivel", function() {
	if ($("#txtnomnivel").val() === "") {
		$("#errornomnivel").text("Es obligatorio el nombre del Nivel.");
	} else {
		$("#errornomnivel").text("");
	}
	if ($("#txtnomnivel").val() !== "") {
		if ($("#hddidnivel").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Nivel/registrarNivel",
				data: JSON.stringify({
					nombre: $("#txtnomnivel").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarNiveles();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Nivel/registrarNivel",
				data: JSON.stringify({
					idnivel: $("#hddidnivel").val(),
					nombre: $("#txtnomnivel").val(),
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarNiveles();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalnivel").modal("hide");
	}


});

$(document).on("click", ".btneliminarnivel", function() {
	//alert($(this).attr("data-codcurso"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar el Nivel: " +
		$(this).attr("data-nomnivel") + "?");
	$("#hddidniveleliminar").val($(this).attr("data-codnivel"));
	$("#modaleliminarnivel").modal("show");
});

$(document).on("click", "#btneliminarnivel", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Nivel/eliminarNivel",
		data: JSON.stringify({
			idnivel: $("#hddidniveleliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarNiveles();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarnivel").modal("hide");
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



function ListarNiveles() {
	$.ajax({
		type: "GET",
		url: "/Nivel/listaNivel",
		dataType: "json",
		success: function(resultado) {
			$("#tblnivel > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblnivel > tbody").append("<tr>" +
					"<td>" + value.idnivel + "</td>" +
					"<td>" + value.nombre + "</td>" +
					"<td>" + value.estado + "</td>" +
					"<td><button type='button' class='btn btn-info btnactualizarnivel' " +
					" data-codnivel='" + value.idnivel + "'" +
					" data-nomnivel='" + value.nombre + "'" +
					" data-estado='" + value.estado + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarnivel' " +
					" data-codnivel='" + value.idnivel + "'" +
					" data-nomnivel='" + value.nombre + "'>Eliminar</button>" +
					"</td></tr>")
			})

		}
	})
}
