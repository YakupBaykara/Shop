package com.ft.shop.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ft.shop.model.UrunYorum;

@Repository
public interface UrunYorumRepo extends JpaRepository<UrunYorum, Integer> {

	List<UrunYorum> findUrunYorumByKullaniciId(Integer kullaniciId);

	List<UrunYorum> findUrunYorumByUrunId(Integer urunId);

	List<UrunYorum> findUrunYorumByKullaniciIdAndUrunId(Integer kullaniciId, Integer urunId);

	@Query(value = "SELECT uy FROM urunyorum uy WHERE uy.kullanici_id =: kullaniciId AND uy.yorum_tarihi BETWEEN :ilkTarih AND :sonTarih", 
			nativeQuery = true)
	List<UrunYorum> findByKullaniciIdAndYorumTarihi(
								@Param("kullaniciId") Integer kullaniciId, 
								@Param("ilkTarih") LocalDate ilkTarih,
								@Param("sonTarih") LocalDate sonTarih
								);

	@Query(value = "SELECT uy FROM urunyorum uy WHERE uy.urun_id =:urunId AND uy.yorum_tarihi BETWEEN :ilkTarih AND :sonTarih", 
			nativeQuery = true)
	List<UrunYorum> findByUrunIdIdAndYorumTarihi(
								@Param("urunId") Integer urunId, 
								@Param("ilkTarih") LocalDate ilkTarih,
								@Param("sonTarih") LocalDate sonTarih
								);
}
