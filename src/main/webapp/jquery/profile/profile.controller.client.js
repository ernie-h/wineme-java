(function() {
  var $usernameFld, $passwordFld;
  var $firstNameFld, $lastNameFld;
  var $phoneFld, $dateOfBirthFld;
  var $roleFld, $emailFld;
  var $updateBtn, $logoutBtn;
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
    $updateBtn = $('#updateBtn');
    $logoutBtn = $('#logoutBtn');

    getProfile();
    $updateBtn.click(updateProfile);
    $logoutBtn.click(logout);
  }

  function getProfile() {
    userService.getProfile().then(populateValues);

  }
  function populateValues(user) {
    console.log(user);
    $userId = user.id;
    $usernameFld.val(user.username);
    $passwordFld.val(user.password);
    $firstNameFld.val(user.first_name);
    $lastNameFld.val(user.last_name);
    $emailFld.val(user.email);
    $phoneFld.val(user.phone);

    //work around for DATETIME conversion to DATE
    var d = user.date_of_birth;
    d = d.substring(0, d.indexOf(' '));
    $dateOfBirthFld.val(d);
    $roleFld.val(user.role);
  }

  function updateProfile() {
     $usernameStr = $usernameFld.val();
     $passwordStr = $passwordFld.val();
     $firstNameStr = $firstNameFld.val();
     $lastNameStr = $lastNameFld.val();
     $emailStr = $emailFld.val();
     $phoneStr = $phoneFld.val();
     $dateOfBirthStr = $dateOfBirthFld.val();
     $roleStr = $roleFld.val();
     userService.updateProfile(new User
       ($usernameStr, $passwordStr, $firstNameStr, $lastNameStr, $emailStr,
         $phoneStr, $dateOfBirthStr, $roleStr))
          .then(updateProfileAlertHandler);
  }

  function updateProfileAlertHandler(response) {
    if (response.status === 200) {
      alert('Update success.');
    } else {
      alert('Invalid session. Has to be right?');
    }
  }

  function logout() {
    userService.logout().then(logoutAlertHandler);
  }

  function logoutAlertHandler() {
      window.location.href = '/jquery/login/login.template.client.html';
      alert('Logout success!');
  }
})();
