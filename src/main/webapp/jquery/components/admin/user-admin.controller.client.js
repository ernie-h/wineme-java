(function () {
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    $(document).ready(main);

    function main() {
      $usernameFld = $("#usernameFld").val();
      $passwordFld = $("#passwordFld").val();

      $firstNameFld = $("#firstNameFld").val();
      $lastNameFld = $("#lastNameFld").val();

      $removeBtn = $("#wbdv-remove");
      $editBtn = $("#wbdv-edit");
      $createBtn = $("#wbdv-create");

      $userRowTemplate = $('.wbdv-template.wbdv-user');
      $tbody = $(".wbdv-tbody");

    }
    function createUser() { … }
    function findAllUsers() { … }
    function findUserById() { … }
    function deleteUser() { … }
    function selectUser() { … }
    function updateUser() { … }
    function renderUser(user) { … }
    function renderUsers(users) { … }
})();
