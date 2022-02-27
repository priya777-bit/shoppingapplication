//package com.niit.mongodbquery;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.niit.mongodbquery.controller.ProductController;
//import com.niit.mongodbquery.exception.CustomerNotFoundException;
//import com.niit.mongodbquery.exception.NoProductsFoundException;
//import com.niit.mongodbquery.exception.ProductAlreadyExistsException;
//import com.niit.mongodbquery.exception.ProductNotFoundException;
//import com.niit.mongodbquery.model.Customer;
//import com.niit.mongodbquery.model.Product;
//import com.niit.mongodbquery.service.ProductService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@ExtendWith(MockitoExtension.class)
//public class ProductControllerTest {
//    @InjectMocks
//    private ProductController productController;
//    @Mock
//    private ProductService productService;
//
//    private Product product1,product2;
//    private Customer customer;
//
//    private List<Product> productList;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    public void setUp()
//    {
//        product1.setProductCode(101);
//        product1.setProductName("table");
//        product1.setProductStock("available");
//        product1.setProductDescription("plastic");
//
//        product2.setProductCode(102);
//        product2.setProductName("harmonium");
//        product2.setProductStock("unavailable");
//        product2.setProductDescription("musical instrument");
//
//        productList = Arrays.asList(product1,product2);
//
//        customer.setCustomerId(1000);
//        customer.setCustomerName("priya");
//        customer.setShippingAddress("nashik");
//        customer.setCustomerEmailId("priya@gmail.com");
//        customer.setCustomerPassword("priya");
//        customer.setProductList(productList);
//
//        mockMvc=MockMvcBuilders.standaloneSetup(productController).build();
//    }
//
//    @AfterEach
//    public void tearDown()
//    {
//        product1=product2=null;
//        customer=null;
//    }
//
//    @Test
//    public void givenCustomerToRegisterReturnCustomerPositive() throws Exception
//    {
//        when(productService.registerNewCustomer(any())).thenReturn(customer);
//        mockMvc.perform(post("/api/v1/customer/productregister")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonToString(customer)))
//                .andExpect(status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//        verify(productService,times(1)).registerNewCustomer(any());
//
//    }
//
//    @Test
//    public void givenCustomerToRegisterReturnCustomerNegative() throws Exception
//    {
//        when(productService.registerNewCustomer(any())).thenThrow(ProductAlreadyExistsException.class, CustomerNotFoundException.class);
//        mockMvc.perform(post("/api/v1/customer/productregister")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonToString(customer)))
//                .andExpect(status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//        verify(productService,times(1)).registerNewCustomer(any());
//    }
//
//    @Test
//    public void givenProductToSaveReturnCustomerPositive() throws Exception
//    {
//        when(productService.saveCustomerProduct(any(),anyInt())).thenReturn(customer);
//        mockMvc.perform(put("/api/v1/customer/product/1000")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonToString(customer)))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//        verify(productService,times(1)).saveCustomerProduct(any(),anyInt());
//    }
//
//    @Test
//    public void givenProductToSaveReturnCustomerNegative() throws Exception
//    {
//        when(productService.saveCustomerProduct(any(),anyInt())).thenThrow(CustomerNotFoundException.class,ProductAlreadyExistsException.class);
//        mockMvc.perform(put("/api/v1/customer/product/1000")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonToString(customer)))
//                .andExpect(status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//        verify(productService,times(1)).saveCustomerProduct(any(),anyInt());
//    }
//
//    @Test
//    public void givenCustomerIdReturnAllProductsPositive() throws Exception
//    {
//        when(productService.getAllProductsOfACustomer(anyInt())).thenReturn(productList);
//        mockMvc.perform(get("/api/v1/customer/product/1000")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//        verify(productService,times(1)).getAllProductsOfACustomer(anyInt());
//    }
//
//    @Test
//    public void givenCustomerIdReturnAllProductsNegative() throws Exception
//    {
//        when(productService.getAllProductsOfACustomer(anyInt())).thenThrow(NoProductsFoundException.class,CustomerNotFoundException.class);
//        mockMvc.perform(get("/api/v1/customer/product/1000")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//        verify(productService,times(1)).getAllProductsOfACustomer(anyInt());
//    }
//
//    @Test
//    public void givenCustomerIdDeleteProductReturnCustomerPositive() throws Exception
//    {
//        when(productService.deleteProductOfACustomer(anyInt(),anyInt())).thenReturn(customer);
//        mockMvc.perform(delete("/api/v1/customer/101/1000")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//        verify(productService,times(1)).deleteProductOfACustomer(anyInt(),anyInt());
//    }
//
//    @Test
//    public void givenCustomerIdDeleteProductReturnCustomerNegative() throws Exception
//    {
//        when(productService.deleteProductOfACustomer(anyInt(),anyInt())).thenThrow(ProductNotFoundException.class,CustomerNotFoundException.class);
//        mockMvc.perform(delete("/api/v1/customer/101/1000")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//        verify(productService,times(1)).deleteProductOfACustomer(anyInt(),anyInt());
//    }
//
////    @Test
////    public void givenProductStatusReturnProductsPositive() throws Exception
////    {
////        when(productService.getAllProductStatus(any())).thenReturn(productList);
////        mockMvc.perform(get("/api/v1/product/product/available")
////                .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andDo(MockMvcResultHandlers.print());
////        verify(productService,times(1)).getAllProductStatus(any());
////    }
////
////    @Test
////    public void givenProductStatusReturnProductNegative() throws Exception
////    {
////        when(productService.getAllProductStatus(any())).thenThrow(ProductNotFoundException.class);
////        mockMvc.perform(get("/api/v1/product/product/available")
////                .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isNotFound())
////                .andDo(MockMvcResultHandlers.print());
////        verify(productService,times(1)).getAllProductStatus(any());
////    }
//
//    private static String jsonToString(final Object object) throws JsonProcessingException
//    {
//        String text = null;
//        try
//        {
//            ObjectMapper objectMapper = new ObjectMapper();
//            String jsonText=objectMapper.writeValueAsString(object);
//            text = jsonText;
//        }
//        catch (JsonProcessingException je)
//        {
//            text = "Caught Error During Conversion Of Format";
//        }
//        return text;
//
//    }
//
//}
