package com.example.myapp.services;

import com.example.myapp.models.Wine;
import com.example.myapp.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class WineService {
    @Autowired
    WineRepository wineRepository;

    @GetMapping("/api/wine/personality/{mb}")
    public List<Wine> findPersonalityWines(@PathVariable("mb") String personality) {
        List<Wine> results;
        PageRequest pr = new PageRequest(0, 10);
        switch (personality) {
        case "INTJ":
            results = wineRepository.findINTJ(pr);
            break;
            case "INTP": 
            results = wineRepository.findINTP(pr);
            break;
            case "ENTJ":
            results = wineRepository.findENTJ(pr);
            break;
            case "ENTP": 
            results = wineRepository.findENTP(pr);
            break;
            case "INFJ": 
            results = wineRepository.findINFJ(pr);
            break;
            case "INFP": 
            results = wineRepository.findINFP(pr);
            break;
            case "ENFJ": 
            results = wineRepository.findENFJ(pr);
            break;
            case "ENFP": 
            results = wineRepository.findENFP(pr);
            break;
            case "ISTJ": 
            results = wineRepository.findISTJ(pr);
            break;
            case "ISFJ": 
            results = wineRepository.findISFJ(pr);
            break;
            case "ESTJ": 
            results = wineRepository.findESTJ(pr);
            break;
            case "ESFJ": 
            results = wineRepository.findESFJ(pr);
            break;
            case "ISTP": 
            results = wineRepository.findISTP(pr);
            break;
            case "ISFP": 
            results = wineRepository.findISFP(pr);
            break;
            case "ESTP": 
            results = wineRepository.findESTP(pr);
            break;
            case "ESFP": 
            results = wineRepository.findESFP(pr);
            break;
            default:
            throw new IllegalArgumentException("Not valid personality.");
        }
        return results;
    }

	@PostMapping("/api/wine")
	public Wine createWine(@RequestBody Wine newWine) { return wineRepository.save(newWine); }

	@DeleteMapping("/api/wine/{wineId}")
	public void deleteWine(@PathVariable("wineId") int id) { wineRepository.deleteById(id); }

	@PutMapping("/api/wine/{wineId}")
	public Wine updateWine(@PathVariable("wineId") int wineId, @RequestBody Wine newWine) {
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
	public List<Wine> findAllWines() { return (List<Wine>) wineRepository.findAll(); }

	@GetMapping("/api/wine/{wineId}")
	public Wine findWineById(@PathVariable("wineId") int wineId) { return wineRepository.findById(wineId).orElse(null); }
}
