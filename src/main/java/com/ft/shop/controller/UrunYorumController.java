package com.ft.shop.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ft.shop.model.UrunYorumDto;
import com.ft.shop.service.UrunYorumService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/urunyorum")
@RequiredArgsConstructor
public class UrunYorumController {
	
	private final UrunYorumService urunYorumService;

	@GetMapping
	ResponseEntity<List<UrunYorumDto>> getAllUrunYorum(
													@RequestParam Optional<LocalDate> ilkTarih,
													@RequestParam Optional<LocalDate> sonTarih,
													@RequestParam Optional<Integer> kullaniciId, 
													@RequestParam Optional<Integer> urunId
													) {
		return ResponseEntity.ok().body(urunYorumService.getAllUrunYorum(kullaniciId, urunId, ilkTarih, sonTarih));
	}
	
}
