package com.guideme.service.apartment.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
  @NamedQuery(name = "Rent.findAll", query = "select o from Rent o")
})
public class Rent implements Serializable {
    @Id
    @Column(name="RENT_ID", nullable = false)
    private Long rentId;
    @OneToMany(mappedBy = "rent")
    private List<Flat> flatList;
    @ManyToOne
    @JoinColumn(name = "RENT_VERSION_ID")
    private RentVersion rentVersion;

    public Rent() {
    }

    public Rent(Long rentId, RentVersion rentVersion) {
        this.rentId = rentId;
        this.rentVersion = rentVersion;
    }

    public Long getRentId() {
        return rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
    }


    public List<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<Flat> flatList) {
        this.flatList = flatList;
    }

    public Flat addFlat(Flat flat) {
        getFlatList().add(flat);
        flat.setRent(this);
        return flat;
    }

    public Flat removeFlat(Flat flat) {
        getFlatList().remove(flat);
        flat.setRent(null);
        return flat;
    }

    public RentVersion getRentVersion() {
        return rentVersion;
    }

    public void setRentVersion(RentVersion rentVersion) {
        this.rentVersion = rentVersion;
    }
}
