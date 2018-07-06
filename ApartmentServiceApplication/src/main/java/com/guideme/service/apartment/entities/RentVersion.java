package com.guideme.service.apartment.entities;

import java.io.Serializable;

import java.sql.Timestamp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
  @NamedQuery(name = "RentVersion.findAll", query = "select o from RentVersion o")
})
@Table(name = "RENT_VERSION")
public class RentVersion implements Serializable {
    @Column(name="EFFECTIVE_DATE")
    private Timestamp effectiveDate;
    @Column(name="END_DATE")
    private Timestamp endDate;
    @Column(name="RENT_AMOUNT")
    private Long rentAmount;
    @Id
    @Column(name="RENT_VERSION_ID", nullable = false)
    private Long rentVersionId;
    @OneToMany(mappedBy = "rentVersion")
    private List<Rent> rentList;

    public RentVersion() {
    }

    public RentVersion(Timestamp effectiveDate, Timestamp endDate, Long rentAmount, Long rentVersionId) {
        this.effectiveDate = effectiveDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.rentVersionId = rentVersionId;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Long getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(Long rentAmount) {
        this.rentAmount = rentAmount;
    }

    public Long getRentVersionId() {
        return rentVersionId;
    }

    public void setRentVersionId(Long rentVersionId) {
        this.rentVersionId = rentVersionId;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    public Rent addRent(Rent rent) {
        getRentList().add(rent);
        rent.setRentVersion(this);
        return rent;
    }

    public Rent removeRent(Rent rent) {
        getRentList().remove(rent);
        rent.setRentVersion(null);
        return rent;
    }
}
