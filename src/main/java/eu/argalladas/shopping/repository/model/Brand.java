package eu.argalladas.shopping.repository.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Brands")
public class Brand implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true)
    private Long brandId;

    @Column(name = "name")
    private String name;

    public Brand(){}

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
