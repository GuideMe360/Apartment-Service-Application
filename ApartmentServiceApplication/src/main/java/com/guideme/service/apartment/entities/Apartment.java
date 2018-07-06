package com.guideme.service.apartment.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
  @NamedQuery(name = "Apartment.findAll", query = "select o from Apartment o")
})
public class Apartment implements Serializable {
    @Column(name="APART_DESC", length = 100)
    private String apartDesc;
    @Column(name="APART_NAME", nullable = false, length = 40)
    private String apartName;
    @Id
    @Column(name="APART_NO", nullable = false)
    private Long apartNo;
    @OneToMany(mappedBy = "apartment")
    private List<Flat> flatList;

    public Apartment() {
    }

    public Apartment(String apartDesc, String apartName, Long apartNo) {
        this.apartDesc = apartDesc;
        this.apartName = apartName;
        this.apartNo = apartNo;
    }

    public String getApartDesc() {
        return apartDesc;
    }

    public void setApartDesc(String apartDesc) {
        this.apartDesc = apartDesc;
    }

    public String getApartName() {
        return apartName;
    }

    public void setApartName(String apartName) {
        this.apartName = apartName;
    }

    public Long getApartNo() {
        return apartNo;
    }

    public void setApartNo(Long apartNo) {
        this.apartNo = apartNo;
    }

    public List<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<Flat> flatList) {
        this.flatList = flatList;
    }

    public Flat addFlat(Flat flat) {
        getFlatList().add(flat);
        flat.setApartment(this);
        return flat;
    }

    public Flat removeFlat(Flat flat) {
        getFlatList().remove(flat);
        flat.setApartment(null);
        return flat;
    }
}
