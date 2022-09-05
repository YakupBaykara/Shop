package com.ft.shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ft.shop.model.Kullanici;
import com.ft.shop.model.Urun;
import com.ft.shop.model.UrunYorumDto;
import com.ft.shop.repos.KullaniciRepo;
import com.ft.shop.repos.UrunRepo;
import com.ft.shop.repos.UrunYorumRepo;
import com.ft.shop.service.UrunYorumService;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Bean
	CommandLineRunner run(
			KullaniciRepo kullaniciRepo, 
			UrunRepo urunRepo, 
			UrunYorumService urunYorumService,
			UrunYorumRepo urunYorumRepo
			) {
		
		return args -> {
			
			// Kullanıcı listesi oluşturma
			Long count = kullaniciRepo.count();
			if (count == 0L) {
				List<Kullanici> kullaniciList = new ArrayList<>();
				for (int i = 1; i < 10; i++) {
					kullaniciList.add(
							Kullanici.builder()
								.ad("Ad" +i)
								.soyad("Soyad"+i)
								.email("Ad" +i+ "@gmail.com")
								.telefon("05XX XXX XX X"+i)
								.build());
				}
				kullaniciRepo.saveAll(kullaniciList);
			}
			
			// Ürün listesi oluşturma
			Long count2 = urunRepo.count();
			if (count2 == 0L) {
				List<Urun> urunList = Arrays.asList(
						new Urun("Peynir", 75.00, LocalDate.of(2022, 9, 2)),
						new Urun("Zeytin", 50.00, LocalDate.of(2022, 9, 2)),
						new Urun("Deterjan", 50.00, LocalDate.of(2021, 9, 2))
				);
				urunRepo.saveAll(urunList);
			}
			
			// ÜrünYorum listesi oluşturma
			Long count3 = urunYorumRepo.count();
			if (count3 == 0L) {
				List<UrunYorumDto> urunYorumList = Arrays.asList(
						new UrunYorumDto("comment1", LocalDate.of(2022, 9, 2), 1, 1),
						new UrunYorumDto("comment1", LocalDate.of(2022, 9, 2), 1, 1)
				);
				urunYorumService.saveUrunYorumList(urunYorumList);
			}
		};
	}
}
