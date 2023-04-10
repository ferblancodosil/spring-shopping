package eu.argalladas.shopping.repository.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PriceLists")
public class PriceList implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long priceId;

    @Column(name = "name")
    private String name;

    public PriceList(){}

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
