package lv.lu.finalwork.validation;

import lv.lu.finalwork.model.ProductValidationException;
import lv.lu.finalwork.model.repository.ProductCategory;
import lv.lu.finalwork.model.ui.ProductInputData;
import org.springframework.util.StringUtils;

public class ProductValidator {
    public void validate(ProductInputData productInputData) {

        if (!StringUtils.hasLength(productInputData.getName())) { // pārbauda vai string ir garāks par 0
            throw new ProductValidationException("Field 'name' should not be empty");

        }
        if (productInputData.getPrice() < 0) {
            throw new ProductValidationException("Field 'price' should not be negative");
        }

        try{ProductCategory.valueOf(productInputData.getCategory()); // mēģinām izgūt no ProductCategory konkŗēto
            // kategoriju ar mūsu iedoto vērtību. Un ja tas nebūs iespējams tad parādīsies exceptieon
        } catch (IllegalArgumentException ex){
            throw new ProductValidationException("Field 'productCategory' is unrecognized"); // tā darām lai varm atpazīt konkrēto savu izveidoto
            // exception nevis parādīsies kaut kāda vispārējā Illegal argument excepteion
        }

        if (productInputData.getDiscount() < 0) {
            throw new ProductValidationException("Field 'discount' should not be negative");
        }
    }
}
