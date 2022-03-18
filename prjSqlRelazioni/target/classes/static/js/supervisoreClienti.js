"use strict";

const url="http://localhost:8080/api/cliente/";
let template_riga = "";
let selectFiltro = document.getElementById("select_filtro");
let inputFiltro = document.getElementById("inputFiltro");
let all_inputs = null;
let modal = null;


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
		agganciaEventi();
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

function createCliente(event){
			
	svuotaModale();

	console.log(document.getElementById("nomeCliente").value);
	fetch(url, {
	  method: 'POST',
	  headers: {
        "Content-type": "application/json; charset=UTF-8"
    },
	  body: JSON.stringify({
		  
        nome: document.getElementById("nomeCliente").value,
        cognome: document.getElementById("cognomeCliente").value,
        indirizzo: document.getElementById("indirizzoCliente").value,
        telefono: document.getElementById("telefonoCliente").value,
        regione: document.getElementById("regioneCliente").value,
        provincia: document.getElementById("provinciaCliente").value,
        citta: document.getElementById("cittaCliente").value,
		
		
    }),
	
	})
	.then(response => response.json())
	
	.catch((error) => {
		
	  console.error('Error:', error);
	});
	agganciaEventi();
}

function editInsertCliente(event){
	/*all_inputs = document.getElementsByClassName("clienteForm");
		for(let li=0; li<all_inputs.length; li++){
			all_inputs[li].value = "";
		}*/	

	let originator = event.currentTarget;
	let idCliente = originator.getAttribute('cliente-id');

	console.log(idCliente);

	fetch(url+idCliente)
		.then(function(response){
			return response.json();
		})
		.then(function(json){
			console.log(json);
				
			document.getElementById("idCliente").value = json.id; 
			document.getElementById("nomeCliente").value = json.nome; 
			document.getElementById("cognomeCliente").value = json.cognome; 
			document.getElementById("indirizzoCliente").value = json.indirizzo; 
			document.getElementById("telefonoCliente").value = json.telefono; 
			document.getElementById("regioneCliente").value = json.regione; 
			document.getElementById("provinciaCliente").value = json.provincia; 
			document.getElementById("cittaCliente").value = json.citta;
			document.getElementById("utenteCliente").value = json.utente.id; 
			

			})
		.catch(function(err) { 
			alert(err);
			console.log('Failed to fetch page: ', err);
		})

		agganciaEventi();
		
}

function editCliente(event){
	
	console.log(document.getElementById("nomeCliente").value);
	fetch(url, {
	  method: 'PUT',
	  headers: {
        "Content-type": "application/json; charset=UTF-8"
    },
	  body: JSON.stringify({
		id: document.getElementById("idCliente").value,  
        nome: document.getElementById("nomeCliente").value,
        cognome: document.getElementById("cognomeCliente").value,
        indirizzo: document.getElementById("indirizzoCliente").value,
        telefono: document.getElementById("telefonoCliente").value,
        regione: document.getElementById("regioneCliente").value,
        provincia: document.getElementById("provinciaCliente").value,
        citta: document.getElementById("cittaCliente").value,
		utente:{
			id: document.getElementById("utenteCliente").value
		}
		
       
    }),
	})
	.then(response => response.json())
	
	.catch((error) => {
		
	  console.error('Error:', error);
	});

	agganciaEventi();
}

function agganciaEventi(){
	let editButton = document.getElementsByClassName("editButton");
	for(let li=0; li<editButton.length; li++){
	editButton[li].addEventListener("click", editInsertCliente);	
	}
}

function svuotaModale(){

	document.getElementById("nomeCliente").innerHTML = ""; 
	document.getElementById("cognomeCliente").value = ""; 
	document.getElementById("indirizzoCliente").value = ""; 
	document.getElementById("telefonoCliente").value = ""; 
	document.getElementById("regioneCliente").value = ""; 
	document.getElementById("provinciaCliente").value = ""; 
	document.getElementById("cittaCliente").value = ""; 

}
window.addEventListener(
	'DOMContentLoaded', 
	function(event){

	modal = new bootstrap.Modal(document.getElementById('exampleModal'), {});
		
	template_riga = document.getElementById("table_rows").innerHTML;	
	
	let selectButton = document.getElementById("selectButton");
	selectButton.addEventListener("click", getByFilter);

	let createButton = document.getElementById("createButton");
	createButton.addEventListener("click", createCliente);

	let updateButton = document.getElementById("updateButton");
	updateButton.addEventListener("click", editCliente);

	let editButton = document.getElementsByClassName("editButton");
	for(let li=0; li<editButton.length; li++){
	editButton[li].addEventListener("click", editInsertCliente);	
	}
	
	listaClienti(null);
    
});