/**
 * 
 */
$(function() {
	$("#sfa").click(function(e) {
		e.preventDefault();

	});
	$(".BorrarLibrocomplejo").click(function(e) {
		e.preventDefault();
		var padre = $(this).parent().parent();
		var id = padre.find("td:first-child").text();
		var nombre = padre.find("td:nth-child(2)").text();
		var codigo  = padre.find("td:nth-child(3)").text();
		var precio = padre.find("td:nth-child(4)").text();
			$.post("BorrarProductoServlet", {
			id:id,nombre:nombre,codigo:codigo,precio:precio
		}).done(function(e) {
			padre.remove();
		}).fail(function(e) {
		});
	});
	
	
	
	$(".BorrarLibroSencillo").click(function(e) {
		e.preventDefault();
		var padre = $(this).parent().parent();
		
		var titulo = padre.find("td:first-child").text();
		var autor = padre.find("td:nth-child(2)").text();
		var isbn = padre.find("td:nth-child(3)").text();
		var img = padre.find("td:nth-child(4)").text();
		console.log(titulo);
		console.log(autor);
		console.log(isbn);
		console.log(img);
			$.post("BorrarServlet", {
			titulo:titulo,
			autor:autor,
			isbn:isbn,
			img:img
		}).done(function(e) {
			
			padre.remove();
		}).fail(function(e) {
		});
		
		
		
		
	});
	
	
//	$(".ModificarProductoServlet").click(function(e) {
//		e.preventDefault();
//		var padre = $(this).parent().parent();
//		var id = padre.find("td:first-child").text();
//		var nombre = padre.find("td:nth-child(2)").text();
//		var codigo  = padre.find("td:nth-child(3)").text();
//		var precio = padre.find("td:nth-child(4)").text();
//		$.post("ModificarProductoServlet", {
//			id:id,
//			nombre:nombre,
//			codigo:codigo,
//			precio:precio
//		}).done(function(e) {
//			padre.remove();
//		}).fail(function(e) {
//		});
 // });
})

function editar(t,e) {
	e.preventDefault();
	var padre = $(t).parent().parent(), i = 2;
	padre.find("td:not(:last-child)").each(function(){
		
		$("#formMod:nth-child(" + i + ") input").val($(this).html());
		console.log($("#formMod div:nth-child(" + i + ") input").val($(this).html()));
		
		i++;
	});
};