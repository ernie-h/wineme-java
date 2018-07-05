(function() {
	var $usernameFld, $passwordFld;
	var $removeBtn, $editBtn, $createBtn;
	var $firstNameFld, $lastNameFld;
	var $userRowTemplate, $tbody;

	//var userService = new AdminUserServiceClient();
	$(main);
	function main() {
		console.log('Main func hit');
		$usernameFld = $('#usernameFld');
		$passwordFld = $('#passwordFld');

		$firstNameFld = $('#firstNameFld');
		$lastNameFld = $('#lastNameFld');

		$removeBtn = $('#wbdv-remove');
		$editBtn = $('#wbdv-edit');
		$createBtn = $('.wbdv-create');

		$userRowTemplate = $('.wbdv-template.wbdv-user').clone();
		$tbody = $('.wbdv-tbody');

		$createBtn.click(createUser);
	}

	function createUser() {
		console.log('Create User hit');
		if ($usernameFld && $passwordFld && $firstNameFld && $lastNameFld != null) {
			var $user = $.getScript('user.model.client.js', function() {
				User($usernameFld.val(),
					$passwordFld.val(),
					$firstNameFld.val(),
					$lastNameFld.val());
			});
			console.log($user);
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
