const URL = "http://localhost:8080/api/articolo/";
const TAB_ARTICOLI = document.getElementById('tabellaArt');
const SELECT_BOTTONE = document.getElementById('trovaArticoli');
const SELECT_FILTRO = document.getElementById("select_filtro");
const INPUT_FILTRO = document.getElementById("input_filtro");
const SELECT_MIN = document.getElementById('selectPmin');
const SELECT_MAX = document.getElementById('selectPmax');
const BOTTONE_SUBMIT = document.getElementById('subPrezzo')
const SELECT_BUTTON = document.getElementById("selectButton");
let template_riga = "";
let row = null;
let clicked = null;
let editButton = null;

let button = document.createElement("button");
button.innerHTML = 'edit';
button.class = 'editButton';
let weakbutton = button.outerHTML;


async function asyncReturn() {
    const articolo = await loadArt();

    for (const a of articolo) {
        row = TAB_ARTICOLI.insertRow();

        let cell1 = row.insertCell();
        cell1.innerHTML = a.id

        let cell2 = row.insertCell();
        cell2.innerHTML = a.descrizione

        let cell3 = row.insertCell();
        cell3.innerHTML = a.prezzo

        let cell4 = row.insertCell();
        cell4.innerHTML = a.categoria

        let cell5 = row.insertCell();
        cell5.innerHTML = a.rimanenza

        let cell6 = row.insertCell();
        cell6.innerHTML = weakbutton;
    }
}

async function loadArt() {

    let response = await fetch(URL + "lista");
    let art = await response.json();
    return art;

}


async function getByFilter(event) {
    if (INPUT_FILTRO.value !== "" && SELECT_FILTRO.value !== "Filtri") {
        console.log(SELECT_FILTRO.value)
        const articolo = await loadFiltro();
        TAB_ARTICOLI.innerHTML = "";

        for (const a of articolo) {
            row = TAB_ARTICOLI.insertRow();

            let cell1 = row.insertCell();
            cell1.innerHTML = a.id

            let cell2 = row.insertCell();
            cell2.innerHTML = a.descrizione

            let cell3 = row.insertCell();
            cell3.innerHTML = a.prezzo

            let cell4 = row.insertCell();
            cell4.innerHTML = a.categoria

            let cell5 = row.insertCell();
            cell5.innerHTML = a.rimanenza

        }
    } else {
        window.alert("Inserisci un valore nell'input e scegli un filtro")
    }
}


async function loadFiltro() {

    let response = await fetch(URL + SELECT_FILTRO.value + "/" + INPUT_FILTRO.value);
    let art = await response.json();
    return art;

}

/* GESTIONE PREZZO MIN E MAX */


async function getByPrezzo(event) {
    const articolo = await loadPrezzo();
    TAB_ARTICOLI.innerHTML = "";

    for (const a of articolo) {
        row = TAB_ARTICOLI.insertRow();

        let cell1 = row.insertCell();
        cell1.innerHTML = a.id

        let cell2 = row.insertCell();
        cell2.innerHTML = a.descrizione

        let cell3 = row.insertCell();
        cell3.innerHTML = a.prezzo

        let cell4 = row.insertCell();
        cell4.innerHTML = a.categoria

        let cell5 = row.insertCell();
        cell5.innerHTML = a.rimanenza

    }
}


async function loadPrezzo() {

    let response = await fetch(URL + SELECT_MIN.value + "/" + SELECT_MAX.value);
    console.log(SELECT_MIN.value + SELECT_MAX.value);
    let art = await response.json();
    return art;

}

function chiamaTest() {
    alert('CIAO!')
}


function chiamaModale(event) {
    event.stopPropagation();
    modal.show();
    createArticolo();
}

function createArticolo(event) {

    fetch(URL, {
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
    modal.hide()

    .catch((error) => {

        console.error('Error:', error);
    });
}


window.addEventListener('DOMContentLoaded', (event) => {
    asyncReturn();
    SELECT_BUTTON.addEventListener("click", getByFilter);
    BOTTONE_SUBMIT.addEventListener("click", getByPrezzo);

    let createButton = document.getElementById("createButton");
    createButton.addEventListener("click", chiamaModale);

    editButton = document.getElementById("editButton");
    editButton.addEventListener("click", chiamaTest);



});