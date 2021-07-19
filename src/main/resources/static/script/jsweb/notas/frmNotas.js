$(document).ready(function(){
	$("#tblalumno").hide();
});

$(document).on("click", "#btnbuscar" , function(){
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
					"<button data-codalumno='"+value.idalumno+"'data-codbimestre='"+"0"+
					"' type='button' class='btn btn-dark btnvernotas'>Notas</button>"+
					"<button data-codalumno='"+value.idalumno+"'data-codbimestre='"+"0"+
					"' type='button' class='btn btn-primary btnagregarnotas'>Registrar Notas</button>"+"<br />" +
					"<button data-codalumno='"+value.idalumno+
					"' type='button' class='btn btn-dark btnvernotasbimestre'>Notas Bimestrales</button>"+"<br />" +
					"<button data-codalumno='"+value.idalumno+
					"' type='button' class='btn btn-primary btnbimestrenotas'>Registrar Notas Bimestrales</button>"+"<br />" +
					"<button data-codalumno='"+value.idalumno+
					"' type='button' class='btn btn-primary btnasistencias'>Asistencias</button>"+"<br />" +
					"<button data-codalumno='"+value.idalumno+
					"' type='button' class='btn btn-primary btnjustificaciones'>Justificaciones</button>"+
					"</p></div></div></div>");
					$("#tblalumno").show();
				});
						
			}
		});
	}
});
	
