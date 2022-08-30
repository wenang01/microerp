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

import com.microerp.entity.Karyawan;
import com.microerp.repository.DataKaryawanRepository;
import com.microerp.service.ModelDataKaryawan;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/karyawan")
public class DataKaryawan {

    @Autowired
    ModelDataKaryawan modelDataKaryawan;

    @Autowired
    DataKaryawanRepository dataKaryawanRepository;

    @GetMapping("/")
    public List<Karyawan> indexKaryawan() {
        return modelDataKaryawan.getAllKaryawan();
    }
    
    @GetMapping("/fivehighsalary")
    public List<Karyawan> getFiveHighSalary() {
        return modelDataKaryawan.getAllFiveHighSalary();
    }
    
    @GetMapping("/samesalary/{salary}")
    public List<Karyawan> getSameSalary(@PathVariable("salary") Double salary) {
        return modelDataKaryawan.getAllSameSalary(salary);
    }
    
    @GetMapping("/countdepartement")
    public List<Object[]> getCountDepartement() {
        return modelDataKaryawan.getCountDeartement();
    }

    @PostMapping("/")
    public ResponseEntity<?> addKaryawan(@RequestBody Karyawan karyawan) throws IOException {
		try {
			Karyawan addKaryawan = new Karyawan(karyawan.getFirstName(), karyawan.getLastName(), karyawan.getSalary(),
					karyawan.getJoiningDate(), karyawan.getDepartement());

			this.modelDataKaryawan.addKaryawan(addKaryawan);
			return new ResponseEntity<>(addKaryawan, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateKaryawan(@PathVariable("id") Long id, @RequestBody Karyawan karyawan) {
    	
    	karyawan.setId(id);
    	
    	Karyawan updateKaryawan = new Karyawan(karyawan.getFirstName(), karyawan.getLastName(), karyawan.getSalary(),
				karyawan.getJoiningDate(), karyawan.getDepartement());
    	
    	updateKaryawan.setId(id);
    	this.modelDataKaryawan.addKaryawan(updateKaryawan);
      
      return ResponseEntity.ok("Karyawan update successfully!");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteKaryawan(@PathVariable("id") String id) {
      try {
    	  modelDataKaryawan.deleteKaryawan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
}