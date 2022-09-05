package com.ft.shop.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "urun")
@Data
public class Urun {

	@Id
    @SequenceGenerator(name = "urun_sequence", sequenceName = "urun_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urun_sequence")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "ad")
	private String ad;
	
	@Column(name = "fiyat")
	private Double fiyat;
	
	@Column(name = "expire_date", nullable = true)
	private LocalDate expireDate;
	
	@OneToOne(mappedBy = "urun")
	private UrunYorum urunYorum;

	public Urun(String ad, Double fiyat, LocalDate expireDate) {
		this.ad = ad;
		this.fiyat = fiyat;
		this.expireDate = expireDate;
	}
	
	
}
