package lv.lu.finalwork.model.repository;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private ProductCategory category;

    private BigDecimal discount;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product productInputData = (Product) o;
        return Objects.equals(id, productInputData.id)
                && Objects.equals(name, productInputData.name)
                && Objects.equals(price, productInputData.price)
                && category == productInputData.category
                && Objects.equals(discount, productInputData.discount)
                && Objects.equals(description, productInputData.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, discount, description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
