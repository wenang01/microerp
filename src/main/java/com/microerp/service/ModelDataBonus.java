package com.microerp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microerp.entity.Bonus;
import com.microerp.repository.DataBonusRepository;

@Service
public class ModelDataBonus implements ModelDataBonusInterface{
	
	@Autowired
	DataBonusRepository dataBonusRepository;

	@Override
	public List<Bonus> getAllBonus() {
		return (List<Bonus>) this.dataBonusRepository.findAll();
	}

	@Override
	public Bonus addBonus(Bonus bonus) {
		return (Bonus) this.dataBonusRepository.save(bonus);
	}

	@Override
	public void deleteBonus(String id) {
		this.dataBonusRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Bonus cariBonus(Long id) {
		return this.dataBonusRepository.findById(id).get();
	}
	

}
