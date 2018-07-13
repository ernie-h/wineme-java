/*eslint-disable camelcase*/
function User(username, password, first_name, last_name, email, phone, date_of_birth, role) {
	this.username = username;
	this.password = password;
	this.first_name = first_name;
	this.last_name = last_name;
	this.email = email;
	this.phone = phone;
	this.role = role;
	this.date_of_birth = date_of_birth;

	this.setUsername = setUsername;
	this.getUsername = getUsername;
	this.setPassword = setPassword;
	this.getPassword = getPassword;
	this.setFirstName = setFirstName;
	this.getFirstName = getFirstName;
	this.setLastName = setLastName;
	this.getLastName = getLastName;
	this.setEmail = setEmail;
	this.getEmail = getEmail;
	this.setPhone = setPhone;
	this.getPhone = getPhone;
	this.setRole = setRole;
	this.getRole = getRole;
	this.setDateOfBirth = setDateOfBirth;
	this.getDateOfBirth = getDateOfBirth;

	function setUsername(username) {
		this.username = username;
	}
	function getUsername() {
		return this.username;
	}
	function setPassword(password) {
		this.password = password;
	}
	function getPassword() {
		return this.password;
	}
	function setFirstName(first_name) {
		this.first_name = first_name;
	}
	function getFirstName() {
		return this.first_name;
	}
	function setLastName(last_name) {
		this.last_name = last_name;
	}
	function getLastName() {
		return this.lastName;
	}
	function setEmail(email) {
		this.email = email;
	}
	function getEmail() {
		return this.email;
	}
	function setPhone(phone) {
		this.phone = phone;
	}
	function getPhone() {
		return this.phone;
	}
	function setRole(role) {
		this.role = role;
	}
	function getRole() {
		return this.role;
	}
	function setDateOfBirth(date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	function getDateOfBirth() {
		return this.date_of_birth;
	}
}
