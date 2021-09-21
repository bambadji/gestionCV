package sn.b2.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sn.b2.entities.Etablissement;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
	
	Page<Etablissement> findByLibelleContaining(String libelle, Pageable pageable);

}
