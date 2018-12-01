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

import com.example.myapp.models.Store;
import com.example.myapp.repositories.StoreRepository;


@RestController
@CrossOrigin(origins = "*", maxAge=3600)
public class StoreService {
	@Autowired
	StoreRepository storeRepository;

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

	@DeleteMapping("/api/Store/{storeId}")
	public void deleteTopic(@PathVariable("storeId") int id) {
		storeRepository.deleteById(id);
	}

	@GetMapping("/api/Store")
	public List<Store> findAllTopics() {
		return (List<Store>) storeRepository.findAll();
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
	public Store findTopicById(@PathVariable("topicId") int topicId) {
		Optional<Store> data = storeRepository.findById(topicId);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}

	@PutMapping("/api/Store/{topicId}")
	public Store updateTopic(@PathVariable("topicId") int topicId, @RequestBody Store newStore) {
		Optional<Store> data = storeRepository.findById(topicId);
		if(data.isPresent()) {
			Store Store = data.get();
			Store.setName(newStore.getName());
			storeRepository.save(Store);
			return Store;
		}
		return null;
	}
}
