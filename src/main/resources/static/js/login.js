// Call the dataTables jQuery plugin
$(document).ready(function() {
    //On ready
});

async function login(){
    let bodyParameters = {};
    bodyParameters.email = document.getElementById('txtInputEmail').value;
    bodyParameters.password = document.getElementById('txtInputPassword').value;



  const rawResponse = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(bodyParameters)
  });
  const response = await rawResponse.text();

  if(response != 'Error'){
    localStorage.token = response;
    localStorage.email = bodyParameters.email;
    window.location.href = 'users.html';
  }else{
    alert("Incorrect credentials! Try again");
  }
}
