"use strict";

const url = "http://localhost:8080/api/articolo/";
let template_riga = "";
let selectFiltro = document.getElementById("select_filtro");
let inputFiltro = document.getElementById("inputFiltro");
let all_inputs = null;
let modal = null;
const SELECT_MIN = document.getElementById('selectPmin');
const SELECT_MAX = document.getElementById('selectPmax');
const BOTTONE_SUBMIT = document.getElementById('subPrezzo');


function listaArticoli(event) {

    fetch(url + "lista")
        .then(function(response) {
            return response.json();
        })
        .then(function(json) {

            console.log(json);

            let rows = "";

            for (let li = 0; li < json.length; li++) {
                let row = template_riga;
                rows += row.replaceAll("{{id}}", json[li].id)
                    .replaceAll("{{descrizione}}", json[li].descrizione)
                    .replaceAll("{{prezzo}}", json[li].prezzo)
                    .replaceAll("{{categoria}}", json[li].categoria)
                    .replaceAll("{{rimanenza}}", json[li].rimanenza)
            }

            document.getElementById("table_rows").innerHTML = rows;
            agganciaEventi();
        })
        .catch(function(err) {
            alert(err);
            console.log('Failed to fetch page: ', err);
        });
}

function getByFilter(event) {
    if (inputFiltro.value !== "" && selectFiltro.value !== "Filtri") {
        fetch(url + selectFiltro.value + "/" + inputFiltro.value)
            .then(function(response) {
                return response.json();
            })
            .then(function(json) {

                console.log(json);

                let rows = "";
                for (let li = 0; li < json.length; li++) {
                    let row = template_riga;
                    rows += row.replaceAll("{{id}}", json[li].id)
                        .replaceAll("{{descrizione}}", json[li].descrizione)
                        .replaceAll("{{prezzo}}", json[li].prezzo)
                        .replaceAll("{{categoria}}", json[li].categoria)
                        .replaceAll("{{rimanenza}}", json[li].rimanenza)
                }
                document.getElementById("table_rows").innerHTML = rows;
            })
            .catch(function(err) {
                alert(err);
                console.log('Failed to fetch page: ', err);
            })
    } else {
        window.alert("Inserisci un valore nell'input e scegli un filtro")
    }

}

function getByPrezzo(event) {
    if (SELECT_MIN.value <= SELECT_MAX.value) {
        fetch(url + SELECT_MIN.value + "/" + SELECT_MAX.value)
            .then(function(response) {
                return response.json();
            })
            .then(function(json) {

                console.log(json);

                let rows = "";
                for (let li = 0; li < json.length; li++) {
                    let row = template_riga;
                    rows += row.replaceAll("{{id}}", json[li].id)
                        .replaceAll("{{descrizione}}", json[li].descrizione)
                        .replaceAll("{{prezzo}}", json[li].prezzo)
                        .replaceAll("{{categoria}}", json[li].categoria)
                        .replaceAll("{{rimanenza}}", json[li].rimanenza)
                }
                document.getElementById("table_rows").innerHTML = rows;
            })
            .catch(function(err) {
                alert(err);
                console.log('Failed to fetch page: ', err);
            })
    } else {
        window.alert("Il prezzo minimo deve essere minore del prezzo massimo!")
    }

}

function chiamaModale(event) {
    event.stopPropagation();
    svuotaModale();
    modal.show();
}

function createArticolo(event) {

    fetch(url, {
            method: 'POST',
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({

                descrizione: document.getElementById("descrizione").value,
                prezzo: document.getElementById("prezzo").value,
                categoria: document.getElementById("categoria").value,
                rimanenza: document.getElementById("rimanenza").value,
            }),

        })
        .then(response => response.json())

    listaArticoli();
    svuotaModale();
    modal.hide()

    .catch((error) => {

        console.error('Error:', error);
    });
}

function editInsertArticolo(event) {


    let originator = event.currentTarget;
    let idArticolo = originator.getAttribute('articolo-id');

    console.log(idArticolo);

    fetch(url + idArticolo)
        .then(function(response) {
            return response.json();
        })
        .then(function(json) {
            console.log(json);

            document.getElementById("id").value = json.id;
            document.getElementById("descrizione").value = json.descrizione;
            document.getElementById("prezzo").value = json.prezzo;
            document.getElementById("categoria").value = json.categoria;
            document.getElementById("rimanenza").value = json.rimanenza;
        })
        .catch(function(err) {
            alert(err);
            console.log('Failed to fetch page: ', err);
        })

    agganciaEventi();
}

function editArticolo(event) {

    console.log(document.getElementById("id").value);
    fetch(url, {
            method: 'PUT',
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({
                id: document.getElementById("id").value,
                descrizione: document.getElementById("descrizione").value,
                prezzo: document.getElementById("prezzo").value,
                categoria: document.getElementById("categoria").value,
                rimanenza: document.getElementById("rimanenza").value,
            }),
        })
        .then(response => response.json())
    listaArticoli()
    svuotaModale()
    modal.hide()

    .catch((error) => {

        console.error('Error:', error);
    });

    agganciaEventi();
}

function agganciaEventi() {
    let editButton = document.getElementsByClassName("editButton");
    for (let li = 0; li < editButton.length; li++) {
        editButton[li].addEventListener("click", editInsertArticolo);
    }
}

function svuotaModale() {

    document.getElementById("id").value = "";
    document.getElementById("descrizione").value = "";
    document.getElementById("prezzo").value = "";
    document.getElementById("categoria").value = "";
    document.getElementById("rimanenza").value = "";

}

function editOrdine(event) {

    fetch(url, {
            method: 'PUT',
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({
                articolo: document.getElementById("articolo").value,
                quantita: document.getElementById("quantita").value,
                ordine: {
                    consegna: document.getElementById("consegna").value,
                    cliente: document.getElementById("cliente").value,
                    dipendente: document.getElementById("dipendente").value,
                    data: Date.now(),
                }
            }),
        })
        .then(function(response) {

            modal.hide();
            return response.json();
        })

    .catch((error) => {

        console.error('Error:', error);
    });

    agganciaEventi();
}

function editInsertOrdine(event) {


    let originator = event.currentTarget;
    let ordine_id = originator.getAttribute('ordine-id');
    console.log(idCliente);

    fetch(url + idCliente)
        .then(function(response) {
            return response.json();
        })
        .then(function(json) {
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
            document.getElementById("emailUtente").value = json.utente.email;
            document.getElementById("passwordUtente").value = json.utente.password;


        })
        .catch(function(err) {
            alert(err);
            console.log('Failed to fetch page: ', err);
        })

    agganciaEventi();


}

window.addEventListener(
    'DOMContentLoaded',
    function(event) {

        modal = new bootstrap.Modal(document.getElementById('exampleModal'), {});

        template_riga = document.getElementById("table_rows").innerHTML;

        let selectButton = document.getElementById("selectButton");
        selectButton.addEventListener("click", getByFilter);

        let createButton = document.getElementById("createButton");
        createButton.addEventListener("click", createArticolo);

        let updateButton = document.getElementById("updateButton");
        updateButton.addEventListener("click", editArticolo);
        
        let call_modale = document.getElementById("call_modale");
        call_modale.addEventListener("click", chiamaModale);

        let editButton = document.getElementsByClassName("editButton");
        for (let li = 0; li < editButton.length; li++) {
            editButton[li].addEventListener("click", editInsertArticolo);
        }

        BOTTONE_SUBMIT.addEventListener("click", getByPrezzo);

        listaArticoli(null);

    });