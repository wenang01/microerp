package com.microerp.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import com.microerp.controller.DataKaryawan;
import com.microerp.entity.Karyawan;
import com.microerp.repository.DataKaryawanRepository;

import org.springframework.stereotype.Service;

@Service
public class ModelDataKaryawan implements ModelDataKaryawanInterface {

    @Autowired
    DataKaryawanRepository dataKaryawanRepository;

    @Override
    public List<Karyawan> getAllKaryawan(){
        return (List<Karyawan>) this.dataKaryawanRepository.findAll();
    }

    @Override
    public Karyawan addKaryawan(Karyawan karyawan) {

        return (Karyawan) this.dataKaryawanRepository.save(karyawan);
    }

    @Override
    public void deleteKaryawan(String id) {

        this.dataKaryawanRepository.deleteById(Long.parseLong(id));
    }

    @Override
    public Karyawan cariKaryawan(Long id) {

        return this.dataKaryawanRepository.findById(id).get();
    }

	public List<Karyawan> getAllFiveHighSalary() {
		return (List<Karyawan>) this.dataKaryawanRepository.findAllKaryawanBySalary();
	}
	
	public List<Karyawan> getAllSameSalary(Double salary) {
		return (List<Karyawan>) this.dataKaryawanRepository.findAllKaryawanBySameSalary(salary);
	}
	
	public List<Object[]> getCountDeartement() {
		return (List<Object[]>) this.dataKaryawanRepository.countDepartment();
	}

}
