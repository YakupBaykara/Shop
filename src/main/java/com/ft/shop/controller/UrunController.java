package com.ft.shop.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ft.shop.model.Urun;
import com.ft.shop.repos.UrunRepo;

@RestController
@RequestMapping("/api/urun")
public class UrunController {

	private UrunRepo urunRepo;
	
	@GetMapping
	List<Urun> getAllUrun() {
		LocalDate today = LocalDate.now();
		return urunRepo.findByUrunIdAndExpireDate(today);
	}
	
	@GetMapping("/expired")
	List<Urun> getAllExpired() {
		LocalDate today = LocalDate.now();
		return urunRepo.findExpiredByUrunIdAndExpireDate(today);
	}

}
