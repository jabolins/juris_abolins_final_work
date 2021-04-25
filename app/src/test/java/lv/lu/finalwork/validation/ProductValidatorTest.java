package lv.lu.finalwork.validation;

import lv.lu.finalwork.model.ProductValidationException;
import lv.lu.finalwork.model.repository.ProductCategory;
import lv.lu.finalwork.model.ui.ProductInputData;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ProductValidatorTest {

    private ProductValidator validator;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        validator = new ProductValidator();
    }

    @Test
    public void shouldFailWhenNameIsEmpty() {
        ProductInputData inputData = new ProductInputData();
        inputData.setName("");
        inputData.setPrice(2d);
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Field 'name' should not be empty");

        validator.validate(inputData);
    }

    @Test
    public void shouldFailWhenNameIsNull() {
        ProductInputData inputData = new ProductInputData();
        inputData.setName(null);
        inputData.setPrice(2d);
        exception.expect(ProductValidationException.class);
        exception.expectMessage("Field 'name' should not be empty");

        validator.validate(inputData);
    }

    @Test
    public void shouldFalWhenPriceIsNegative() {
        ProductInputData inputData = new ProductInputData();
        inputData.setName("Test");
        inputData.setPrice(-1d);

        exception.expect(ProductValidationException.class);
        exception.expectMessage("Field 'price' should not be negative");

        validator.validate(inputData);
    }

    @Test
    public void shouldFailWhenCategoryInUndefined() {
        ProductInputData inputData = new ProductInputData();
        inputData.setName("Test");
        inputData.setPrice(2d);
        inputData.setCategory("Error");

        exception.expect(ProductValidationException.class);
        exception.expectMessage("Field 'productCategory' is unrecognized");

        validator.validate(inputData);
    }

    @Test
    public void shouldFailWhenDiscountIsNegative() {
        ProductInputData inputData = new ProductInputData();
        inputData.setName("Test");
        inputData.setPrice(2d);
        inputData.setCategory(ProductCategory.CANDY.name());
        inputData.setDiscount(-2d);

        exception.expect(ProductValidationException.class);
        exception.expectMessage("Field 'discount' should not be negative");

        validator.validate(inputData);
    }

}