$(document).on("click", ".btnvernotas", function(){
	$("#errornotas").text("");
	var idalumno = $(this).attr("data-codalumno");
	$.ajax({
		type: "GET",
		url: "/Notas/frmCursoXNota",
		data:{
			idalumno: $(this).attr("data-codalumno"),
			idbimestre: $(this).attr("data-codbimestre")
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
				"<td ><button type='button' class='btn btn-info btnactualizarnota' " +
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
$(document).on("click", "#buscarnotabimestre", function(){
	$("#cbocurso").val("0");
	$("#txtexamen1").val("00");
	$("#txtexamen2").val("00");
	$("#txtexamen3").val("00");
	$("#txtexamen4").val("00");
	$("#txtprom").val("00");
	$.ajax({
		type: "GET",
		url: "/Notas/frmCursoXNota",
		data:{
			idalumno: idalumno,
			idbimestre: $("#cbobimestre").val()
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
				"<td ><button type='button' class='btn btn-info btnactualizarnota' " +
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
		}
	});
});
	
	
$("#cbobimestre").val("0");	
});



$(document).on("click", ".btnagregarnotas", function() {
	$("#errornotas2").text("");
	$("#errorcurso3").text("");
	var idalumno = $(this).attr("data-codalumno");
	$.ajax({
		type: "GET",
		url: "/Notas/frmCursoXNota",
		data:{
			idalumno: $(this).attr("data-codalumno"),
			idbimestre: $(this).attr("data-codbimestre")
		},
		dataType: 'json',
		success: function(resultado){
			$("#tblcursonota2 > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcursonota2 > tbody").append("<tr>"+
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
$(document).on("click", "#buscarnotabimestre2", function(){
	$("#cbocurso3").val("0");
	$("#txtexamen11").val("00");
	$("#txtexamen22").val("00");
	$("#txtexamen33").val("00");
	$("#txtexamen44").val("00");
	$("#txtprom1").val("00");
	$.ajax({
		type: "GET",
		url: "/Notas/frmCursoXNota",
		data:{
			idalumno: idalumno,
			idbimestre: $("#cbobimestre2").val()
		},
		dataType: 'json',
		success: function(resultado){
			$("#tblcursonota2 > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcursonota2 > tbody").append("<tr>"+
				"<td>"+ value.nombre + "</td>"+
				"<td class='text-center'>"+ value.examen1 + "</td>"+
				"<td class='text-center'>"+ value.examen2 + "</td>"+
				"<td class='text-center'>"+ value.examen3 + "</td>"+
				"<td class='text-center'>"+ value.examen4 + "</td>"+
				"<td class='text-center'>"+ value.promedio + "</td>"+
				"</tr>");
			});		
		}
	});
});
	$("#cbobimestre2").val("0");
	$("#cbocurso3").val("0");
	$("#txtexamen11").val("00");
	$("#txtexamen22").val("00");
	$("#txtexamen33").val("00");
	$("#txtexamen44").val("00");
	$("#txtprom1").val("00");
	$("#hddidnota").val("0");
	$("#hddidalumno2").val($(this).attr("data-codalumno"));
	$("#modalcursosnota2").modal("show");
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
	var idcurso = $("#cbocurso3").val();
	if (idcurso === "0") {
		$("#errorcurso3").text("Es obligatorio seleccionar un curso.");
	}
	
	if($("#txtexamen11").val() > 20 || $("#txtexamen22").val() > 20  || $("#txtexamen33").val() > 20  ||
	   $("#txtexamen44").val() > 20  || $("#txtprom1").val() > 20) {
		$("#errornotas").text("Una nota ingresada no es valida");
	}/*else if($("#txtexamen11").val() == "" || $("#txtexamen22").val() == "" || $("#txtexamen33").val() == ""  ||
	   $("#txtexamen44").val() == ""  || $("#txtprom1").val() == ""){
		$("#errornotas").text("Un campo esta vacio");
	}*/
	else{$("#errornotas").text("");}
	
	if($("#txtexamen1").val() > 20 || $("#txtexamen2").val() > 20 || $("#txtexamen3").val() > 20 || 
	   $("#txtexamen4").val() > 20 || $("#txtprom").val() > 20) {
		$("#errornotas2").text("Una nota ingresada no es valida");
	}/*else if($("#txtexamen1").val() == "" || $("#txtexamen2").val() == "" || $("#txtexamen3").val() == ""  ||
	   $("#txtexamen4").val() == ""  || $("#txtprom").val() == ""){
		$("#errornotas").text("Un campo esta vacio");
	}*/
	else{$("#errornotas2").text("");}
	
	
	if (/*(*/$("#cbocurso3").val() !== "0" /*|| $("#cbocurso").val() !== "0")*/ && ( $("#txtexamen11").val() < 21 && $("#txtexamen11").val() != "" && $("#txtexamen22").val() < 21 && $("#txtexamen22").val() != "" &&  $("#txtexamen33").val() < 21 && $("#txtexamen33").val() != "" && $("#txtexamen44").val() < 21 && $("#txtexamen44").val() != "" && $("#txtprom1").val() < 21 && $("#txtprom1").val() != "") 
	|| ($("#txtexamen1").val() < 21 && $("#txtexamen1").val() != "" && $("#txtexamen2").val() < 21 && $("#txtexamen2").val() != "" &&  $("#txtexamen3").val() < 21 && $("#txtexamen3").val() != "" && $("#txtexamen4").val() < 21 && $("#txtexamen4").val() != "" && $("#txtprom").val() < 21 && $("#txtprom").val() != "")) {
		if ($("#hddidnota").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Notas/registrarNotas",
				data: JSON.stringify({
					idalumno: $("#hddidalumno2").val(),
					idcurso: $("#cbocurso3").val(),
					idbimestre: $("#cbobimestre2").val(),
					examen1: $("#txtexamen11").val(),
					examen2: $("#txtexamen22").val(),
					examen3: $("#txtexamen33").val(),
					examen4: $("#txtexamen44").val(),
					promedio: $("#txtprom1").val()
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
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'success',
						  title: resultado.mensaje
						})
					ListarNotas2($("#hddidalumno2").val(),$("#cbobimestre2").val());
				}else{
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'error',
						  title: resultado.mensaje
						})
				}
			}
			});
		}
		else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Notas/actualizarNotas",
				data: JSON.stringify({
					idnota: $("#hddidnota").val(),
					idalumno: $("#hddidalumno").val(),
					idcurso: $("#cbocurso").val(),
					idbimestre:$("#cbobimestre").val(),
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
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'success',
						  title: resultado.mensaje
						})
					ListarNotas($("#hddidalumno").val(),$("#cbobimestre").val());
				}else{
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'error',
						  title: resultado.mensaje
						})
				}
			}
			});
		}
	}


});

