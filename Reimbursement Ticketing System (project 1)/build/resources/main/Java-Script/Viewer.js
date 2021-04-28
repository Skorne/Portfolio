window.onload= getTickets;

async function getTickets(){
    const responsePayload= await fetch("http://localhost:9336/api/ticketlist");
    let ourJSON= await responsePayload.json();
    displayTickets(ourJSON);
}

function displayTickets(json){
    console.log(json);
    let table= document.getElementById("ticketTable");
    for(let i=0; i<json.length; i++){
        let row= table.insertRow(i+1);
        let ticketID= row.insertCell(0);
        let amount= row.insertCell(1);
        let submitTime= row.insertCell(2);
        let author= row.insertCell(3);
        let resolveTime= row.insertCell(4);
        let resolver= row.insertCell(5);
        let status= row.insertCell(6);
        let type= row.insertCell(7);
        let description= row.insertCell(8);

        ticketID.innerText= json[i].ticketID;
        amount.innerText= json[i].amount;
        submitTime.innerText= json[i].submitTime;
        resolveTime.innerText= json[i].resolveTime;
        description.innerText= json[i].description;
        author.innerText= json[i].author;
        resolver.innerText= json[i].resolvedBy;
        status.innerText= json[i].status;
        type.innerText= json[i].reimbType;
    }
}