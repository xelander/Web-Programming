package com.didacusabella.cdmodule;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author diego POJO Class mapped into Database
 */
@Entity
@NamedQuery(name="FIND-ALL", query="Select cd FROM Cd cd")
public class Cd implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;
  @NotNull
  @Size(max = 100)
  private String author;
  @NotNull
  private Double price;
  @Size(max = 2000)
  private String title;

  public Cd() {
    super();
  }

  public Cd(String id, String author, Double price, String title) {
    this.id = id;
    this.author = author;
    this.price = price;
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 41 * hash + Objects.hashCode(this.id);
    hash = 41 * hash + Objects.hashCode(this.author);
    hash = 41 * hash + Objects.hashCode(this.price);
    hash = 41 * hash + Objects.hashCode(this.title);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj == null)
      return false;
    else if (obj instanceof Cd){
      Cd other = (Cd) obj;
      return other.getPrice().equals(this.getPrice()) &&
              other.getAuthor().equals(this.getAuthor()) &&
              other.getTitle().equals(this.getTitle());
    }
    return false;
  }

  @Override
  public String toString() {
    return "Cd{" + "id=" + id + ", author=" + author + ", price=" + price + ", title=" + title + '}';
  }

}
