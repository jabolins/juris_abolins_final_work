package lv.lu.finalwork.service;


import lv.lu.finalwork.model.ItemNotFoundExeption;
import lv.lu.finalwork.model.repository.Product;
import lv.lu.finalwork.model.ui.ProductData;
import lv.lu.finalwork.model.ui.ProductInputData;
import lv.lu.finalwork.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Autowired
    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void save(ProductInputData productInputData) {
//        Product product = mapper.mapFrom(productInputData); // šis ir ekvivalents zemāk esošam kodam. Atstāju pārskatāmības dēļ
//        repository.save(product);
        repository.save(mapper.mapFrom(productInputData));
    }

    public List<ProductData> findAll() {
//        List<ProductData> result = new ArrayList<>(); šī ir vesija kas dara to pašu tikai ar citu paņēmienu
//        for (Product product : repository.findAll()) {
//            ProductData productData = mapper.mapFrom(product);
//            result.add(productData);
//
//        }
//        return result;
        return repository.findAll().stream().map(mapper::mapFrom).collect(Collectors.toList()); //collect nodrošina rezultātu saglabāšanu sarakstā.
        // Šo līdz galam nesparatu. Vēlāk vajadzēs vēl pamēģināt

        // .map(product -> mapper.mapFrom(product));
        //tas ir ekvivalents iepriekšējam izmantojot stream. Viņam ir iebūvēta iespēja map kas nodrošina
        //pārvaiedošanu.
    }

    public Product findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Product Id can't be null");
        }

        Optional<Product> result = repository.findById(id);
        if (!result.isPresent()) {
            throw new ItemNotFoundExeption(String.format("Product by id: %d is not found", id)); //%d ir cipariem, %s ir tekstam
        }
        return result.get();
    }


    public void delete(Long id) {

    }
}
