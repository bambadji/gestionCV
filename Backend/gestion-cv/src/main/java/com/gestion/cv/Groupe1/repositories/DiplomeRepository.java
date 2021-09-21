package sn.b2.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sn.b2.entities.Diplome;

public interface DiplomeRepository extends JpaRepository<Diplome, Long> {
	
	Page<Diplome> findByDescriptionContaining(String libelle, Pageable pageable);

}
