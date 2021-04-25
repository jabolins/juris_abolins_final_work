package lv.lu.finalwork.service;

import lv.lu.finalwork.model.repository.Product;
import lv.lu.finalwork.model.ui.ProductInputData;
import lv.lu.finalwork.repository.ProductRepository;
import lv.lu.finalwork.validation.ProductValidator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)

public class ProductServiceTest {
    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;
    @Mock
    private ProductMapper mapper;
    @Mock
    private ProductValidator validator;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldStoreProduct() {
        ProductInputData inputData = new ProductInputData();
        Product product = new Product();
        given(mapper.mapFrom(Mockito.any(ProductInputData.class))).willReturn(product); // kad izsauks mapper.mapFrom
        // ar jebkādiem paramentriem, šī metode vienmēr atgriezīs product
        service.save(inputData);

        InOrder inOrder = Mockito.inOrder(mapper,repository,validator); // šis objekts var pārbaudīt kārtību kādā tika izsauktas metodes
//        Mockito.verify(repository).save(Mockito.any()); // verify pārbauda vai tika izsaukta metode. Šo jāpamācās vairāk
//        // parametrs any norāda ka viņam ir vienalga kas tur padots. Galvenais ka tur kaut kas bija (tai skaitā null)
//
//        Mockito.verify(repository).save(Mockito.any(Product.class)); // šajā gadījumā pārliecinās
//        // ka saglabās kaut kādu Product.class (nevis null)

        inOrder.verify(validator).validate(inputData);// pārbauda vai bija izsaukums validator.validatate(inputData)
        inOrder.verify(mapper).mapFrom(inputData);
        inOrder.verify(repository).save(product); // šajā gadījumā pārliecinās
        // ka saglabās konkrēto product


        verifyNoMoreInteractions(mapper, repository, validator);// pārbauda ka pēc iepriekšējo darbību veikšanas
// ar mappar vai repository, vai validator vairs netiek veiktas nekādas darbības
    }

    @Test
    public void shouldStoreProductV2() {
        ProductInputData inputData = new ProductInputData();
        Product product = new Product();
        given(mapper.mapFrom(inputData)).willReturn(product); // kad izsauks mapper.mapFrom
        // ar konkrētu izveidoto inputData, šī metode vienmēr atgriezīs product (to ka izveidots)
        service.save(inputData);

        Mockito.verify(repository).save(Mockito.any()); // verify pārbauda vai tika izsaukta metode. Šo jāpamācās vairāk
        // parametrs any norāda ka viņam ir vienalga kas tur padots. Galvenais ka tur kaut kas bija (tai skaitā null)

        Mockito.verify(repository).save(Mockito.any(Product.class)); // šajā gadījumā pārliecinās
        // ka saglabās kaut kādu Product.class (nevis null)

        Mockito.verify(repository).save(product); // šajā gadījumā pārliecinās
        // ka saglabās konkrēto product

        verify(mapper).mapFrom(inputData);

        verifyNoMoreInteractions(mapper, repository);// pārbauda ka pēc iepriekšējo darbību veikšanas
// ar mappar vai repository vairs netiek veiktas nekādas darbības. Obligāti (!!!) pirms tam jāveic
// darbības ar šiem abiem objektiem (mapper un repository) kā mūsu piemērā.
// Jo ja nebūs veiktas ar abiem, būs kļūda
    }

    @Test
    public void shouldThrowErrorWhenFindByNull() {
        exception.expect(IllegalArgumentException.class); // šis ir universāls exception kad nepareiza vērtība tiek padota
        exception.expectMessage("Product Id can't be null");

        service.findById(null);
    }
}