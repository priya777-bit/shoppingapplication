//package com.niit.mongodbquery;
//
//import com.niit.mongodbquery.exception.CustomerNotFoundException;
//import com.niit.mongodbquery.exception.ProductAlreadyExistsException;
//import com.niit.mongodbquery.model.Customer;
//import com.niit.mongodbquery.model.Product;
//import com.niit.mongodbquery.repository.ProductRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class ProductRepositoryTest {
//
//    @Autowired
//    private ProductRepository productRepository;
//    private Product product1,product2;
//    private Customer customer;
//
//    List<Product> productList;
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
//    }
//
//    @AfterEach
//    public void tearDown()
//    {
//        product1=product2=null;
//        customer=null;
//        productRepository.deleteAll();
//    }
//
//    @Test
//    public void givenCustomerToRegisterReturnCustomerPositive()
//    {
//        productRepository.insert(customer);
//        Customer customer1 = productRepository.findById(customer.getCustomerId()).get();
//        assertNotNull(customer1);
//        assertEquals(customer.getCustomerId(),customer1.getCustomerId());
//    }
//
//    @Test
//    public void givenCustomerToRegisterReturnCustomerNegative()
//    {
//        productRepository.insert(customer);
//
//        product1.setProductCode(1);
//        product1.setProductName("table");
//        product1.setProductStock("available");
//        product1.setProductDescription("plastic");
//
//        product2.setProductCode(2);
//        product2.setProductName("harmonium");
//        product2.setProductStock("unavailable");
//        product2.setProductDescription("musical instrument");
//
//        productList = Arrays.asList(product1,product2);
//
//        Customer customer1 = new Customer();
//        customer1.setCustomerId(100);
//        customer1.setCustomerName("praju");
//        customer1.setShippingAddress("pune");
//        customer1.setCustomerEmailId("praju@gmail.com");
//        customer1.setCustomerPassword("praju");
//        customer1.setProductList(productList);
//
//        assertNotNull(customer1);
//        assertNotEquals(customer.getCustomerId(),customer1.getCustomerId());
//    }
//
//    @Test
//    public void givenProductToSaveByCustomerIdReturnCustomerPositive() throws CustomerNotFoundException, ProductAlreadyExistsException
//    {
//        Customer customer1 = productRepository.findByCustomerId(customer.getCustomerId());
//        Product product1 = new Product();
//        Product product2 = new Product();
//
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
//        Customer customer2 = productRepository.save(customer1);
//        productRepository.save(customer2);
//
//        assertNotNull(customer2);
//        assertNotEquals(customer.getProductList(),
//                customer2.getProductList());
//    }
//
//    @Test
//    public void givenProductToSaveByCustomerIdReturnCustomerNegative() throws CustomerNotFoundException
//    {
//        Customer customer1 = productRepository.findByCustomerId(customer.getCustomerId());
//        Product product1 = new Product();
//        Product product2 = new Product();
//
//        product1.setProductCode(101);
//        product1.setProductName("harmonium");
//        product1.setProductStock("available");
//        product1.setProductDescription("wood");
//
//        product2.setProductCode(102);
//        product2.setProductName("table");
//        product2.setProductStock("unavailable");
//        product2.setProductDescription("plastic");
//
//        productList = Arrays.asList(product1,product2);
//
//        customer1.setProductList(productList);
//        productRepository.save(customer1);
//
//        assertNotNull(customer1);
//        assertEquals(customer.getProductList(),customer1.getProductList());
//    }
//
//    @Test
//    public void givenProductToDeleteByCustomerReturnCustomerPositive() throws CustomerNotFoundException
//    {
//        Customer customer1 = productRepository.findById(product1.getProductCode()).get();
//        productRepository.deleteById(product1.getProductCode());
//        assertNull(product1);
//        assertNotEquals(customer.getProductList(),customer1.getProductList());
//    }
//
//    @Test
//    public void givenProductToDeleteByCustomerReturnCustomerNegative()
//    {
//        Product product = null;
//        Customer customer1 = productRepository.findById(product.getProductCode()).get();
//        productRepository.deleteById(product1.getProductCode());
//        assertNull(product1);
//        assertEquals(customer.getProductList(),customer1.getProductList());
//    }
//
//    @Test
//    public void givenCustomerReturnProductsPositive() throws CustomerNotFoundException
//    {
//        Customer customer1 = productRepository.findByCustomerId(customer.getCustomerId());
//        List<Product> productList = productRepository.findAllProductsByCustomerId(customer.getCustomerId());
//        assertNotNull(productList);
//        assertEquals(customer.getProductList(),customer1.getProductList());
//    }
//
//    @Test
//    public void givenProductToDeleteReturnTrueNegative() throws CustomerNotFoundException
//    {
//        Customer customer2 = null;
//        Customer customer1 = productRepository.findByCustomerId(customer2.getCustomerId());
//        List<Product> productList1 = productRepository.findAllProductsByCustomerId(customer1.getCustomerId());
//        assertNotNull(productList);
//        assertNotEquals(customer.getProductList(),customer1.getProductList());
//    }
//
////    @Test
////    public void givenProductGetAllProductsPositive()
////    {
////        productRepository.insert(product);
////        Customer productDescription1 = new Customer("light-product","notavailable",300);
////        Product product1 = new Product(102,"Dryer",productDescription1);
////        productRepository.insert(product1);
////        List<Product> productList = productRepository.findAll();
////        assertNotNull(product);
////        assertNotNull(product1);
////        assertEquals(2,productList.size());
////    }
////
////    @Test
////    public void givenProductGetAllProductsNegative()
////    {
////        productRepository.insert(product);
////        Customer productDescription1 = new Customer("light-product","notavailable",300);
////        Product product1 = new Product(101,"Dryer",productDescription1);
////        productRepository.insert(product1);
////        List<Product> productList = productRepository.findAll();
////        assertNotNull(product);
////        assertNotNull(product1);
////        assertNotEquals(3,productList.size());
////    }
//
//
//}
