package com.microerp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microerp.entity.Karyawan;

public interface DataKaryawanRepository extends JpaRepository<Karyawan, Long> {

	@Query (value = "select * from karyawan order by salary desc limit 5", nativeQuery = true)
	List<Karyawan> findAllKaryawanBySalary();
	
	@Query (value = "select * from karyawan where salary =:salary", nativeQuery = true)
	List<Karyawan> findAllKaryawanBySameSalary(@Param("salary") Double salary);
	
	@Query (value = "SELECT k.departement, COUNT(*) AS karyawanCount FROM karyawan k GROUP BY k.departement ORDER BY karyawanCount DESC", nativeQuery = true)
	List<Object[]> countDepartment();
	
//	@Query("select new com.microerp.entity.Karyawan(departement, count(*)) from karyawan k group by k.department")
//	List<Object[]> countDepartment();

}
