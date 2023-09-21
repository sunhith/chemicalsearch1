package com.application.chemicalsearch.service;

import com.application.chemicalsearch.domain.chemicalEntity;
import com.application.chemicalsearch.repository.chemicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChemicalEntityService {
    private final chemicalRepository repository;

    @Autowired
    public ChemicalEntityService(chemicalRepository repository) {
        this.repository = repository;
    }

    public chemicalEntity saveChemicalEntity(chemicalEntity chemicalEntity) {
        return repository.save(chemicalEntity);
    }

    public List<chemicalEntity> getAllChemicalEntities() {
        return repository.findAll();
    }

    public Optional<chemicalEntity> getChemicalEntityById(String cas) {
        return repository.findById(cas);
    }

    public chemicalEntity updateChemicalEntity(String cas, chemicalEntity updatedChemicalEntity) {
        if (repository.existsById(cas)) {
            updatedChemicalEntity.setCas(cas);
            return repository.save(updatedChemicalEntity);
        }
        return null; // Or handle as needed
    }

    public boolean deleteChemicalEntity(String cas) {
        if (repository.existsById(cas)) {
            repository.deleteById(cas);
            return true;
        }
        return false;
    }
}
