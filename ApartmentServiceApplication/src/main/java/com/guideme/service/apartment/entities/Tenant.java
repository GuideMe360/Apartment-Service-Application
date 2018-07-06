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
  @NamedQuery(name = "Tenant.findAll", query = "select o from Tenant o")
})
public class Tenant implements Serializable {
    @Id
    @Column(name="TENANT_ID", nullable = false)
    private Long tenantId;
    @Column(name="TENANT_NAME", nullable = false, length = 40)
    private String tenantName;
    @OneToMany(mappedBy = "tenant")
    private List<Flat> flatList;

    public Tenant() {
    }

    public Tenant(Long tenantId, String tenantName) {
        this.tenantId = tenantId;
        this.tenantName = tenantName;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public List<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<Flat> flatList) {
        this.flatList = flatList;
    }

    public Flat addFlat(Flat flat) {
        getFlatList().add(flat);
        flat.setTenant(this);
        return flat;
    }

    public Flat removeFlat(Flat flat) {
        getFlatList().remove(flat);
        flat.setTenant(null);
        return flat;
    }
}
