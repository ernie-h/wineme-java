(function() {
    var $usernameFld, $passwordFld, $usernameStr, $passwordStr;
    var $loginBtn;
    var userService = new AdminUserServiceClient();
    $(main);

  function main() {
    $usernameFld = $('#usernameFld');
    console.log($usernameFld);
    $passwordFld = $('#passwordFld');
    $loginBtn = $('#loginBtn');
    console.log($loginBtn);

    $loginBtn.click(login);
  }

  function login() {
    $usernameStr = $usernameFld.val();
    $passwordStr = $passwordFld.val();
    if ($usernameStr && $passwordStr !== null) {
      userService.login($usernameStr, $passwordStr);
    } else {
      alert('Please fill in all fields.');
    }
  }

  function loginSuccessful(response) {
    if (response.status === 200) {
      window.location.href = '/jquery/profile/profile.template.client.html';
    } else {
      alert('No user with credentials found. Please try again.');
    }
  }

})();
