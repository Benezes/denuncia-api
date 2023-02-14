package br.com.mnz.hub.denuncias.repository;

import br.com.mnz.hub.denuncias.entity.DenunciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenunciaRepository extends JpaRepository<DenunciaEntity, Long> {
}