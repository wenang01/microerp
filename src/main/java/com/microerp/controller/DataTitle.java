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

import com.microerp.entity.Title;
import com.microerp.repository.DataTitleRepository;
import com.microerp.service.ModelDataTitle;

@RestController
@RequestMapping("/title")
public class DataTitle {
	
	@Autowired
	ModelDataTitle modelDataTitle;

    @Autowired
    DataTitleRepository dataTitleRepository;

    @GetMapping("/")
    public List<Title> indexTitle() {
        return modelDataTitle.getAllTitle();
    }

    @PostMapping("/")
    public ResponseEntity<?> addTitle(@RequestBody Title title) throws IOException {
		try {
			Title addTitle = new Title(title.getWorkerTitle(), title.getAffectedFrom());

			this.modelDataTitle.addTitle(addTitle);
			return new ResponseEntity<>(addTitle, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTitle(@PathVariable("id") Long id, @RequestBody Title title) {
    	
    	title.setId(id);
    	
    	Title updateTitle = new Title(title.getWorkerTitle(), title.getAffectedFrom());
    	
    	updateTitle.setId(id);
    	this.modelDataTitle.addTitle(updateTitle);
      
      return ResponseEntity.ok("Title update successfully!");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTitle(@PathVariable("id") String id) {
      try {
    	  modelDataTitle.deleteTitle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

}
