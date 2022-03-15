"use strict";

const url="http://localhost:8080/api/cliente/";
let template_riga = "";

function listaClienti(event){

	// rileggo la lista delle canzoni dal back-end e ridisegno la tabella

	fetch(url+"lista")
	.then(function(response) {
		return response.json();
	})
	.then(function(json) {
			
		console.log(json);

		// TODO posso ridisegnare la tabella
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


window.addEventListener(
	'DOMContentLoaded', 
	function(event){

	template_riga = document.getElementById("table_rows").innerHTML;	

    listaClienti();
});