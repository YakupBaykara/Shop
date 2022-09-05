package com.ft.shop.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ft.shop.model.Urun;

@Repository
public interface UrunRepo extends JpaRepository<Urun, Integer> {

	@Query(value = "SELECT u FROM urun u WHERE u.expire_date >=: today", nativeQuery = true)
	List<Urun> findByUrunIdAndExpireDate(@Param("today") LocalDate today);
	
	@Query(value = "SELECT u FROM urun u WHERE u.expire_date <: today", nativeQuery = true)
	List<Urun> findExpiredByUrunIdAndExpireDate(@Param("today") LocalDate today);

}
