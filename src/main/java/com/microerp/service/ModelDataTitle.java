package com.microerp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microerp.entity.Title;
import com.microerp.repository.DataTitleRepository;

@Service
public class ModelDataTitle implements ModelDataTitleInterface{
	
	@Autowired
	DataTitleRepository dataTitleRepository;

	@Override
	public List<Title> getAllTitle() {
		return (List<Title>) this.dataTitleRepository.findAll();
	}

	@Override
	public Title addTitle(Title title) {
		return (Title) this.dataTitleRepository.save(title);
	}

	@Override
	public void deleteTitle(String id) {
		this.dataTitleRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Title cariTitle(Long id) {
		return this.dataTitleRepository.findById(id).get();
	}
	

}
