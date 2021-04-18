package lv.lu.finalwork.service;

import lv.lu.finalwork.model.repository.Product;
import lv.lu.finalwork.model.repository.ProductCategory;
import lv.lu.finalwork.model.ui.ProductData;
import lv.lu.finalwork.model.ui.ProductInputData;

import java.math.BigDecimal;

class ProductMapper {
     ProductData mapFrom(Product product) {
        ProductData productData= new ProductData(product.getId().toString(),
                product.getName(),
                product.getPrice().toPlainString(),
                product.getCategory().name());
        return productData;
    }

    Product mapFrom(ProductInputData productInputData) {
        Product product = new Product();
        product.setName( productInputData.getName());
        product.setPrice(BigDecimal.valueOf(productInputData.getPrice()));
        product.setCategory(ProductCategory.valueOf(productInputData.getCategory()));

        if (productInputData.getDiscount()!= null){
            product.setDiscount(BigDecimal.valueOf(productInputData.getDiscount()));
        }
        if (productInputData.getDescription() != null){
            product.setDescription(productInputData.getDescription());
        }
        return product;
    }
}
