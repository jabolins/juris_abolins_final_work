package lv.lu.finalwork.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductServiceTest {

    private ProductService service;

    @Rule
    public ExpectedException exception= ExpectedException.none();

    @Before
    public void setUp() throws Exception{
        service = new ProductService();
    }

    @Test
    public void shouldThrowErrorWhenFindByNull() {
        exception.expect(IllegalArgumentException.class); // šis ir universāls exception kad nepareiza vērtība tiek padota
        exception.expectMessage("Product Id can't be null");

        service.findById(null);
    }
}