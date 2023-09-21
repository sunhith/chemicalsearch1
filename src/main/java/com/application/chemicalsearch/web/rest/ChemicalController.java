package com.application.chemicalsearch.web.rest;

import com.application.chemicalsearch.domain.chemicalEntity;
import com.application.chemicalsearch.service.ChemicalEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chemicals")
public class ChemicalController {
    private final ChemicalEntityService chemicalEntityService;

    @Value("${chemicalservice.title}")
    private String mess;

    @Autowired
    public ChemicalController(ChemicalEntityService chemicalEntityService)
    {
        this.chemicalEntityService = chemicalEntityService;
    }

    @RequestMapping(value = "/service/title", method = RequestMethod.GET)
    public String test(){
        return mess;
    }

    @GetMapping("/{cas}")
    public ResponseEntity<chemicalEntity> getChemicalById(@PathVariable String cas) {
        Optional<chemicalEntity> chemical = chemicalEntityService.getChemicalEntityById(cas);
        return chemical.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public chemicalEntity createChemical(@RequestBody chemicalEntity chemical)
    {
        return chemicalEntityService.saveChemicalEntity(chemical);
    }

    @GetMapping("/list")
    public List<chemicalEntity> getAllChemicals()
    {
        return chemicalEntityService.getAllChemicalEntities();
    }

    @PutMapping("/update/{cas}")
    public ResponseEntity<chemicalEntity> updateChemical(@PathVariable String cas, @RequestBody chemicalEntity updatedChemical) {
        chemicalEntity chemical = chemicalEntityService.updateChemicalEntity(cas, updatedChemical);
        if (chemical != null) {
            return ResponseEntity.ok(chemical);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{cas}")
    public ResponseEntity<Void> deleteChemical(@PathVariable String cas) {
        boolean deleted = chemicalEntityService.deleteChemicalEntity(cas);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/features")
    public ResponseEntity<List<String>> features(){
        List<String> featuresList = Arrays.asList("Export");
        return ResponseEntity.ok(featuresList);
    }
}
