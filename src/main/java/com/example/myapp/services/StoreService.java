package com.example.myapp.services;

import com.example.myapp.models.Store;
import com.example.myapp.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge=3600)
public class StoreService {
	@Autowired
	StoreRepository storeRepository;

	@PostMapping("/api/store")
	public Store createStore(@RequestBody Store newStore) {
		return storeRepository.save(newStore);
	}

	@DeleteMapping("/api/store/{storeId}")
	public void deleteStore(@PathVariable("storeId") int id) {
		storeRepository.deleteById(id);
	}

	@PutMapping("/api/store/{storeId}")
	public Store updateStore(@PathVariable("storeId") int storeId, @RequestBody Store newStore) {
		Optional<Store> data = storeRepository.findById(storeId);
		if(data.isPresent()) {
			Store store = data.get();
			store.setName(newStore.getName());
			storeRepository.save(store);
			return store;
		}
		return null;
	}

	@GetMapping("/api/store")
	public List<Store> findAllStores() {
		return (List<Store>) storeRepository.findAll();
	}

	@GetMapping("/api/store/{storeId}")
	public Store findStoreById(@PathVariable("storeId") int storeId) {
		Optional<Store> data = storeRepository.findById(storeId);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}
	//   @GetMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/Store")
// 	public List<Store> findAllTopicsForLesson(
// 			@PathVariable("lessonId") int lessonId) {
// 		// Optional<Lesson> data = lessonRepository.findById(lessonId);
// 		if(data.isPresent()) {
// 			Lesson lesson = data.get();
// 			// return lesson.getTopics();
// 		}
// 		return null;
// 	}
}
