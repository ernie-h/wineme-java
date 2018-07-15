function ModuleServiceClient() {
  this.createModule = createModule;
  this.findAllModules = findAllModules;
  this.findModuleById = findModuleById;
  this.deleteModule = deleteModule;
  this.updateModule = updateModule;
  this.url = '/api/module';
  var self = this;

  function createModule(module) {
     return fetch(self.url, {
         method: 'POST',
         body: JSON.stringify(module),
         headers: {
           'content-type': 'application/json'
         }
     });
  }
  function findAllModules(callback) {
     return $.ajax({
         url: self.url,
         success: callback
    });
  }
  function findModuleById(moduleId) {
     return fetch(
        self.url + '/' + moduleId)
        .then(function(response) {
          return response.json();
        });
  }

  function updateModule(moduleId, module) {
     return fetch(self.url + '/' + moduleId, {
         method: 'PUT',
         body: JSON.stringify(module),
         headers: {
           'content-type': 'application/json'
         }
       });
  }

  function deleteModule(moduleId) {
     return fetch(self.url + '/' + moduleId, {
       method: 'DELETE'
     });
  }
}
