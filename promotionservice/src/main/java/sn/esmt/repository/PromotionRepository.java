package sn.esmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.esmt.entities.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

	Promotion findByCode(String code);
	void deleteByCode(String cod);
}