$(document).on("click", ".btnbimestrenotas", function(){
	$("#errornotasbimestre2").text("");
	$("#errorcurso4").text("");
	$.ajax({
		type: "GET",
		url: "/Notas/frmNotaBimestreXAlumno",
		data:{
			idalumno: $(this).attr("data-codalumno")
		},
		dataType: 'json',
		success: function(resultado){
			$("#tblnotabimestre2 > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblnotabimestre2 > tbody").append("<tr>"+
				"<td>"+ value.nombre + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre1 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre2 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre3 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre4 + "</td>"+
				"<td class='text-center'>"+ value.promedio_anual + "</td>"+

				"</tr>");
			});	
		}
	});
	
	$("#cbocurso4").val("0");
	$("#txtbim11").val("00");
	$("#txtbim22").val("00");
	$("#txtbim33").val("00");
	$("#txtbim44").val("00");
	$("#txtproma1").val("00");
	$("#hddidnotabimestral").val("0");
	$("#hddidalumno").val($(this).attr("data-codalumno"));
	$("#modalnotabimestre2").modal("show");	
});



$(document).on("click", ".btnvernotasbimestre", function() {
	$("#errornotasbimestre").text("");
	$.ajax({
		type: "GET",
		url: "/Notas/frmNotaBimestreXAlumno",
		data:{
			idalumno: $(this).attr("data-codalumno"),
		},
		dataType: 'json',
		success: function(resultado){
			$("#tblnotabimestre > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblnotabimestre > tbody").append("<tr>"+
				"<td>"+ value.nombre + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre1 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre2 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre3 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre4 + "</td>"+
				"<td class='text-center'>"+ value.promedio_anual + "</td>"+
				"<td ><button type='button' class='btn btn-info btnactualizarnotabimestre' " +
				" data-codnotabimestre='" + value.idnotabimestre + "'" +
				" data-codalumno='" + value.idalumno + "'" +
				" data-codcurso='" + value.idcurso + "'" +
				" data-curso='" + value.nombre + "'" +
				" data-bim1='" + value.nota_bimestre1 + "'" +										
				" data-bim2='" + value.nota_bimestre2 + "'" +
				" data-bim3='" + value.nota_bimestre3 + "'" +
				" data-bim4='" + value.nota_bimestre4 + "'" +
				" data-prom='" + value.promedio_anual + "'" + "'>Editar</button>" +"</td>" +
				"</tr>");
			});		
			$("#modalnotabimestre").modal("show");	
		}
	});
});

$(document).on("click", ".btnactualizarnotabimestre", function() {
	$("#cbocurso2").val($(this).attr("data-codcurso"));
	$("#txtbim1").val($(this).attr("data-bim1"));
	$("#txtbim2").val($(this).attr("data-bim2"));
	$("#txtbim3").val($(this).attr("data-bim3"));
	$("#txtbim4").val($(this).attr("data-bim4"));
	$("#txtproma").val($(this).attr("data-prom"));
	$("#hddidnotabimestral").val($(this).attr("data-codnotabimestre"));
	$("#hddidalumno").val($(this).attr("data-codalumno"));
});



