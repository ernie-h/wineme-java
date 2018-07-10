function AdminUserServiceClient() {
  this.createUser = createUser;
  this.findAllUsers = findAllUsers;
  this.findUserById = findUserById;
  this.deleteUser = deleteUser;
  this.updateUser = updateUser;
  this.register = register;
  this.registerUrl = 'http://localhost:8080/api/register';
  this.url = 'http://localhost:8080/api/user';
  var self = this;

  function createUser(user) {
     return fetch(self.url, {
         method: 'POST',
         body: JSON.stringify(user),
         headers: {
           'content-type': 'application/json'
         }
     });
  }
  function findAllUsers(callback) {
     return $.ajax({
         url: self.url,
         success: callback
    });
  }
  function findUserById(userId) {
     return fetch(
        self.url + '/' + userId)
        .then(function(response) {
          return response.json();
        });
  }

  function updateUser(userId, user) {
     return fetch(self.url + '/' + userId, {
         method: 'PUT',
         body: JSON.stringify(user),
         headers: {
           'content-type': 'application/json'
         }
       });
  }

  function deleteUser(userId) {
     return fetch(self.url + '/' + userId, {
       method: 'DELETE'
     });
  }
  function register(user) {
    return fetch(self.registerUrl, {
      method: 'POST',
      body: JSON.stringify(user),
      headers: {
        'Content-Type': 'application/json'
      },
      'credentials': 'include'
    })
    .then(registrationSuccessful);
  }

  function registrationSuccessful(response) {
    console.log(response.status);
    if (response.status === 200) {
      window.location.href = '/profile.template.client.html';
    } else {
      $('#username-alert').show();
    }
  }
}
