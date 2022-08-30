package com.microerp.service;

import java.util.List;

import com.microerp.entity.Bonus;
import com.microerp.entity.Bonus;

public interface ModelDataBonusInterface {
    List<Bonus> getAllBonus();

    public Bonus addBonus(Bonus title);

    public void deleteBonus(String id);

    public Bonus cariBonus(Long id);
}
