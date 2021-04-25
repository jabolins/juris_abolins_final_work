package lv.lu.finalwork.service;

import lv.lu.finalwork.model.repository.Product;
import lv.lu.finalwork.model.repository.ProductCategory;
import lv.lu.finalwork.model.ui.ProductData;
import lv.lu.finalwork.model.ui.ProductInputData;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductMapper {
    public ProductData mapFrom(Product product) {
        ProductData productData = new ProductData(product.getId().toString(),
                product.getName(),
                product.getPrice().toPlainString(),
                product.getCategory().name());
        return productData;
    }

    public Product mapFrom(ProductInputData productInputData) { // pielikām public jo savādāk testi šo neredz :(
        Product product = new Product();
        product.setName(productInputData.getName());
        product.setPrice(BigDecimal.valueOf(productInputData.getPrice()));
        product.setCategory(ProductCategory.valueOf(productInputData.getCategory()));

        if (productInputData.getDiscount() != null) {
            product.setDiscount(BigDecimal.valueOf(productInputData.getDiscount()));
        }
        if (productInputData.getDescription() != null) {
            product.setDescription(productInputData.getDescription());
        }
        return product;
    }
}
