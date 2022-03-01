package com.niit.mongodbquery.service;

import com.niit.mongodbquery.exception.*;
import com.niit.mongodbquery.model.Customer;
import com.niit.mongodbquery.model.Product;
import com.niit.mongodbquery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
        if(productRepository.findById(customer.getCustomerEmailId()).isPresent())
        {
            throw new CustomerAlreadyExistsException();
        }
        return productRepository.save(customer);
    }

    @Override
    public Customer saveCustomerProduct(String customerEmailId,Product product) throws CustomerNotFoundException, ProductAlreadyExistsException{
        if(productRepository.findById(customerEmailId).isEmpty())
        {
            throw new CustomerNotFoundException();
        }

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        Customer customer = productRepository.findById(customerEmailId).get();
        customer.setProductList(productList);

//        Customer customer = productRepository.findById(customerEmailId).get();
//        List<Product> productList = customer.getProductList();
//
//        if(productList.isEmpty())
//        {
//            customer.setProductList(Arrays.asList(product));
//        }
//        else
//        {
//            List<Product> productList1 = customer.getProductList();
//            productList1.add(product);
//            customer.setProductList(productList1);
//            customer.setProductList(Arrays.asList(product));

        return productRepository.save(customer);


    }

    @Override
    public Customer deleteProductOfACustomer(String customerEmailId,int productCode) throws CustomerNotFoundException {
        if(productRepository.findById(customerEmailId).isEmpty())
        {
            throw new CustomerNotFoundException();
        }
        Customer customer = productRepository.findById(customerEmailId).get();
        List<Product> productList = customer.getProductList();
        for(Product p:productList)
        {
            if(p.getProductCode()==(productCode))
            {
                productList.remove(p);
                productRepository.save(customer);
            }
        }
        return customer;
    }

    @Override
    public List<Product> getAllProductsOfACustomer(String customerEmailId) throws CustomerNotFoundException {
        if(productRepository.findById(customerEmailId).isEmpty())
        {
            throw new CustomerNotFoundException();
        }
        return productRepository.findById(customerEmailId).get().getProductList();
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
