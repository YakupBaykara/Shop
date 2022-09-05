package com.ft.shop.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "urun_yorum")
@Data
@NoArgsConstructor
public class UrunYorum {

	@Id
    @SequenceGenerator(name = "urun_yorum_sequence", sequenceName = "urun_yorum_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urun_yorum_sequence")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "yorum", length = 500)
	private String yorum;
	
	@Column(name = "yorum_tarihi")
	private LocalDate yorumTarihi;
	
	@OneToOne
	@JoinColumn(name = "kullaniciId")
	private Kullanici kullanici;
	
	@OneToOne
	@JoinColumn(name = "urunId")
	private Urun urun;

	public UrunYorum(String yorum, LocalDate yorumTarihi, Kullanici kullanici, Urun urun) {
		this.yorum = yorum;
		this.yorumTarihi = yorumTarihi;
		this.kullanici = kullanici;
		this.urun = urun;
	}
	
}
