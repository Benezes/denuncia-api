package br.com.mnz.hub.denuncias.repository;

import br.com.mnz.hub.denuncias.entity.DenunciaDetalheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenunciaDetalheRepository extends JpaRepository<DenunciaDetalheEntity, Long> {
}