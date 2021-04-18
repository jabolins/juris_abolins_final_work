package lv.lu.finalwork.model;

public class ItemNotFoundExeption extends RuntimeException {
    public ItemNotFoundExeption(String message) {
        super(message);
    }
}
