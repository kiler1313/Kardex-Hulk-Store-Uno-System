package com.kardex.hulk.store.shopping.infraestructure.in.rest.resources;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductQueryControllerTest {

//    @MockBean
//    private ISaleProductPersistencePort ISaleProductPersistencePort;
//
//    @Autowired
//    private BillQueryController productQueryController;
//
//    @Test
//    void confirmProductRequestSuccess() {
//        var product = findProduct();
//        given(ISaleProductPersistencePort.findByStatusMovii(Constants.RECEIVED_MO)).willReturn(product);
//        given(ISaleProductPersistencePort.updateProductSend(product)).willReturn(Boolean.TRUE);
//        ResponseEntity<Object> responseService = productQueryController.queryProducts();
//        GeneralBasicResponse response = (GeneralBasicResponse) responseService.getBody();
//        Assertions.assertEquals(HttpStatus.OK.value(), response.getHttpStatus());
//        Assertions.assertEquals(HttpStatus.OK.value(), response.getCode());
//    }
//
//    @Test
//    void confirmProductRequestDoubleConfirmationFail() {
//        try {
//            given(ISaleProductPersistencePort.findByStatusMovii(Constants.RECEIVED_MO)).willReturn(null);
//            productQueryController.queryProducts();
//        } catch (HttpClientErrorException ex) {
//            Assertions.assertTrue(Boolean.TRUE);
//        }
//    }
//
//
//    private ProductDto findProduct() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        ProductDto product = null;
//        try {
//            product = objectMapper.readValue(new File("src/test/resources/product_found.json"), ProductDto.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return product;
//    }
}
