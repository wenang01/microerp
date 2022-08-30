package com.microerp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microerp.entity.Title;

public interface DataTitleRepository extends JpaRepository<Title, Long>{

}
