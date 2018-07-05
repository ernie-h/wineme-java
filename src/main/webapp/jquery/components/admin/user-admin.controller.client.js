( function() {
	var $usernameFld, $passwordFld;
	var $removeBtn, $editBtn, $createBtn;
	var $firstNameFld, $lastNameFld;
	var $userRowTemplate, $tbody;

	//var userService = new AdminUserServiceClient();
	$(main);
	function main() {
		console.log( "Main func hit" );
		$usernameFld = $( "#usernameFld" ).val();
		$passwordFld = $( "#passwordFld" ).val();

		$firstNameFld = $( "#firstNameFld" ).val();
		$lastNameFld = $( "#lastNameFld" ).val();

		$removeBtn = $( "#wbdv-remove" );
		$editBtn = $( "#wbdv-edit" );
		$createBtn = $( ".wbdv-create" );

		$userRowTemplate = $( ".wbdv-template.wbdv-user" );
		$tbody = $( ".wbdv-tbody" );

		// $createBtn.onclick = $(createUser);

//       var table = "<table>";
//       	for(var j in scores) {
//       		var row = "<tr>";			var col = "<td>"
//       		col += "scores["+j+"]";	col += "</td>";
//       		row += col;					col = "<td>"
//       		col += scores[j];			col += "</td>";
//       		row += col;					row += "</tr>";
//       		table += row;
//       	}
// 	    table += "</table>"
// document.write(table);
		$createBtn.click(createUser);
	}

	function createUser() {
		console.log( "Create User hit" );

	}


	// function findAllUsers() { … }
    // function findUserById() { … }
    // function deleteUser() { … }
    // function selectUser() { … }
    // function updateUser() { … }
    // function renderUser(user) { … }
	// function renderUsers(users) { … }
} )();
