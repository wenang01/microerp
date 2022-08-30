package com.microerp.service;

import java.util.List;

import com.microerp.entity.Title;

public interface ModelDataTitleInterface {
    List<Title> getAllTitle();

    public Title addTitle(Title title);

    public void deleteTitle(String id);

    public Title cariTitle(Long id);
}
