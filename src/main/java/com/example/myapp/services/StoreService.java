package com.example.myapp.services;

import com.example.myapp.models.StoreEntity;
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

import com.example.myapp.models.Store;
import com.example.myapp.repositories.StoreRepository;

@RestController
@CrossOrigin(origins = "*", maxAge=3600)
public class StoreService {
	@Autowired
	StoreRepository storeRepository;

	@PostMapping("/api/store")
	public StoreEntity createStore(@RequestBody StoreEntity store) { return storeRepository.save(store); }

	// @PostMapping("/api/store")
	// public Store createStore(
    //   @PathVariable("lessonId") int lessonId,
	// 		@RequestBody Store newTopic) {
	// 	Optional<Lesson> data = lessonRepository.findById(lessonId);
	// 	if(data.isPresent()) {
	// 		Lesson lesson = data.get();
	// 		newTopic.setName(lesson);
	// 		return storeRepository.save(newTopic);
	// 	}
	// 	return null;
	// }

	@DeleteMapping("/api/Store/{topicId}")
	public void deleteTopic(@PathVariable("topicId") int id) {
		storeRepository.deleteById(id);
	}

	@GetMapping("/api/Store")
	public List<StoreEntity> findAllTopics() {
		return (List<StoreEntity>) storeRepository.findAll();
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

	@GetMapping("/api/Store/{topicId}")
	public StoreEntity findTopicById(@PathVariable("topicId") int topicId) {
		Optional<StoreEntity> data = storeRepository.findById(topicId);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}

	@PutMapping("/api/Store/{topicId}")
	public StoreEntity updateTopic(@PathVariable("topicId") int topicId, @RequestBody StoreEntity newStore) {
		Optional<StoreEntity> data = storeRepository.findById(topicId);
		if(data.isPresent()) {
			StoreEntity store = data.get();
			store.setName(newStore.getName());
			storeRepository.save(store);
			return store;
		}
		return null;
	}
}
