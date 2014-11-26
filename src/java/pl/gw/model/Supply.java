/*
 *  Gabinet Weterynaryjny - projekt zaliczeniowy
 */
package pl.gw.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Silwest
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Supply.findAll", query = "SELECT s FROM Supply s ORDER BY s.id ASC"),
    @NamedQuery(name = "Supply.findSupplyByName", query = "SELECT s FROM Supply s WHERE s.name = :supplyName"),
})
public class Supply implements Serializable {

    public static final String FIND_ALL = "Supply.findAll";
    public static final String FIND_BY_NAME = "Supply.findSupplyByName";

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false, length = 32)
    private String name;

    @Column(length = 1024)
    private String description;

    @Column
    private Double price;
    
    @Enumerated(EnumType.STRING)
    @NotNull
    private SupplyType supplyType;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SupplyType getSupplyType() {
        return supplyType;
    }

    public void setSupplyType(SupplyType supplyType) {
        this.supplyType = supplyType;
    }

}
