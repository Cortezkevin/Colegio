$(document).ready(function(){
	$("#tblalumno").hide();
});

$(document).on("click", "#btnbuscar" , function(){
	//alert($("#cboespecialidad").val());
	var nivel = $("#cbonivel").val();
	var grado = $("#cbogrado").val();
	var seccion = $("#cboseccion").val();
	if(nivel === "0" && grado ==="0" && seccion === "0"){
		$("#tblalumno").hide();
		$("#tblalumno").html("");
		alert("Seleccione un nivel");
	}else{
		$.ajax({
			type: "GET",
			url: "/Notas/frmAlumnosxAula",
			data:{
				nivel: nivel,
				grado: grado,
				seccion: seccion
			},
			success: function(resultado){
				console.log(resultado);
				$("#tblalumno").html("");
				$.each(resultado, function(index, value){
					$("#tblalumno").append("<div class='col mb-4'>"+
					"<div class='card border-primary bg-info h-100'>"+
					"<img src='/img/silueta.jpg' class='card-img-top'>"+
					"<div class='card-body'>"+
					"<h5 class='card-title text-white'>Codigo: "+value.idalumno+"</h5>"+
					"<p class='card-text text-white'>Nombre Completo: "+value.nombrecompleto+ "<br />" +	
					"<p class='card-text text-white'>Apoderado: "+value.apoderado+ "<br />" +	
					"<button data-codalumno='"+value.idalumno+
					"' type='button' class='btn btn-dark btnvernotas'>Ver Notas</button>"+
					"<button data-codalumno='"+value.idalumno+
					"' type='button' class='btn btn-primary btnagregarnotas'>Registrar Notas</button>"+
					"</p></div></div></div>");
					$("#tblalumno").show();
				});
			}
		});
	}
});
$(document).on("click", ".btnvernotas", function(){
	$.ajax({
		type: "GET",
		url: "/Notas/frmCursoXNota",
		data:{
			idalumno: $(this).attr("data-codalumno")
		},
		dataType: 'json',
		success: function(resultado){
			$("#tblcursonota > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcursonota > tbody").append("<tr>"+
				"<td>"+ value.nombre + "</td>"+
				"<td class='text-center'>"+ value.examen1 + "</td>"+
				"<td class='text-center'>"+ value.examen2 + "</td>"+
				"<td class='text-center'>"+ value.examen3 + "</td>"+
				"<td class='text-center'>"+ value.examen4 + "</td>"+
				"<td class='text-center'>"+ value.promedio + "</td>"+
				"<td><button type='button' class='btn btn-info btnactualizarnota' " +
					" data-codnota='" + value.idnotas + "'" +
					" data-codalumno='" + value.idalumno + "'" +
					" data-codcurso='" + value.idcurso + "'" +
					" data-curso='" + value.nombre + "'" +
					" data-examen1='" + value.examen1 + "'" +										
					" data-examen2='" + value.examen2 + "'" +
					" data-examen3='" + value.examen3 + "'" +
					" data-examen4='" + value.examen4 + "'" +
					" data-promedio='" + value.promedio + "'" + "'>Editar</button>" +
					"</td>" +
				"</tr>");
			});	
			$("#modalcursosnota").modal("show");		
		}
	});
});

$(document).on("click", ".btnagregarnotas", function() {
	$.ajax({
		type: "GET",
		url: "/Notas/frmCursoXNota",
		data:{
			idalumno: $(this).attr("data-codalumno")
		},
		dataType: 'json',
		success: function(resultado){
			$("#tblcursonota > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcursonota > tbody").append("<tr>"+
				"<td>"+ value.nombre + "</td>"+
				"<td class='text-center'>"+ value.examen1 + "</td>"+
				"<td class='text-center'>"+ value.examen2 + "</td>"+
				"<td class='text-center'>"+ value.examen3 + "</td>"+
				"<td class='text-center'>"+ value.examen4 + "</td>"+
				"<td class='text-center'>"+ value.promedio + "</td>"+
					"</td>" +
				"</tr>");
			});		
		}
	});
	$("#cbocurso").val("0");
	$("#txtexamen1").val("00");
	$("#txtexamen2").val("00");
	$("#txtexamen3").val("00");
	$("#txtexamen4").val("00");
	$("#txtprom").val("00");
	$("#hddidnota").val("0");
	$("#hddidalumno").val($(this).attr("data-codalumno"));
	$("#modalcursosnota").modal("show");
});


$(document).on("click", ".btnactualizarnota", function() {
	$("#cbocurso").val($(this).attr("data-codcurso"));
	$("#txtexamen1").val($(this).attr("data-examen1"));
	$("#txtexamen2").val($(this).attr("data-examen2"));
	$("#txtexamen3").val($(this).attr("data-examen3"));
	$("#txtexamen4").val($(this).attr("data-examen4"));
	$("#txtprom").val($(this).attr("data-promedio"));
	$("#hddidnota").val($(this).attr("data-codnota"));
	$("#hddidalumno").val($(this).attr("data-codalumno"));
	$("#modalcursosnota").modal("show");
});

$(document).on("click", "#btnregistrarnota", function(){
	alert($("#hddidnota").val());
	var idcurso = $("#cbocurso").val();
	if (idcurso === "0") {
		$("#errorcurso").text("Es obligatorio seleccionar un curso.");
	}
	if ($("#cbocurso").val() !== "0") {
		if ($("#hddidnota").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Notas/registrarNotas",
				data: JSON.stringify({
					idalumno: $("#hddidalumno").val(),
					idcurso: $("#cbocurso").val(),
					examen1: $("#txtexamen1").val(),
					examen2: $("#txtexamen2").val(),
					examen3: $("#txtexamen3").val(),
					examen4: $("#txtexamen4").val(),
					promedio: $("#txtprom").val()
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
					//ListarAlumnos();
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
				//$("#modalalumno").modal("hide");
			}
			});
		}
		else {
			alert($("#hddidnota").val());
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Notas/actualizarNotas",
				data: JSON.stringify({
					idnota: $("#hddidnota").val(),
					idalumno: $("#hddidalumno").val(),
					idcurso: $("#cbocurso").val(),
					examen1: $("#txtexamen1").val(),
					examen2: $("#txtexamen2").val(),
					examen3: $("#txtexamen3").val(),
					examen4: $("#txtexamen4").val(),
					promedio: $("#txtprom").val()
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
					//ListarAlumnos();
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
				//$("#modalalumno").modal("hide");
			}
			});
		}
		//$("#modalalumno").modal("hide");
	}


});




