package com.ft.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kullanici")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kullanici {

	@Id
    @SequenceGenerator(name = "kullanci_id_sequence", sequenceName = "kullanci_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kullanci_id_sequence")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "ad", length = 50)
	private String ad;
	
	@Column(name = "soyad", length = 50)
	private String soyad;
	
	@Column(name = "email", length = 50)
	private String email;
	
	@Column(name = "telefon", length = 15)
	private String telefon;
	
	@OneToOne(mappedBy = "kullanici")
	private UrunYorum urunYorum;

}
