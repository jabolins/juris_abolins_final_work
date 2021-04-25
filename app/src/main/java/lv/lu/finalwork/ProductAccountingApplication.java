package lv.lu.finalwork;


import lv.lu.finalwork.config.AppConfiguration;
import lv.lu.finalwork.model.repository.Product;
import lv.lu.finalwork.repository.ProductRepository;
import lv.lu.finalwork.service.ProductMapper;
import lv.lu.finalwork.service.ProductService;
import lv.lu.finalwork.ui.ConsulUi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductAccountingApplication {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class); // pašā sākumā pasakām no kurienes ņemt konfigurāciju



 //       Map<Long, Product> repository = (Map<Long, Product>) context.getBean("repo"); // piemērs kā izsauc ar vārdu. vēlāk kļuva neaktuāls
//        ProductRepository productRepository = context.getBean(ProductRepository.class);
//        ProductMapper productMapper = context.getBean(ProductMapper.class);

//        ProductService service =context.getBean(ProductService.class);
//
//        Scanner scanner = context.getBean(Scanner.class);

        ConsulUi consulUi = context.getBean(ConsulUi.class);
        consulUi.startUi();
    }
}
