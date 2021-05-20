

$(document).on("click", ".btnactualizarseccion",function(){
	$("#txtnomseccion").val($(this).attr("data-nomseccion"));
	$("#txtestadoseccion").val($(this).attr("data-estadoseccion"));
	$("#hddidseccion").val($(this).attr("data-codseccion"));
	$("#modalseccion").modal("show");
});


$(document).on("click",".btneliminarseccion",function(){
	$("#mensajeeliminar").text("¿Está seguro de eliminar la seccion: " +
		$(this).attr("data-nomseccion") + "?");
	$("#hddidseccioneliminar").val($(this).attr("data-codseccion"));
	$("#modaleliminarseccion").modal("show");
});

$(document).on("click", "#btnactualizarseccion",function(){
	if($("#txtnomseccion").val()===""){
		$("#errornomseccion").text("Es obligatorio el nombre de la seccion");
	}else{
		$("#errornomgrado").text("");
	}
	if($("#txtestadoseccion").val()===""){
		$("#errorestadoseccion").text("Es obligatorio el estado");
	}else{
		$("#errorestadoseccion").text("");
	}
	if($("#txtnomseccion").val()!==""&&$("#hddidseccion").val()!=="0"&&$("#txtestadoseccion").val()!==""){
		$.ajax({
			type:"POST",
			contentType: "application/json",
			url: "/Seccion/actualizarSeccion",
			data: JSON.stringify({
				idseccion: $("#hddidseccion").val(),
				nombre: $("#txtnomseccion").val(),
				estado: $("#txtestadoseccion").val()
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
				$("#modalseccion").modal("hide");
			}
		})
	}
})


$(document).on("click","#btneliminarseccion",function(){
	if($("#hddidseccionelimina").val()!=="0"){
		$.ajax({
			type:"POST",
			contentType: "application/json",
			url: "/Seccion/eliminarSeccion",
			data: JSON.stringify({
				idseccion: $("#hddidseccioneliminar").val()
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
				$("#modaleliminarseccion").modal("hide");
			}
		});
	}
	
});









