package com.microerp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microerp.entity.Karyawan;

import java.util.List;
public interface ModelDataKaryawanInterface{
    List<Karyawan> getAllKaryawan();

    public Karyawan addKaryawan(Karyawan karyawan);

    public void deleteKaryawan(String id);

    public Karyawan cariKaryawan(Long id);
}
