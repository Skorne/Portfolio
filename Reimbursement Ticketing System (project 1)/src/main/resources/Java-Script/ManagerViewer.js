window.onload= getTickets;
let noFilterButton= document.getElementById('noFilter');
let pendFilterButton= document.getElementById('pendingFilter');
let decFilterButton= document.getElementById('decidedFilter');

noFilterButton.addEventListener('click', displayTickets);
pendFilterButton.addEventListener('click', pendFilter);
decFilterButton.addEventListener('click', decidedFilter);

var ticketList= null;
async function getTickets(){
    const responsePayload= await fetch("http://localhost:9336/api/ticketlist");
    let ourJSON= await responsePayload.json();
    ticketList= ourJSON;
    displayTickets();
}

function displayTickets(){
    clearTable();
    let table= document.getElementById("ticketTable").getElementsByTagName("tbody")[0];
    populateRows(table, ticketList);
}

function pendFilter(){
    clearTable();
    
    tempList= ticketList.filter(element=> element.status=== "Pending" );
    let table= document.getElementById("ticketTable").getElementsByTagName("tbody")[0];
    populateRows(table, tempList);
}

function decidedFilter(){
    clearTable();

    tempList= ticketList.filter(element=> element.status!= "Pending" );
    let table= document.getElementById("ticketTable").getElementsByTagName("tbody")[0];
    populateRows(table, tempList);
}


function clearTable(){
    let body= document.getElementById("ticketTable").getElementsByTagName("tbody")[0];
    let newBody= document.createElement("tbody");

    body.parentNode.replaceChild(newBody, body);
}

function populateRows(tbody, ticketList){
    for(let i=0; i<ticketList.length; i++){
        let row= tbody.insertRow();
        let ticketID= row.insertCell(0);
        let amount= row.insertCell(1);
        let submitTime= row.insertCell(2);
        let author= row.insertCell(3);
        let resolveTime= row.insertCell(4);
        let resolver= row.insertCell(5);
        let status= row.insertCell(6);
        let type= row.insertCell(7);
        let description= row.insertCell(8);

        ticketID.innerText= ticketList[i].ticketID;
        amount.innerText= ticketList[i].amount;
        submitTime.innerText= ticketList[i].submitTime;
        resolveTime.innerText= ticketList[i].resolveTime;
        description.innerText= ticketList[i].description;
        author.innerText= ticketList[i].author;
        resolver.innerText= ticketList[i].resolvedBy;

        status.innerText= ticketList[i].status;
        type.innerText= ticketList[i].reimbType;
    }
}

function storeUpdateStatus(){

}
