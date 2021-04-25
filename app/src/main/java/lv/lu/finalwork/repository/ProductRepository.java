package lv.lu.finalwork.repository;


import lv.lu.finalwork.model.repository.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductRepository implements Repository<Product> {

    private final Map<Long, Product> repository;
    private Long idCounter = 0L;

    @Autowired
    public ProductRepository(Map<Long, Product> repository) {
        this.repository = repository;
    }

    @Override
    public Long save(Product productEntity) {
        productEntity.setId(idCounter);
        repository.put(idCounter, productEntity);
        return idCounter++;
    }

    @Override
    public List<Product> findAll() {

        return new ArrayList<>(repository.values());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(repository.get(1L));
    }

    @Override
    public void delete(Long id) {
        repository.remove(id);
    }
}