$(document).on("click", "#btnregistrarnotabimestre", function(){
	var idcurso = $("#cbocurso4").val();
	if (idcurso === "0") {
		$("#errorcurso4").text("Es obligatorio seleccionar un curso.");
	}
	
	if($("#txtbim11").val() > 20 || $("#txtbim22").val() > 20  || $("#txtbim33").val() > 20  ||
	   $("#txtbim44").val() > 20  || $("#txtproma1").val() > 20) {
		$("#errornotasbimestre2").text("Una nota ingresada no es valida");
	}else if($("#txtbim11").val() == "" || $("#txtbim22").val() == "" || $("#txtbim33").val() == ""  ||
	   $("#txtbim44").val() == ""  || $("#txtproma1").val() == ""){
		$("#errornotasbimestre2").text("Un campo esta vacio");
	}
	else{$("#errornotasbimestre2").text("");}
	
	if($("#txtbim1").val() > 20 || $("#txtbim2").val() > 20 || $("#txtbim3").val() > 20 || 
	   $("#txtbim4").val() > 20 || $("#txtproma").val() > 20) {
		$("#errornotasbimestre").text("Una nota ingresada no es valida");
	}else if($("#txtbim1").val() == "" || $("#txtbim2").val() == "" || $("#txtbim3").val() == ""  ||
	   $("#txtbim4").val() == ""  || $("#txtproma").val() == ""){
		$("#errornotasbimestre").text("Un campo esta vacio");
	}else{$("#errornotasbimestre").text("");}
	
	if (/*(*/$("#cbocurso4").val() !== "0"/* || $("#cbocurso2").val() !== "0")*/ && ( $("#txtbim11").val() < 21 && $("#txtbim11").val() != "" && $("#txtbim22").val() < 21 && $("#txtbim22").val() != "" &&  $("#txtbim33").val() < 21 && $("#txtbim33").val() != "" && $("#txtbim44").val() < 21 && $("#txtbim44").val() != "" && $("#txtproma1").val() < 21 && $("#txtproma1").val() != "") 
	|| ($("#txtbim1").val() < 21 && $("#txtbim1").val() != "" && $("#txtbim2").val() < 21 && $("#txtbim2").val() != "" 
	&&  $("#txtbim3").val() < 21 && $("#txtbim3").val() != "" && $("#txtbim4").val() < 21 && $("#txtbim4").val() != "" && $("#txtproma").val() < 21 && $("#txtproma").val() != "")) {
		if ($("#hddidnotabimestral").val() === "0") {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Notas/registrarNotaBimestre",
				data: JSON.stringify({
					idalumno: $("#hddidalumno").val(),
					idcurso: $("#cbocurso4").val(),
					nota_bimestre1: $("#txtbim11").val(),
					nota_bimestre2: $("#txtbim22").val(),
					nota_bimestre3: $("#txtbim33").val(),
					nota_bimestre4: $("#txtbim44").val(),
					promedio_anual: $("#txtproma1").val()
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
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'success',
						  title: resultado.mensaje
						})
					ListarNotasBimestre($("#hddidalumno").val());
				}else{
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'error',
						  title: resultado.mensaje
						})
				}
			}
			});
		}
		else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/Notas/actualizarNotaBimestre",
				data: JSON.stringify({
					idnotabimestre: $("#hddidnotabimestral").val(),
					idalumno: $("#hddidalumno").val(),
					idcurso: $("#cbocurso2").val(),
					nota_bimestre1: $("#txtbim1").val(),
					nota_bimestre2: $("#txtbim2").val(),
					nota_bimestre3: $("#txtbim3").val(),
					nota_bimestre4: $("#txtbim4").val(),
					promedio_anual: $("#txtproma").val()
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
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'success',
						  title: resultado.mensaje
						})
					ListarNotasBimestre2($("#hddidalumno").val());
				}else{
					const Toast = Swal.mixin({
						  toast: true,
						  position: 'top-end',
						  showConfirmButton: false,
						  timer: 3000,
						  timerProgressBar: true,
						  didOpen: (toast) => {
						    toast.addEventListener('mouseleave', Swal.resumeTimer)
						  }
						})
						
						Toast.fire({
						  icon: 'error',
						  title: resultado.mensaje
						})
				}
			}
			});
		}
	}

});


function ListarNotas(idalu, idbim) {
	$.ajax({
		type: "GET",
		url: "/Notas/frmCursoXNota",
		data:{
			idalumno: idalu,
			idbimestre: idbim
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
				"<td ><button type='button' class='btn btn-info btnactualizarnota' " +
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
		}
	});
}

