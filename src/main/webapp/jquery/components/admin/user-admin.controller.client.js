(function() {
	var $userId, $usernameFld, $passwordFld;
	var $firstNameFld, $lastNameFld;
	var $emailFld, $phoneFld, $dateOfBirthFld, $roleFld;
	var $removeBtn, $editBtn, $createBtn;
	var $userRowTemplate, $tbody;
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
		$removeBtn = '.wbdv-remove';
		$editBtn = '.wbdv-edit';
		$createBtn = $('.wbdv-create');
		$userRowTemplate = $('.wbdv-template.wbdv-user').clone();
		$tbody = $('.wbdv-tbody');
		findAllUsers();
		$createBtn.click(createUser);
	}

	function valueInit() {
		$usernameStr = $usernameFld.val();
		$passwordStr = $passwordFld.val();
		$firstNameStr = $firstNameFld.val();
		$lastNameStr = $lastNameFld.val();
		$emailStr = $emailFld.val();
		$phoneStr = $phoneFld.val();
		$dateOfBirthStr = $dateOfBirthFld.val();
		$roleStr = $roleFld.val();
	}

	function valueInitClear() {
		$usernameFld.val('');
		$passwordFld.val('');
		$firstNameFld.val('');
		$lastNameFld.val('');
		$emailFld.val('');
		$phoneFld.val('');
		$dateOfBirthFld.val('');
		$roleFld.val('');
	}

	function findAllUsers() {
		userService.findAllUsers().then(renderUsers);
	}

	function findUserById() {
		var editBtn = $(event.currentTarget);
		var userId = editBtn.parent().parent().parent().attr('id');
		userService.findUserById(userId).then(populateValues);
	}

	function renderUsers(users) {
		$tbody.empty();
		for (var u in users) {
			var user = users[ u ];
			renderUser(user);
		}
	}

	function renderUser(user) {
		var $row = $userRowTemplate.clone();
		$row.attr('id', user.id);
		$row.find('.wbdv-username').html(user.username);
		$row.find('.wbdv-password').html(user.password);
		$row.find('.wbdv-first-name').html(user.first_name);
		$row.find('.wbdv-last-name').html(user.last_name);
		$row.find('.wbdv-email').html(user.email);
		$row.find('.wbdv-phone').html(user.phone);
		$row.find('.wbdv-dob').html(user.date_of_birth);
		$row.find('.wbdv-role').html(user.role);
		$row.find($removeBtn).click(deleteUser);
		$row.find($editBtn).click(findUserById);
		$tbody.append($row);
	}

	function createUser() {
		valueInit();
		if ($usernameStr && $passwordStr && $firstNameStr && $lastNameStr &&
				$emailStr && $phoneStr && $dateOfBirthStr && $roleStr !== null) {
				userService.createUser(new User(
					$usernameStr, $passwordStr, $firstNameStr, $lastNameStr, $emailStr,
					$phoneStr, $dateOfBirthStr, $roleStr))
				.then(findAllUsers);
				valueInitClear();
		} else {
			alert('Please fill in all fields before creating a user.');
		}
	}

	function deleteUser() {
		var removeBtn = $(event.currentTarget);
		var userId = removeBtn.parent().parent().parent().attr('id');
		userService.deleteUser(userId).then(findAllUsers);
	}

	function populateValues(user) {
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
		var $updateBtn = $('.wbdv-update');
		$createBtn.hide();
		$updateBtn.click(updateUser);
	}

	function updateUser() {
		valueInit();
		valueInitClear();
		$createBtn.show();
		userService.updateUser(
			$userId, new User(
				$usernameStr, $passwordStr, $firstNameStr, $lastNameStr, $emailStr,
				$phoneStr, $dateOfBirthStr, $roleStr))
			.then(findAllUsers);
	}
})();
