(function() {
  var $usernameFld, $passwordFld;
  var $firstNameFld, $lastNameFld;
  var $emailFld, $phoneFld, $dateOfBirthFld, $roleFld;
  var $registerBtn;
  var $usernameStr, $passwordStr;
  var $firstNameStr, $lastNameStr;
  var $emailStr, $phoneStr, $dateOfBirthStr, $roleStr;
  var userService = new AdminUserServiceClient();
  $(main);

  function main() {
    $usernameFld = $('#usernameFld');
    $passwordFld = $('#passwordFld');
    $firstNameFld = $('#firstNameFld');
    $lastNameFld = $('#lastNameFld');
    $emailFld = $('#emailFld');
    $phoneFld = $('#phoneFld');
    $dateOfBirthFld = $('#dateOfBirthFld');
    $roleFld = $('#roleFld');
    $registerBtn = $('#registerBtn');

    //Toggle popup for duplicate username
    $('#username-alert').hide();
    $('.close').click(function() {
      $('#username-alert').hide();
    });

    $registerBtn.click(register);
  }

  function register() {
     $usernameStr = $usernameFld.val();
     $passwordStr = $passwordFld.val();
     $firstNameStr = $firstNameFld.val();
     $lastNameStr = $lastNameFld.val();
     $emailStr = $emailFld.val();
     $phoneStr = $phoneFld.val();
     $dateOfBirthStr = $dateOfBirthFld.val();
     $roleStr = $roleFld.val();

    // var passwordStr2 = passwordFld2.val();

    if ($usernameStr && $passwordStr && $firstNameStr && $lastNameStr &&
        $emailStr && $phoneStr && $dateOfBirthStr && $roleStr !== null) {
        userService.register(new User($usernameStr, $passwordStr, $firstNameStr,
          $lastNameStr, $emailStr, $phoneStr, $dateOfBirthStr, $roleStr));
    } else {
      alert('Please fill in all fields.');
    }
  }

  // function registrationSuccessful(response) {
  //   if (response.status === 200) {
  //     window.location.href = '/jquery/profile/profile.template.client.html';
  //   } else {
  //     $('#username-alert').show();
  //   }
  // }
})();
