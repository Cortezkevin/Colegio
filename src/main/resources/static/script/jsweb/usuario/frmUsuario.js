$(document).on("click", "#btnagregarusuario", function() {
	$("#txtnomusuario").val("");
	$("#txtcontraseña").val("");
	$("#hddidusuario").val("0");
	$("#modalusuario").modal("show");
});
$(document).on("click", ".btnactualizarusuario", function() {
	$("#txtnomusuario").val($(this).attr("data-nomusuario"));
	$("#txtcontraseña").val($(this).attr("data-contraseña"));
	$("#cbocargos").val($(this).attr("data-codcargo"));
	$("#cbopersonas").val($(this).attr("data-codpersona"));
	$("#txtestado").val($(this).attr("data-estado"));
	$("#hddidusuario").val($(this).attr("data-codusuario"));
	$("#modalusuario").modal("show");
});
$(document).on("click", "#btnregistrarusuario", function() {
	//validar ingreso de nombre de usuario
	if ($("#txtnomusuario").val() === "") {
		$("#errornomusuario").text("Es obligatorio el nombre de usuario.");
	} else {
		$("#errornomusuario").text("");
	}
	// validar ingreso contraseña
	if ($("#txtcontraseña").val() === "") {
		$("#errorcontraseña").text("Es obligatorio una contraseña.");
	} else {
		$("#errorcontraseña").text("");
	}
	// validar seleccion de cargo
	var idcargo = $("#cbocargos").val();
	if(idcargo === "0"){
		$("#errorcargo").text("Es obligatorio seleccionar un cargo.");}
	// validar seleccion de persona		
	var idpersona = $("#cbopersonas").val();
	if(idpersona === "0"){
		$("#errorpersona").text("Es obligatorio seleccionar una persona.");}
	//	
	if ($("#txtnomusuario").val() !== "") {
		if ($("#hddidusuario").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Usuario/registrarUsuario",
				data: JSON.stringify({
					nombreusuario: $("#txtnomusuario").val(),
					password: $("#txtcontraseña").val(),
					idcargo: $("#cbocargos").val(),
					idpersona: $("#cbopersonas").val()
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarUsuarios();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Usuario/registrarUsuario",
				data: JSON.stringify({
					idusuario: $("#hddidusuario").val(),
					nombreusuario: $("#txtnomusuario").val(),
					password: $("#txtcontraseña").val(),
					idcargo: $("#cbocargos").val(),
					idpersona: $("#cbopersonas").val(),
					estado: $("#txtestado").val()
				}),
				success: function(resultado) {
					var estilo = "danger";
					if (resultado.respuesta) {
						estilo = "success";
						ListarUsuarios();
					}
					mostrarMensaje(resultado.mensaje, estilo);
				}
			});
		}
		$("#modalusuario").modal("hide");
	}
});
$(document).on("click", ".btneliminarusuario", function() {
	alert($(this).attr("data-codusuario"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar al usuario: " +
		$(this).attr("data-nomusuario") + "?");
	$("#hddidusuarioeliminar").val($(this).attr("data-codusuario"));
	$("#modaleliminarusuario").modal("show");
});
$(document).on("click", "#btneliminarusuario", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Usuario/eliminarUsuario",
		data: JSON.stringify({
			idusuario: $("#hddidusuarioeliminar").val()
		}),
		success: function(resultado) {
			var estilo = "danger";
			if (resultado.respuesta) {
				estilo = "success";
				ListarUsuarios();
			}
			mostrarMensaje(resultado.mensaje, estilo);
			$("#modaleliminarusuario").modal("hide");
		}
	});
});
function ListarUsuarios() {
	$.ajax({
		type: "GET",
		url: "/Usuario/listarUsuarios",
		dataType: "json",
		success: function(resultado) {
			$("#tblusuario > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblusuario > tbody").append("<tr>" +
					"<td>" + value.idusuario + "</td>" +
					"<td>" + value.nombreusuario + "</td>" +
					"<td>" + value.password+ "</td>" +
					"<td>" + value.idcargo + "</td>" +
					"<td>" + value.idpersona + "</td>" +
					"<td>" + value.estado + "</td>" +
					"<td><button type='button' class='btn btn-success btnverdetalle' " +
					" data-codusuario='" + value.idusuario + "'>Ver Detalle</button>" +
					"</td>"+
					"<td><button type='button' class='btn btn-info btnactualizarusuario' " +
					" data-codusuario='" + value.idusuario + "'" +
					" data-nomusuario='" + value.nombreusuario + "'" +
					" data-contraseña='" + value.password + "'" +
					" data-codcargo='" + value.idcargo + "'" +
					" data-codpersona='" + value.idpersona + "'" +
					" data-estado='" + value.estado + "'" +
					" data-foto='" + value.foto + "'>Actualizar</button>" +
					"</td>" +
					"<td><button type='button' class='btn btn-danger btneliminarusuario' " +
					" data-codusuario='" + value.idusuario + "'" +
					" data-nomusuario='" + value.nombreusuario + "'>Eliminar</button>" +
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


$(document).on("click", ".btnverdetalle", function() {
	$.ajax({
		type: "GET",
		url: "/Usuario/listarDetalleUsuario",
		dataType: 'json',
		data: {
			idusuario: $(this).attr("data-codusuario"),
		},
		success: function(resultado) {
			$("#tbldetalle > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tbldetalle > tbody").append("<tr>" +
					"<td>" + value.nombreusuario  + "</td>" +
					"<td class='text-center'>" + value.password + "</td>" +
					"<td class='text-center'>" + value.cargo + "</td>" +
					"<td class='text-center'>" + value.nombres + "</td>" +
					"<td class='text-center'>" + value.apellidos + "</td>" +
				"</tr>")
			});
			$("#modaldetalleusuario").modal("show");
		}
	});
});
