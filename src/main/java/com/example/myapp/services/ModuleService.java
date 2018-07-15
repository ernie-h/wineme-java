package com.example.myapp.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.Module;
import com.example.myapp.repositories.ModuleRepository;


@RestController
@CrossOrigin(origins = "*", maxAge=3600)
public class ModuleService {
	@Autowired
	ModuleRepository moduleRepository;

	@PostMapping("/api/module")
	public Module createModule(@RequestBody Module module) {
		return moduleRepository.save(module);
	}

	@DeleteMapping("/api/module/{moduleId}")
	public void deleteModule(@PathVariable("moduleId") int id) {
		moduleRepository.deleteById(id);;
	}

	@GetMapping("/api/module")
	public List<Module> findAllModules() {
		return (List<Module>) moduleRepository.findAll();
	}

	@GetMapping("/api/module/{moduleId}")
	public Module findModuleById(@PathVariable("moduleId") int moduleId) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}

//	@PutMapping("/api/module/{moduleId}")
//	public Module updateModule(@PathVariable("moduleId") int moduleId, @RequestBody Module newModule) {
//		Optional<Module> data = moduleRepository.findById(moduleId);
//		if(data.isPresent()) {
//			Module module = data.get();
//			module.setTitle(newModule.getTitle());
//			module.setCreated(newModule.getCreated());
//			module.setModified(newModule.getModified());
//			moduleRepository.save(module);
//			return module;
//		}
//		return null;
//	}
}
