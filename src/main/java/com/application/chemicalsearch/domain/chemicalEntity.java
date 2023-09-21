package com.application.chemicalsearch.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "chemical")
public class chemicalEntity
{
    @Column(name = "chemical_of_interest")
    private String chemicalOfInterest;

    private String synonym;

    @Id
    @NotNull
    private String cas;

    public chemicalEntity() {
    }

    public chemicalEntity(String chemicalOfInterest, String synonym, String cas) {
        this.chemicalOfInterest = chemicalOfInterest;
        this.synonym = synonym;
        this.cas = cas;
    }


    /**
     * get field @Column(name = "chemical of interest")
     *
     * @return chemicalOfInterest @Column(name = "chemical of interest")

     */
    public String getChemicalOfInterest() {
        return this.chemicalOfInterest;
    }

    /**
     * set field @Column(name = "chemical of interest")
     *
     * @param chemicalOfInterest @Column(name = "chemical of interest")

     */
    public void setChemicalOfInterest(String chemicalOfInterest) {
        this.chemicalOfInterest = chemicalOfInterest;
    }

    /**
     * get field
     *
     * @return synonym
     */
    public String getSynonym() {
        return this.synonym;
    }

    /**
     * set field
     *
     * @param synonym
     */
    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    /**
     * get field
     *
     * @return cas
     */
    public String getCas() {
        return this.cas;
    }

    /**
     * set field
     *
     * @param cas
     */
    public void setCas(String cas) {
        this.cas = cas;
    }



    @Override
    public int hashCode() {
        return Objects.hash(chemicalOfInterest, synonym, cas);
    }

    @Override
    public String toString() {
        return "chemicalEntity{" +
            "chemicalOfInterest='" + chemicalOfInterest + '\'' +
            ", synonym='" + synonym + '\'' +
            ", cas='" + cas + '\'' +
            '}';
    }
}
