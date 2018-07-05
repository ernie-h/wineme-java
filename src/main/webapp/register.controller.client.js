(function init() {
  var registerBtn = $('#registerBtn');

  var usernameFld = $('#username');
  var passwordFld = $('#password');
  var passwordFld2 = $('#password2');

  registerBtn.click(registerHandler);
  registerBtn.css('color', 'red');

  function registerHandler() {
    var usernameStr = usernameFld.val();
    var passwordStr = passwordFld.val();
    var passwordStr2 = passwordFld2.val();

    var userObj = {
      username: usernameStr,
      password: passwordStr
    };

    var userObjStr = JSON.stringify(userObj);
		console.log(userObjStr);

    fetch('/register', {
      method: 'post',
      body: userObjStr,
      headers: {
        contentType: 'application/json'
      }
    });
  }
})();
