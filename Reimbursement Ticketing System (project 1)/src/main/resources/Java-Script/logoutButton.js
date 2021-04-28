let logoutButton= document.getElementById("logout");
logoutButton.addEventListener("click", logOut);

function logOut(){
    fetch("http://localhost:9336/api/logout");
    window.location.replace("/index.html");
}