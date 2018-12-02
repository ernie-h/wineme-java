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

import com.example.myapp.models.Wine;
import com.example.myapp.repositories.WineRepository;


@RestController
@CrossOrigin(origins = "*", maxAge=3600)
public class WineService {
	@Autowired
	WineRepository wineRepository;

    @GetMapping("/api/wine/personality/{mb}")
    public List<Wine> findPersonalityWines(@PathVariable("mb") String personality) {
        List<Wine> results;
        switch(personality) {
            case "INTJ": 
            results = wineRepository.findINTJ();

            break;
            // case "INTP": 
            // break;
            // case "ENTJ": 
            // break;
            // case "ENTP": 
            // break;
            // case "INFJ": 
            // break;
            // case "INFP": 
            // break;
            // case "ENFJ": 
            // break;
            // case "ENFP": 
            // break;
            // case "ISTJ": 
            // break;
            // case "ISFJ": 
            // break;
            // case "ESTJ": 
            // break;
            // case "ESFJ": 
            // break;
            // case "ISTP": 
            // break;
            // case "ISFP": 
            // break;
            // case "ESTP": 
            // break;
            // case "ESFP": 
            // break;
            default:
            throw new IllegalArgumentException("Not valid personality.");

        }

        return results;

    }
	@PostMapping("/api/wine")
	public Wine createStore(@RequestBody Wine newWine) {
		return wineRepository.save(newWine);
	}

	@DeleteMapping("/api/wine/{wineId}")
	public void deleteStore(@PathVariable("wineId") int id) {
		wineRepository.deleteById(id);
	}

	@PutMapping("/api/wine/{wineId}")
	public Wine updateStore(@PathVariable("wineId") int wineId, @RequestBody Wine newWine) {
		Optional<Wine> data = wineRepository.findById(wineId);
		if(data.isPresent()) {
			Wine wine = data.get();
            wine.setTitle(newWine.getTitle());
            wine.setDescription(newWine.getDescription());
            wine.setVariety(newWine.getVariety());
			wineRepository.save(wine);
			return wine;
		}
		return null;
	}

	@GetMapping("/api/wine")
	public List<Wine> findAllStores() {
		return (List<Wine>) wineRepository.findAll();
	}

	@GetMapping("/api/wine/{wineId}")
	public Wine findStoreById(@PathVariable("wineId") int wineId) {
		Optional<Wine> data = wineRepository.findById(wineId);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}
	//   @GetMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/Wine")
// 	public List<Wine> findAllTopicsForLesson(
// 			@PathVariable("lessonId") int lessonId) {
// 		// Optional<Lesson> data = lessonRepository.findById(lessonId);
// 		if(data.isPresent()) {
// 			Lesson lesson = data.get();
// 			// return lesson.getTopics();
// 		}
// 		return null;
// 	}
}
