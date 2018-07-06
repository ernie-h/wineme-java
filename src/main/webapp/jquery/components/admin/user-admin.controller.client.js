(function() {
	var $usernameFld, $passwordFld;
	var $firstNameFld, $lastNameFld;
	var $emailFld, $phoneFld, $dateOfBirthFld, $roleFld;
	var $removeBtn, $editBtn, $createBtn;
	var $userRowTemplate, $tbody;

	//var userService = new AdminUserServiceClient();
	$(main);
	function main() {
		console.log('Main func hit');
		$usernameFld = $('#usernameFld');
		$passwordFld = $('#passwordFld');
		$firstNameFld = $('#firstNameFld');
		$lastNameFld = $('#lastNameFld');
		$emailFld = $('#emailFld');
		$phoneFld = $('#phoneFld');
		$dateOfBirthFld = $('#dateOfBirthFld');
		$roleFld = $('#roleFld');

		$removeBtn = $('#wbdv-remove');
		$editBtn = $('#wbdv-edit');
		$createBtn = $('.wbdv-create');

		$userRowTemplate = $('.wbdv-template.wbdv-user').clone();
		$tbody = $('.wbdv-tbody');

		$createBtn.click(createUser);
	}

	function createUser() {
		console.log('Create User hit');
		var $usernameStr = $usernameFld.val();
		var $passwordStr = $passwordFld.val();
		var $firstNameStr = $firstNameFld.val();
		var $lastNameStr = $lastNameFld.val();
		var $emailStr = $emailFld.val();
		var $phoneStr = $phoneFld.val();
		var $dateOfBirthStr = $dateOfBirthFld.val();
		var $roleStr = $roleFld.val();

		if ($usernameStr && $passwordStr && $firstNameStr && $lastNameStr &&
			$emailStr && $phoneStr && $dateOfBirthStr && $roleStr !== null) {
				var userObj = {
					username: $usernameStr,
					password: $passwordStr,
					first_name: $firstNameStr,
					last_name: $lastNameStr,
					email: $emailStr,
					phone: $phoneStr,
					date_of_birth: $dateOfBirthStr,
					role: $roleStr
				};
				var userObjStr = JSON.stringify(userObj);

				console.log(userObj);
				console.log(userObjStr);

				fetch('http://localhost:8080/api/user', {
					method: 'post',
					body: userObjStr,
					headers: {
						contentType: 'application/json'
					}
				});
		} else {
			alert('Please fill in all fields before creating a user');
		}
	}


	// function findAllUsers() { … }
    // function findUserById() { … }
    // function deleteUser() { … }
    // function selectUser() { … }
    // function updateUser() { … }
    // function renderUser(user) { … }
	// function renderUsers(users) { … }
})();
