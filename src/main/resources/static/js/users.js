// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
    $('#usersTable').DataTable();
});

async function loadUsers(){

  const rawResponse = await fetch('getUsers', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const users = await rawResponse.json();

    let usersTableHTML = '';
    for (let user of users){

        let userHTML = '<tr><td>'+user.id+'</td><td>'+user.name+' '+user.lastName+
        '</td><td>'+user.email+'</td><td>'+user.phone+
        '</td><td>'+user.address+'</td><td><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';
        usersTableHTML += userHTML;
    }

    console.log(users);

    document.querySelector('#usersTable tbody').outerHTML = usersTableHTML;
}