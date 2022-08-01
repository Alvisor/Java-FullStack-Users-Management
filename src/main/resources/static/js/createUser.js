// Call the dataTables jQuery plugin
$(document).ready(function() {
    //On ready
});

async function registerUser(){
    let bodyParameters = {};
    bodyParameters.name = document.getElementById('txtFirstName').value;
    bodyParameters.lastName = document.getElementById('txtLastName').value;
    bodyParameters.address = document.getElementById('txtAddress').value;
    bodyParameters.email = document.getElementById('txtInputEmail').value;
    bodyParameters.phoneNumber = document.getElementById('txtPhone').value;
    bodyParameters.password = document.getElementById('txtInputPassword').value;

    let repeatPassword= document.getElementById('txtRepeatPassword').value;

    if(repeatPassword != bodyParameters.password){
        alert("Password doesn't match!");
    }

  const rawResponse = await fetch('api/createUsers', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(bodyParameters)
  });

  alert("Account succesfully created!");
  window.location.href = 'login.html';
}
