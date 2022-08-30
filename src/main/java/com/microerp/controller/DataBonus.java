package com.microerp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microerp.entity.Bonus;
import com.microerp.repository.DataBonusRepository;
import com.microerp.service.ModelDataBonus;

@RestController
@RequestMapping("/bonus")
public class DataBonus {
	
	@Autowired
	ModelDataBonus modelDataBonus;

    @Autowired
    DataBonusRepository dataBonusRepository;

    @GetMapping("/")
    public List<Bonus> indexBonus() {
        return modelDataBonus.getAllBonus();
    }

    @PostMapping("/")
    public ResponseEntity<?> addBonus(@RequestBody Bonus bonus) throws IOException {
		try {
			Bonus addBonus = new Bonus(bonus.getBonusDate(), bonus.getBonusAmount());

			this.modelDataBonus.addBonus(addBonus);
			return new ResponseEntity<>(addBonus, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBonus(@PathVariable("id") Long id, @RequestBody Bonus bonus) {
    	
    	bonus.setId(id);
    	
    	Bonus updateBonus = new Bonus(bonus.getBonusDate(), bonus.getBonusAmount());
    	
    	updateBonus.setId(id);
    	this.modelDataBonus.addBonus(updateBonus);
      
      return ResponseEntity.ok("Bonus update successfully!");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBonus(@PathVariable("id") String id) {
      try {
    	  modelDataBonus.deleteBonus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

}
