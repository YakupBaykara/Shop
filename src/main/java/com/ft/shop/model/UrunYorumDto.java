package com.ft.shop.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UrunYorumDto {

	private Integer id;
	private String yorum;
	private LocalDate yorumTarihi;
	private int kullaniciId;
	private int urunId;
	
	public UrunYorumDto(String yorum, LocalDate yorumTarihi, Integer kullaniciId, Integer urunId) {
		this.yorum = yorum;
		this.yorumTarihi = yorumTarihi;
		this.kullaniciId = kullaniciId;
		this.kullaniciId = urunId;
	}
	
	public UrunYorumDto (UrunYorum urunYorum) {
		this.id = urunYorum.getId();
		this.yorum = urunYorum.getYorum();
		this.yorumTarihi = urunYorum.getYorumTarihi();
		this.kullaniciId = urunYorum.getKullanici().getId();
		this.urunId = urunYorum.getUrun().getId();
	}
}
