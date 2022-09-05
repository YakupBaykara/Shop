package com.ft.shop.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ft.shop.model.Kullanici;

@Repository
public interface KullaniciRepo extends JpaRepository<Kullanici, Integer>{

}
