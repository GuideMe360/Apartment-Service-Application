package com.guideme.service.apartment.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
  @NamedQuery(name = "Flat.findAll", query = "select o from Flat o")
})
public class Flat implements Serializable {
    @Id
    @Column(name="FLAT_ID", nullable = false)
    private Long flatId;
    @Column(name="FLAT_NAME", length = 20)
    private String flatName;
    @ManyToOne
    @JoinColumn(name = "TENANT_ID")
    private Tenant tenant;
    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "RENT_ID")
    private Rent rent;
    @ManyToOne
    @JoinColumn(name = "APART_NO")
    private Apartment apartment;

    public Flat() {
    }

    public Flat(Apartment apartment, Long flatId, String flatName, Owner owner, Rent rent, Tenant tenant) {
        this.apartment = apartment;
        this.flatId = flatId;
        this.flatName = flatName;
        this.owner = owner;
        this.rent = rent;
        this.tenant = tenant;
    }


    public Long getFlatId() {
        return flatId;
    }

    public void setFlatId(Long flatId) {
        this.flatId = flatId;
    }

    public String getFlatName() {
        return flatName;
    }

    public void setFlatName(String flatName) {
        this.flatName = flatName;
    }


    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
