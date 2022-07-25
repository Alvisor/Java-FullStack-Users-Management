// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
    $('#usersTable').DataTable();
});

async function loadUsers(){

  const rawResponse = await fetch('api/getUsers', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const users = await rawResponse.json();


    let usersTableHTML = '';
    for (let user of users){
        let deleteButton = '<a href="#" onclick="deleteUser('+user.id+')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>'
        let phone = user.phoneNumber ==null ? '-':user.phoneNumber;
        let userHTML = '<tr><td>'+user.id+'</td><td>'+user.name+' '+user.lastName+
        '</td><td>'+user.email+'</td><td>'+ phone +
        '</td><td>'+user.address+'</td><td>'+deleteButton+'</td></tr>';
        usersTableHTML += userHTML;
    }

    console.log(users);

    document.querySelector('#usersTable tbody').outerHTML = usersTableHTML;
}

async function deleteUser(id){
    if (!confirm('Do you want to delete that user?')){
        return;
    }

    const rawResponse = await fetch('api/deleteUser/'+id, {
        method: 'DELETE',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
       location.reload();
}