(function() {
  var $usernameFld, $passwordFld, $passwordFld2;
  var $firstNameFld, $lastNameFld;
  var $emailFld, $phoneFld, $dateOfBirthFld, $roleFld;
  var $registerBtn;
  var $usernameStr, $passwordStr, $passwordStr2;
  var $firstNameStr, $lastNameStr;
  var $emailStr, $phoneStr, $dateOfBirthStr, $roleStr;
  var userService = new AdminUserServiceClient();
  $(main);

  function main() {
    $usernameFld = $('#usernameFld');
    $passwordFld = $('#passwordFld');
    $passwordFld2 = $('#passwordFld2');
    $firstNameFld = $('#firstNameFld');
    $lastNameFld = $('#lastNameFld');
    $emailFld = $('#emailFld');
    $phoneFld = $('#phoneFld');
    $dateOfBirthFld = $('#dateOfBirthFld');
    $roleFld = $('#roleFld');
    $registerBtn = $('#registerBtn');
    $registerBtn.click(register);
  }

  function register() {
<<<<<<< Updated upstream
     $usernameStr = $usernameFld.val();
     $passwordStr = $passwordFld.val();
     $passwordStr2 = $passwordFld2.val();
     $firstNameStr = $firstNameFld.val();
     $lastNameStr = $lastNameFld.val();
     $emailStr = $emailFld.val();
     $phoneStr = $phoneFld.val();
     $dateOfBirthStr = $dateOfBirthFld.val();
     $roleStr = $roleFld.val();

<<<<<<< Updated upstream
     if (($passwordStr || $passwordStr2 !== '') && $passwordStr === $passwordStr2) {
       if ($usernameStr && $passwordStr && $firstNameStr && $lastNameStr &&
           $emailStr && $phoneStr && $dateOfBirthStr && $roleStr !== null) {
           userService.register(new User($usernameStr, $passwordStr, $firstNameStr,
             $lastNameStr, $emailStr, $phoneStr, $dateOfBirthStr, $roleStr))
             .then(registrationAlertHandler);
       } else {
         alert('Please fill in all fields.');
       }
     } else {
       alert('Passwords do not match. Please retype.');
     }
=======
    // var passwordStr2 = passwordFld2.val();

    if ($usernameStr && $passwordStr && $firstNameStr && $lastNameStr &&
        $emailStr && $phoneStr && $dateOfBirthStr && $roleStr !== null) {
        userService.register(new User($usernameStr, $passwordStr, $firstNameStr,
          $lastNameStr, $emailStr, $phoneStr, $dateOfBirthStr, $roleStr))
          .then(registrationAlertHandler);
    } else {
      alert('Please fill in all fields.');
=======
    $usernameStr = $usernameFld.val();
    $passwordStr = $passwordFld.val();
    $passwordStr2 = $passwordFld2.val();
    $firstNameStr = $firstNameFld.val();
    $lastNameStr = $lastNameFld.val();
    $emailStr = $emailFld.val();
    $phoneStr = $phoneFld.val();
    $dateOfBirthStr = $dateOfBirthFld.val();
    $roleStr = $roleFld.val();

    if (($passwordStr || $passwordStr2 !== '') && $passwordStr === $passwordStr2) {
      if ($usernameStr && $passwordStr && $firstNameStr && $lastNameStr &&
        $emailStr && $phoneStr && $dateOfBirthStr && $roleStr !== null) {
        userService.register(new User($usernameStr, $passwordStr, $firstNameStr,
            $lastNameStr, $emailStr, $phoneStr, $dateOfBirthStr, $roleStr))
          .then(registrationAlertHandler);
      } else {
        alert('Please fill in all fields.');
      }
    } else {
      alert('Passwords do not match. Please retype.');
>>>>>>> Stashed changes
    }
>>>>>>> Stashed changes
  }

  function registrationAlertHandler(response) {
    if (response.status === 200) {
      window.location.href = '/jquery/profile/profile.template.client.html';
    } else {
      alert('Oops. That Username is already taken. Pick a new one!');
    }
  }

})();
