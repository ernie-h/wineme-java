function AdminUserServiceClient() {
  this.createUser = createUser;
  this.findAllUsers = findAllUsers;
  this.findUserById = findUserById;
  this.deleteUser = deleteUser;
  this.updateUser = updateUser;
  this.register = register;
  this.login = login;
  this.updateProfile = updateProfile;
  this.getProfile = getProfile;
  this.logout = logout;

  this.url = '/api/user';
  this.registerUrl = '/api/register';
  this.loginUrl = '/api/login';
  this.updateProfileUrl = '/api/profile';
  this.logoutUrl = '/api/logout';
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

  function updateProfile(user) {
    console.log(user);
    return fetch(self.updateProfileUrl, {
      method: 'PUT',
      body: JSON.stringify(user),
      headers: {
        'Content-Type': 'application/json'
      },
      'credentials': 'include'
    })
    .then(updateProfileSuccessful);
  }

  function updateProfileSuccessful(response) {
    if (response.status === 200) {
      alert('Update success.')
    } else {
      alert('Invalid session. Has to be right?');
    }
  }

  function getProfile() {
    return fetch(self.updateProfileUrl, {
      'credentials': 'include'
    })
       .then(function(response) {
         return response.json();
       });
  }

  function logout() {
    return fetch(self.registerUrl, {
      method: 'POST',
      'credentials': 'include'
    })
    .then(logoutSuccess);
  }

  function logoutSuccess() {
      window.location.href = '/jquery/login/login.template.client.html';
      alert('Logout success!')
  }
}
