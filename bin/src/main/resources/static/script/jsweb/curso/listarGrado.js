$(document).on("click", ".btnactualizargrado",function(){
	$("#txtnomgrado").val($(this).attr("data-nomgrado"));
	$("#txtestadogrado").val($(this).attr("data-estadogrado"));
	$("#hddidgrado").val($(this).attr("data-codgrado"));
	$("#modalgrado").modal("show");
});

$(document).on("click", ".btneliminargrado",function(){
	$("#mensajeeliminar").text("¿Está seguro de eliminar el grado: " +
		$(this).attr("data-nomgrado") + "?");
	$("#hddidgradoeliminar").val($(this).attr("data-codgrado"));
	$("#modaleliminargrado").modal("show");
});

$(document).on("click","#btnupdategrado",function(){
	if($("#txtnomgrado").val()===""){
		$("#errornomgrado").text("Es obligatorio el nombre del grado");
	}else{
		$("#errornomgrado").text("");
	}
	if($("#txtestadogrado").val()===""){
		$("#errorestadogrado").text("Es obligatorio el estado");
	}else{
		$("#errorestadogrado").text("");
	}
	if($("#txtnomgrado").val()!==""&&$("#hddidgrado").val()!=="0"){
		$.ajax({
			type:"POST",
			contentType: "application/json",
			url: "/Grado/actualizarGrado",
			data: JSON.stringify({
				idgrado: $("#hddidgrado").val(),
				nombre: $("#txtnomgrado").val(),
				estado: $("#txtestadogrado").val()
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
					ListarGrados();
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
				$("#modalgrado").modal("hide");
			}	
		});
	}else{
		alert(resultado.mensaje)
	}
	
});

$(document).on("click","#btneliminargrado", function(){
	if($("#hddidgradoeliminar").val()!=="0"){
		$.ajax({
			type:"POST",
			contentType: "application/json",
			url: "/Grado/eliminarGrado",
			data: JSON.stringify({
				idgrado: $("#hddidgradoeliminar").val()
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
					ListarGrados();
					
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
				$("#modaleliminargrado").modal("hide");
			}
		});	
	}
});

function ListarGrados(){
	$.ajax({
		type: "GET",
		url: "/Grado/ListasGrado",
		dataType: "json",
		success:function(resultado){
			$("#tblgrado > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblgrado > tbody").append("<tr>"+
					"<td>" + value.idgrado + "</td>"+
					"<td>" + value.nombre + "</td>"+
					"<td>" + value.estado + "</td>"+
					"<td><button type='button' class='btn btn-info btnactualizargrado' "+
					" data-codgrado='"+value.idgrado+"'"+
					" data-nomgrado='"+value.nombre+"'"+
					" data-estadogrado='"+value.estado+"'>Actualizar</button>"+
					"</td>"+
					"<td><button type='button' class='btn btn-danger btneliminargrado' "+
					" data-codgrado='"+value.idgrado+"'"+
					" data-nomgrado='"+value.nombre+"'>Eliminar</button>"+
					"</td></tr>")
			})
		}
	})
}























