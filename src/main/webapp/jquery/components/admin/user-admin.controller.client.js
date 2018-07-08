(function() {
	var $usernameFld, $passwordFld;
	var $firstNameFld, $lastNameFld;
	var $emailFld, $phoneFld, $dateOfBirthFld, $roleFld;
	var $removeBtn, $editBtn, $createBtn;
	var $userRowTemplate, $tbody;

	var userService = new AdminUserServiceClient();
	console.log(userService);
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

		$removeBtn = $('#wbdv-remove');
		$editBtn = $('#wbdv-edit');
		$createBtn = $('.wbdv-create');

		$userRowTemplate = $('.wbdv-template.wbdv-user').clone();
		$tbody = $('.wbdv-tbody');

		$createBtn.click(createUser);
	}

	function createUser() {
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

				console.log(userObj);

				userService.createUser(userObj);
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

	// 	function renderUsers(users) {
	// 		$tbody.empty();
	// 		for (var u in users) {
	// 			var user = users[ u ];
	// 			var $row = $userRowTemplate.clone();
	// 			$row.find('.wbdv-username').html(user.username);
	// 			$tbody.append($row);
	// 	}
	// }
})();
