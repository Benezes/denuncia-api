package br.com.mnz.hub.denuncias.repository;

import br.com.mnz.hub.denuncias.entity.DenuncianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenuncianteRepository extends JpaRepository<DenuncianteEntity, Long> {
}