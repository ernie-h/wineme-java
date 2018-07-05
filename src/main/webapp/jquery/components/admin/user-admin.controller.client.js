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
		$phoneFld = $('#firstNameFld');
		$roleFld = $('#lastNameFld');
		$dateOfBirthFld = $('#firstNameFld');

		$removeBtn = $('#wbdv-remove');
		$editBtn = $('#wbdv-edit');
		$createBtn = $('.wbdv-create');

		$userRowTemplate = $('.wbdv-template.wbdv-user').clone();
		$tbody = $('.wbdv-tbody');

		$createBtn.click(createUser);
	}

	function createUser() {
		console.log('Create User hit');
		var
		if ($usernameFld && $passwordFld && $firstNameFld && $lastNameFld != null) {
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
