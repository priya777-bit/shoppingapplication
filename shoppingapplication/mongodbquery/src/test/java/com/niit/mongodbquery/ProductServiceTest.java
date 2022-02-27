//package com.niit.mongodbquery;
//
//import com.niit.mongodbquery.exception.ProductAlreadyExistsException;
//import com.niit.mongodbquery.exception.ProductNotFoundException.ProductNotFoundException;
//import com.niit.mongodbquery.repository.ProductRepository;
//import com.niit.mongodbquery.service.ProductServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//
//    @InjectMocks
//    private ProductServiceImpl productServiceImpl;
//
//    @Mock
//    private ProductRepository productRepository;
//
//    private Product product,product1;
//    private Customer productDescription,productDescription1;
//
//    private List<Product> productList;
//
//    @BeforeEach
//    public void setUp()
//    {
//        productDescription = new Customer("musical-instrument","available",4000);
//        product = new Product(100,"harmonium",productDescription);
//        productDescription1 = new Customer("electric-machine","unavailable",4000);
//        product1 = new Product(200,"washing-machine",productDescription1);
//        productList=Arrays.asList(product,product1);
//    }
//
//    @AfterEach
//    public void tearDown()
//    {
//        product=null;
//        product1=null;
//        productList=null;
//    }
//
//    @Test
//    public void givenProductToSaveReturnProductPositive() throws ProductAlreadyExistsException
//    {
//        when(productRepository.findById(product.getProductCode())).thenReturn(Optional.ofNullable(null));
//        when(productRepository.save(product)).thenReturn(product);
//        assertEquals(product,productServiceImpl.saveDetailsOfTheProduct(product));
//        verify(productRepository,times(1)).findById(product.getProductCode());
//        verify(productRepository,times(1)).save(product);
//    }
//
//    @Test
//    public void givenProductToSaveReturnProductNegative()
//    {
//        when(productRepository.findById(product.getProductCode())).thenReturn(Optional.ofNullable(product));
//        assertThrows(ProductAlreadyExistsException.class,()->productServiceImpl.saveDetailsOfTheProduct(product));
//        verify(productRepository,times(1)).findById(product.getProductCode());
//        verify(productRepository,times(0)).save(product);
//    }
//
//    @Test
//    public void givenProductToUpdateReturnProductPositive() throws ProductNotFoundException
//    {
//        when(productRepository.findById(product.getProductCode())).thenReturn(Optional.ofNullable(product));
////        Product product1 = product;
//        product.getProductDescription().setProductPrice(300);
//        when(productRepository.save(product)).thenReturn(product);
//        assertEquals(product,productServiceImpl.updatePriceOfProduct(product,300));
//        verify(productRepository,times(1)).findById(product.getProductCode());
//        verify(productRepository,times(1)).save(product);
//    }
//
//    @Test
//    public void givenProductToUpdateReturnProductNegative()
//    {
//        when(productRepository.findById(product.getProductCode())).thenReturn(Optional.ofNullable(null));
//        assertThrows(ProductNotFoundException.class,()->productServiceImpl.updatePriceOfProduct(product,product.getProductDescription().getProductPrice()));
//        verify(productRepository,times(1)).findById(product.getProductCode());
//        verify(productRepository,times(0)).save(product);
//    }
//
//    @Test
//    public void givenProductGetProductCodePositive() throws ProductNotFoundException
//    {
//        when(productRepository.findById(product.getProductCode())).thenReturn(Optional.ofNullable(product));
//        when(productRepository.findByProductCode(product.getProductCode())).thenReturn(product);
//        assertEquals(product,productServiceImpl.getProductByProductCode(product.getProductCode()));
//        verify(productRepository,times(1)).findById(product.getProductCode());
//        verify(productRepository,times(1)).findByProductCode(product.getProductCode());
//    }
//
//    @Test
//    public void givenProductGetProductCodeNegative()
//    {
//        when(productRepository.findById(product.getProductCode())).thenReturn(Optional.ofNullable(null));
//        assertThrows(ProductNotFoundException.class,()->productServiceImpl.getProductByProductCode(product.getProductCode()));
//        verify(productRepository,times(1)).findById(product.getProductCode());
//        verify(productRepository,times(0)).findByProductCode(product.getProductCode());
//    }
//
//    @Test
//    public void givenProductToDeleteReturnTruePositive() throws ProductNotFoundException
//    {
//        when(productRepository.findById(product.getProductCode())).thenReturn(Optional.ofNullable(product));
//        doNothing().when(productRepository).deleteById(product.getProductCode());
//        assertEquals(true,productServiceImpl.deleteProductDetails(product.getProductCode()));
//        verify(productRepository,times(1)).findById(product.getProductCode());
//        verify(productRepository,times(1)).deleteById(product.getProductCode());
//    }
//
//    @Test
//    public void givenProductToDeleteReturnFalseNegative()
//    {
//        when(productRepository.findById(product.getProductCode())).thenReturn(Optional.ofNullable(null));
//        assertThrows(ProductNotFoundException.class,()->productServiceImpl.deleteProductDetails(product.getProductCode()));
//        verify(productRepository,times(1)).findById(product.getProductCode());
//        verify(productRepository,times(0)).deleteById(product.getProductCode());
//    }
//
//    @Test
//    public void givenProductsGetAllProductsPositive() throws ProductNotFoundException
//    {
//        when(productRepository.FindAllByProductStatus(productList.get(0).getProductDescription().getProductStatus())).thenReturn(productList);
//        assertEquals(productList,productServiceImpl.getAllProductStatus(product.getProductDescription().getProductStatus()), product1.getProductDescription().getProductStatus());
//        verify(productRepository,times(2)).FindAllByProductStatus(productList.get(0).getProductDescription().getProductStatus());
//    }
//
//    @Test
//    public void givenProductsGetAllProductsNegative()
//    {
//        when(productRepository.FindAllByProductStatus(productList.get(0).getProductDescription().getProductStatus())).thenReturn(null);
//        assertThrows(Exception.class,()->productServiceImpl.getAllProductStatus(product.getProductDescription().getProductStatus()),product1.getProductDescription().getProductStatus());
//        verify(productRepository,times(1)).FindAllByProductStatus(productList.get(0).getProductDescription().getProductStatus());
//    }
//}
