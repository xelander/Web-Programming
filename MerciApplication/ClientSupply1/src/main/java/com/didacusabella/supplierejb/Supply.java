package com.didacusabella.supplierejb;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Supply implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @NotNull
  @Column(nullable = false)
  private String name;
  @NotNull
  @Column(nullable = false)
  private String lastName;
  @NotNull
  @Column(nullable = false)
  private String society;
  @NotNull
  @Column(nullable = false)
  private String phone;
  @NotNull
  @Column(nullable = false)
  private Integer maxOrder;
  @NotNull
  @Column(nullable = false)
  private Integer totalOrder;

  public Supply() {
  }

  public Supply(String name, String lastName, String society, String phone, Integer maxOrder) {
    this.name = name;
    this.lastName = lastName;
    this.society = society;
    this.phone = phone;
    this.maxOrder = maxOrder;
    this.totalOrder = 0;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getSociety() {
    return society;
  }

  public void setSociety(String society) {
    this.society = society;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getMaxOrder() {
    return maxOrder;
  }

  public void setMaxOrder(Integer maxOrder) {
    this.maxOrder = maxOrder;
  }

  public Integer getTotalOrder() {
    return totalOrder;
  }

  public void setTotalOrder(Integer totalOrder) {
    this.totalOrder = totalOrder;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Supply)) {
      return false;
    }
    Supply other = (Supply) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName()
            + "[ id:" + this.getId()
            + ", name:" + this.getName()
            + ", lastName:" + this.getLastName()
            + ", society:" + this.getSociety()
            + ", phone:" + this.getPhone()
            + ", maxOrder:" + this.getMaxOrder()
            + ", totalOrder:" + this.getTotalOrder() + "]";
  }

}
