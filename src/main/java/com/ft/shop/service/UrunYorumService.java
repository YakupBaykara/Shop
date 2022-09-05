package com.ft.shop.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ft.shop.model.Kullanici;
import com.ft.shop.model.Urun;
import com.ft.shop.model.UrunYorum;
import com.ft.shop.model.UrunYorumDto;
import com.ft.shop.repos.KullaniciRepo;
import com.ft.shop.repos.UrunRepo;
import com.ft.shop.repos.UrunYorumRepo;

@Service
public class UrunYorumService {
	
	private UrunYorumRepo urunYorumRepo;
	private KullaniciRepo kullaniciRepo;
	private UrunRepo urunRepo;
	
	@SuppressWarnings("deprecation")
	public void saveUrunYorumList(List<UrunYorumDto> urunYorumList) {
		for (UrunYorumDto urunYorumDto : urunYorumList) {
			
			Kullanici kullanici = kullaniciRepo.getById(urunYorumDto.getKullaniciId());
			Urun urun = urunRepo.getById(urunYorumDto.getUrunId());
			if(kullanici != null && urun != null) {
				UrunYorum urunYorum = new UrunYorum();
				urunYorum.setYorum(urunYorumDto.getYorum());
				urunYorum.setYorumTarihi(urunYorum.getYorumTarihi());
				urunYorum.setKullanici(kullanici);
				urunYorum.setUrun(urun);
				urunYorumRepo.save(urunYorum);
			}
		}
	}

	public List<UrunYorumDto> getAllUrunYorum(
								  Optional<Integer> kullaniciId, 
								  Optional<Integer> urunId,
								  Optional<LocalDate> ilkTarih,
								  Optional<LocalDate> sonTarih
								  ) {
		
		List<UrunYorum> urunYorum;
		
		if (kullaniciId.isPresent())
			urunYorum = urunYorumRepo.findUrunYorumByKullaniciId(kullaniciId.get());
		
		else if (urunId.isPresent())
			urunYorum = urunYorumRepo.findUrunYorumByUrunId(urunId.get());
		
		else if (kullaniciId.isPresent() && ilkTarih.isPresent() && sonTarih.isPresent())
			urunYorum = urunYorumRepo.findByKullaniciIdAndYorumTarihi(kullaniciId.get(), ilkTarih.get(), sonTarih.get());
		
		else if (urunId.isPresent() && ilkTarih.isPresent() && sonTarih.isPresent())
			urunYorum = urunYorumRepo.findByUrunIdIdAndYorumTarihi(urunId.get(), ilkTarih.get(), sonTarih.get());
		
		else
			urunYorum = urunYorumRepo.findAll();
		
		return urunYorum.stream().map(x -> new UrunYorumDto(x)).collect(Collectors.toList());
	}

}
