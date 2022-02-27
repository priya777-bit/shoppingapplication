package com.niit.mongodbquery.service;

import com.niit.mongodbquery.exception.*;
import com.niit.mongodbquery.model.Customer;
import com.niit.mongodbquery.model.Product;
import com.niit.mongodbquery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }

    @Override
    public Customer registerNewCustomer(Customer customer) throws CustomerAlreadyExistsException {
        if(productRepository.findById(customer.getCustomerId()).isPresent())
        {
            throw new CustomerAlreadyExistsException();
        }
        return productRepository.save(customer);
    }

    @Override
    public Customer saveCustomerProduct(Product product, int customerId) throws CustomerNotFoundException, ProductAlreadyExistsException{
        if(productRepository.findById(product.getProductCode()).isEmpty())
        {
            throw new ProductAlreadyExistsException();
        }
        else if(productRepository.findById(customerId).isEmpty())
        {
            throw new CustomerNotFoundException();
        }
        Customer customer = new Customer();
        customer.setProductList(customer.getProductList());
        return productRepository.save(customer);
    }

    @Override
    public Customer deleteProductOfACustomer(int productCode, int customerId) throws ProductNotFoundException,CustomerNotFoundException {
        if(productRepository.findById(productCode).isEmpty())
        {
            throw new ProductNotFoundException();
        }
        else if(productRepository.findById(customerId).isEmpty())
        {
            throw new CustomerNotFoundException();
        }
        productRepository.deleteById(productCode);
        return productRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Product> getAllProductsOfACustomer(int customerId) throws CustomerNotFoundException, NoProductsFoundException {
        if(productRepository.findById(customerId).isEmpty())
        {
            throw new CustomerNotFoundException();
        }
        List<Product> productList = productRepository.findAllProductsByCustomerId(customerId);
        if(productList.isEmpty())
        {
            throw new NoProductsFoundException();
        }
        return productRepository.findAllProducts(productList);
    }
//    @Override
//    public Product saveDetailsOfTheProduct(Product product) throws ProductAlreadyExistsException {
//        if(productRepository.findById(product.getProductCode()).isPresent())
//        {
//            throw new ProductAlreadyExistsException();
//        }
//        return productRepository.save(product);
//    }
//
//    @Override
//    public Product updatePriceOfProduct(Product product,int productPrice) throws ProductNotFoundException {
//        if(productRepository.findById(product.getProductCode()).isEmpty())
//        {
//            throw new ProductNotFoundException();
//        }
//        product.getProductDescription().setProductPrice(productPrice);
//        return productRepository.save(product);
//    }
//
//    @Override
//    public Product getProductByProductCode(int productCode) throws ProductNotFoundException {
//        if(productRepository.findById(productCode).isEmpty())
//        {
//            throw new ProductNotFoundException();
//        }
//        return productRepository.findByProductCode(productCode);
//    }
//
//    @Override
//    public boolean deleteProductDetails(int productCode) throws ProductNotFoundException {
//        boolean flag = false;
//        if(productRepository.findById(productCode).isEmpty())
//        {
//            throw new ProductNotFoundException();
//        }
//        else
//        {
//            productRepository.deleteById(productCode);
//            flag=true;
//        }
//        return true;
//    }
//
//    @Override
//    public List<Product> getAllProductStatus(String productStatus) throws ProductNotFoundException {
//        if(productRepository.FindAllByProductStatus(productStatus).isEmpty())
//        {
//            throw new ProductNotFoundException();
//        }
//        return productRepository.FindAllByProductStatus(productStatus);
//    }
//
//    @Override
//    public List<Product> getAllProductDetails() throws Exception {
//        return productRepository.findAll();
//    }
}
