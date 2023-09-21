package com.application.chemicalsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.application.chemicalsearch.domain.chemicalEntity;
public interface chemicalRepository extends JpaRepository<chemicalEntity, String>
{
    chemicalEntity findByCas(String cas);
}
