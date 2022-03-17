"use strict";

const url="http://localhost:8080/api/cliente/";
let template_riga = "";
let selectFiltro = document.getElementById("select_filtro");
let inputFiltro = document.getElementById("inputFiltro");

listaClienti();

function listaClienti(event){

	fetch(url+"lista")
	.then(function(response) {
		return response.json();
	})
	.then(function(json) {
			
		console.log(json);

		let rows = "";

			for(let li=0; li<json.length; li++){
				let row = template_riga;
				rows += row.replaceAll("{{id}}", json[li].id)
					.replaceAll("{{nome}}", json[li].nome)
					.replaceAll("{{cognome}}", json[li].cognome)
					.replaceAll("{{email}}", json[li].email)
					.replaceAll("{{telefono}}", json[li].telefono)
					.replaceAll("{{indirizzo}}", json[li].indirizzo)
					.replaceAll("{{citta}}", json[li].citta)
					.replaceAll("{{provincia}}", json[li].provincia)
					.replaceAll("{{regione}}", json[li].regione);
			}
		
		document.getElementById("table_rows").innerHTML = rows;
		
	})
	.catch(function(err) { 
			alert(err);
			console.log('Failed to fetch page: ', err);
	});	
}

function getByFilter(event){
	
	fetch(url+selectFiltro.value+"/"+inputFiltro.value)
		.then(function(response){
			return response.json();
		})
		.then(function(json){

			console.log(json);

			let rows ="";
			for(let li=0; li<json.length; li++){
				let row = template_riga;
				rows += row.replaceAll("{{id}}", json[li].id)
					.replaceAll("{{nome}}", json[li].nome)
					.replaceAll("{{cognome}}", json[li].cognome)
					.replaceAll("{{email}}", json[li].email)
					.replaceAll("{{telefono}}", json[li].telefono)
					.replaceAll("{{indirizzo}}", json[li].indirizzo)
					.replaceAll("{{citta}}", json[li].citta)
					.replaceAll("{{provincia}}", json[li].provincia)
					.replaceAll("{{regione}}", json[li].regione);
				}
				document.getElementById("table_rows").innerHTML = rows;
			})
		.catch(function(err) { 
			alert(err);
			console.log('Failed to fetch page: ', err);
		})

}

/*function createCliente(event){
	
	
	fetch(url, {
	  method: 'POST',
	  
	  body: JSON.stringify(data),
	})
	.then(response => response.json())
	.then(data => {
	  console.log('Success:', data);
	})
	.catch((error) => {
	  console.error('Error:', error);
	});
}*/


window.addEventListener(
	'DOMContentLoaded', 
	function(event){

	template_riga = document.getElementById("table_rows").innerHTML;	
	
	let selectButton = document.getElementById("selectButton");
	selectButton.addEventListener("click", getByFilter);


    
});