package lv.lu.finalwork.model;

public class ProductValidationException extends RuntimeException{
    public ProductValidationException(String message) {
        super(message);
    }
}
