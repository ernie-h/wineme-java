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

		$removeBtn = '.wbdv-remove';
		$editBtn = '.wbdv-edit';
		$createBtn = $('.wbdv-create');

		$userRowTemplate = $('.wbdv-template.wbdv-user').clone();
		$tbody = $('.wbdv-tbody');
		findAllUsers();

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

				userService.createUser(userObj).then(findAllUsers);
		} else {
			alert('Please fill in all fields before creating a user');
		}
	}

	function findAllUsers() {
		userService.findAllUsers().then(renderUsers);
	}
    // function findUserById() { … }
    function deleteUser() {
			var removeBtn = $(event.currentTarget);
			var userId = removeBtn.parent().parent().parent().attr('id');

			userService.deleteUser(userId).then(findAllUsers);
		}
    // function selectUser() { … }
    // function updateUser() { … }
    function renderUser(user) {
			var $row = $userRowTemplate.clone();
			$row.attr('id', user.id);

			$row.find($removeBtn).click(deleteUser);
			//$row.find($editBtn).click(editUser);

			$row.find('.wbdv-username').html(user.username);
			$row.find('.wbdv-password').html(user.password);
			$row.find('.wbdv-first-name').html(user.first_name);
			$row.find('.wbdv-last-name').html(user.last_name);
			$row.find('.wbdv-email').html(user.email);
			$row.find('.wbdv-phone').html(user.phone);
			$row.find('.wbdv-dob').html(user.date_of_birth);
			$row.find('.wbdv-role').html(user.role);

			$tbody.append($row);
		}

		function renderUsers(users) {
			$tbody.empty();
			for (var u in users) {
				var user = users[ u ];
				renderUser(user);
		}
	}
})();
