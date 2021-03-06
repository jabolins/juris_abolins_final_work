package lv.lu.finalwork.ui;


import lv.lu.finalwork.model.repository.ProductCategory;
import lv.lu.finalwork.model.ui.ProductInputData;
import lv.lu.finalwork.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.Scanner;

@Controller
public class ConsulUi {


    private final  ProductService service; // labāk pielikt final lai reference nemainās
    private final Scanner scanner;

    @Autowired
    public ConsulUi(ProductService service, Scanner scanner) { //labāk veidot ar konstruktoru
        this.service = service;
        this.scanner = scanner;
    }

    public void startUi() {

        int userChoice;
        while (true) {

            printMenu();
            userChoice = scanner.nextInt();

            callServiceByChoice(userChoice);

            if (userChoice == 0) {
                break;
            }
        }
    }

    private void callServiceByChoice(int userChoice) {
        switch (userChoice) {
            case 1:
                initProductSave();
                break;
            case 2:
                retrieveProductList();
                break;
        }
    }

    private void retrieveProductList() {
        service.findAll().stream().forEach(System.out::println); // iesakās maksimāli
        // izmantot stream().forEach- izdarīt ar visiem (ekvivalents Product product : service.findAll())
    }

    private void initProductSave() {
        ProductInputData productInputData = new ProductInputData();

        System.out.println("Enter product name..");
        productInputData.setName(scanner.next());

        System.out.println("Enter product price..");
        productInputData.setPrice(scanner.nextDouble());

        System.out.printf("Enter product category from (%s) \n",
                Arrays.asList(ProductCategory.values()));// tas ir lai dabūtu ārā visus nosaukumus
        productInputData.setCategory(scanner.next());

        service.save(productInputData);
    }

    private void printMenu() {
        System.out.println("===Product Accounting application===");
        System.out.println("Chose one option: \n"); // \n ieliek brīvu rindiņu
        System.out.println("Save product: 1");
        System.out.println("Get list of all products: 2");
        System.out.println("Exit application: 0");
        System.out.println("Please enter the choice");
    }
}
