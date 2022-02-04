package com.kardex.hulk.store.shopping.infraestructure.in.rest.resources;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductCreateControllerTest {

//    @MockBean
//    private ISaleProductPersistencePort ISaleProductPersistencePort;
//
//    @Autowired
//    private BillCreateController productCreateController;
//
//    @Test
//    void confirmProductRequestSuccess() {
//        var product= findProduct();
//        var requestProduct = createRequestProduct();
//        given(ISaleProductPersistencePort.findByStatusMovii(product.getCodeMovii())).willReturn(null);
//        given(ISaleProductPersistencePort.createBill(product)).willReturn(Boolean.TRUE);
//        ResponseEntity<Object> responseService =  productCreateController.createBillFixed(requestProduct);
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
//            given(ISaleProductPersistencePort.findByCodeMo(product.getCodeMovii())).willReturn(product);
//            productCreateController.createBillFixed(requestProduct);
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
//            given(ISaleProductPersistencePort.findByCodeMo(product.getCodeMovii())).willReturn(null);
//            productCreateController.createBillFixed(requestProduct);
//        } catch (HttpClientErrorException e) {
//            Assertions.assertTrue(Boolean.TRUE);
//        }
//    }
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
//
//    private BillCreateRequest createRequestProduct() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        BillCreateRequest productRequest = null;
//        try {
//            productRequest = objectMapper.readValue(new File("src/test/resources/product_recieve_fixed.json"), BillCreateRequest.class);
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
