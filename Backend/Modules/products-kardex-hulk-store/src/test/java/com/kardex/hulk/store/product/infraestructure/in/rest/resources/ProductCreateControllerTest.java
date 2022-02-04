package com.kardex.hulk.store.product.infraestructure.in.rest.resources;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductCreateControllerTest {

//    @MockBean
//    private IProductPersistencePort IProductPersistencePort;
//
//    @Autowired
//    private ProductCreateController productCreateController;
//
//    @Test
//    void confirmProductRequestSuccess() {
//        var product= findProduct();
//        var requestProduct = createRequestProduct();
//        given(IProductPersistencePort.findByStatusMovii(product.getCodeMovii())).willReturn(null);
//        given(IProductPersistencePort.createProduct(product)).willReturn(Boolean.TRUE);
//        ResponseEntity<Object> responseService =  productCreateController.createProductFixed(requestProduct);
//        GeneralBasicResponse response = (GeneralBasicResponse) responseService.getBody();
//        Assertions.assertEquals(HttpStatus.OK.value(), response.getHttpStatus());
//        Assertions.assertEquals(HttpStatus.OK.value(), response.getCode());
//    }
//
//    @Test
//    void confirmProductRequestDoubleConfirmationFail() {
//        try {
//            var product= findProduct();
//            var requestProduct = createRequestProduct();
//            given(IProductPersistencePort.findByCodeMo(product.getCodeMovii())).willReturn(product);
//            productCreateController.createProductFixed(requestProduct);
//        }catch(HttpClientErrorException ex){
//            Assertions.assertTrue(Boolean.TRUE);
//        }
//    }
//
//    @Test
//    public void confirmProductNotFoundException() {
//        try {
//            var product= findProduct();
//            var requestProduct = createRequestProduct();
//            given(IProductPersistencePort.findByCodeMo(product.getCodeMovii())).willReturn(null);
//            productCreateController.createProductFixed(requestProduct);
//        } catch (HttpClientErrorException e) {
//            Assertions.assertTrue(Boolean.TRUE);
//        }
//    }
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
//
//    private ProductRequest createRequestProduct() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        ProductRequest productRequest = null;
//        try {
//            productRequest = objectMapper.readValue(new File("src/test/resources/product_recieve_fixed.json"), ProductRequest.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return productRequest;
//    }
//
//    private GeneralBasicResponse createGeneralBasicResponse() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        GeneralBasicResponse generalBasicResponse = null;
//        try {
//            generalBasicResponse = objectMapper.readValue(new File("src/test/resources/product_response.json"), GeneralBasicResponse.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return generalBasicResponse;
//    }
}
