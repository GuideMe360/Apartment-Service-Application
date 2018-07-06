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
  @NamedQuery(name = "Owner.findAll", query = "select o from Owner o")
})
public class Owner implements Serializable {
    @Id
    @Column(name="OWNER_ID", nullable = false)
    private Long ownerId;
    @Column(name="OWNER_NAME", nullable = false, length = 40)
    private String ownerName;
    @OneToMany(mappedBy = "owner")
    private List<Flat> flatList;

    public Owner() {
    }

    public Owner(Long ownerId, String ownerName) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<Flat> flatList) {
        this.flatList = flatList;
    }

    public Flat addFlat(Flat flat) {
        getFlatList().add(flat);
        flat.setOwner(this);
        return flat;
    }

    public Flat removeFlat(Flat flat) {
        getFlatList().remove(flat);
        flat.setOwner(null);
        return flat;
    }
}
