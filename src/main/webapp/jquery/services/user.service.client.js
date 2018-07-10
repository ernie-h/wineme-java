function AdminUserServiceClient() {
  this.createUser = createUser;
  this.findAllUsers = findAllUsers;
  this.findUserById = findUserById;
  this.deleteUser = deleteUser;
  this.updateUser = updateUser;
  this.register = register;
  this.login = login;
  this.registerUrl = 'http://localhost:8080/api/register';
  this.loginUrl = 'http://localhost:8080/api/login';
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
    if (response.status === 200) {
      window.location.href = '/jquery/profile/profile.template.client.html';
    } else {
      $('#username-alert').show();
    }
  }

  function login(username, password) {
    console.log('fetch hit');
    return fetch(self.loginUrl, {
      method: 'POST',
      body: JSON.stringify({ username: username, password: password }),
      headers: {
        'Content-Type': 'application/json'
      },
      'credentials': 'include'
    })
    .then(loginSuccessful);
  }

  function loginSuccessful(response) {
    if (response.status === 200) {
      window.location.href = '/jquery/profile/profile.template.client.html';
    } else {
      alert('No user with credentials found. Please try again.');
    }
  }
}
