package sn.esmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sn.esmt.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
