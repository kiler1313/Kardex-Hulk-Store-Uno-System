package com.kardex.hulk.store.product.infraestructure.in.rest.resources;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductQueryControllerTest {

//    @MockBean
//    private IProductPersistencePort IProductPersistencePort;
//
//    @Autowired
//    private ProductQueryController productQueryController;
//
//    @Test
//    void confirmProductRequestSuccess() {
//        var product = findProduct();
//        given(IProductPersistencePort.findByStatusMovii(Constants.RECEIVED_MO)).willReturn(product);
//        given(IProductPersistencePort.updateProductSend(product)).willReturn(Boolean.TRUE);
//        ResponseEntity<Object> responseService = productQueryController.queryProducts();
//        GeneralBasicResponse response = (GeneralBasicResponse) responseService.getBody();
//        Assertions.assertEquals(HttpStatus.OK.value(), response.getHttpStatus());
//        Assertions.assertEquals(HttpStatus.OK.value(), response.getCode());
//    }
//
//    @Test
//    void confirmProductRequestDoubleConfirmationFail() {
//        try {
//            given(IProductPersistencePort.findByStatusMovii(Constants.RECEIVED_MO)).willReturn(null);
//            productQueryController.queryProducts();
//        } catch (HttpClientErrorException ex) {
//            Assertions.assertTrue(Boolean.TRUE);
//        }
//    }
//
//
//    private Product findProduct() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Product product = null;
//        try {
//            product = objectMapper.readValue(new File("src/test/resources/product_found.json"), Product.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return product;
//    }
}