function ListarNotas2(idalu, idbim) {
	$.ajax({
		type: "GET",
		url: "/Notas/frmCursoXNota",
		data:{
			idalumno: idalu,
			idbimestre: idbim
		},
		dataType: 'json',
		success: function(resultado){
			$("#tblcursonota2 > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcursonota2 > tbody").append("<tr>"+
				"<td>"+ value.nombre + "</td>"+
				"<td class='text-center'>"+ value.examen1 + "</td>"+
				"<td class='text-center'>"+ value.examen2 + "</td>"+
				"<td class='text-center'>"+ value.examen3 + "</td>"+
				"<td class='text-center'>"+ value.examen4 + "</td>"+
				"<td class='text-center'>"+ value.promedio + "</td>"+
				"</tr>");
			});			
		}
	});
}
function ListarNotasBimestre(idalu) {
$.ajax({
		type: "GET",
		url: "/Notas/frmNotaBimestreXAlumno",
		data:{
			idalumno: idalu
		},
		dataType: 'json',
		success: function(resultado){
			$("#tblnotabimestre2 > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblnotabimestre2 > tbody").append("<tr>"+
				"<td>"+ value.nombre + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre1 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre2 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre3 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre4 + "</td>"+
				"<td class='text-center'>"+ value.promedio_anual + "</td>"+

				"</tr>");
			});		
		}
	});
}

function ListarNotasBimestre2(idalu) {
$.ajax({
		type: "GET",
		url: "/Notas/frmNotaBimestreXAlumno",
		data:{
			idalumno: idalu
		},
		dataType: 'json',
		success: function(resultado){
			$("#tblnotabimestre > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblnotabimestre > tbody").append("<tr>"+
				"<td>"+ value.nombre + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre1 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre2 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre3 + "</td>"+
				"<td class='text-center'>"+ value.nota_bimestre4 + "</td>"+
				"<td class='text-center'>"+ value.promedio_anual + "</td>"+
				"<td ><button type='button' class='btn btn-info btnactualizarnotabimestre' " +
				" data-codnotabimestre='" + value.idnotabimestre + "'" +
				" data-codalumno='" + value.idalumno + "'" +
				" data-codcurso='" + value.idcurso + "'" +
				" data-curso='" + value.nombre + "'" +
				" data-bim1='" + value.nota_bimestre1 + "'" +										
				" data-bim2='" + value.nota_bimestre2 + "'" +
				" data-bim3='" + value.nota_bimestre3 + "'" +
				" data-bim4='" + value.nota_bimestre4 + "'" +
				" data-prom='" + value.promedio_anual + "'" + "'>Editar</button>" +"</td>" +
				"</tr>");
			});		
			$("#modalnotabimestre").modal("show");	
		}
	});
}



$(document).on("click", ".btnasistencias", function() {
	$.ajax({
		type: "GET",
		url: "/Notas/frmAsistencia",
		data:{
			idalumno: $(this).attr("data-codalumno"),
		},
		dataType: 'json',
		success: function(resultado){
			$("#tblasistencia > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblasistencia > tbody").append("<tr>"+
				"<td class='text-center'>"+ value.fecha + "</td>"+
				"<td class='text-center'>"+ value.estado + "</td>"+
				"<td class='text-center'>"+ value.comentario + "</td>"+
				"</tr>");
			});		
			$("#modalasistencias").modal("show");	
		}
	});
});


$(document).on("click", ".btnjustificaciones", function() {
	$.ajax({
		type: "GET",
		url: "/Notas/frmJustificaciones",
		data:{
			idalumno: $(this).attr("data-codalumno"),
		},
		dataType: 'json',
		success: function(resultado){
			$("#tbljustificaciones > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tbljustificaciones > tbody").append("<tr>"+
				"<td class='text-center'>"+ value.fecha_falta + "</td>"+
				"<td class='text-center'>"+ value.fecha_justi + "</td>"+
				"<td class='text-center'>"+ value.descripcion + "</td>"+
				"</tr>");
			});		
			$("#modaljustificaciones").modal("show");	
		}
	});
});