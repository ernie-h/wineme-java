(function() {
    var $usernameFld, $passwordFld, $usernameStr, $passwordStr;
    var $loginBtn;
    var userService = new AdminUserServiceClient();
    $(main);

  function main() {
    $usernameFld = $('#usernameFld');
    $passwordFld = $('#passwordFld');
    $loginBtn = $('#loginBtn');
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
})();
