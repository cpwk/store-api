package com.maidao.edu.store.api.product.service;

import com.maidao.edu.store.api.product.model.Product;
import com.maidao.edu.store.api.product.qo.ProductQo;
import com.maidao.edu.store.api.product.repository.IProductRepository;
import com.maidao.edu.store.common.exception.DetailedException;
import com.maidao.edu.store.common.exception.ServiceException;
import com.maidao.edu.store.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> products(ProductQo qo, boolean admin) {
        return productRepository.findAll(qo);
    }

    @Override
    public Product product(int id) {
        return productRepository.getOne(id);
    }

    @Override
    public void save(Product product) throws ServiceException {
        if (StringUtils.isEmpty(product.getImg())) {
            throw new DetailedException("请上传图片");
        }
        productRepository.save(product);
    }

    @Override
    public void remove(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void outSome(List<Integer> ids) {
        for (Integer id : ids) {
            Product exist = productRepository.getOne(id);
            exist.setStatus(2);
            productRepository.save(exist);
        }
    }

    @Override
    public void putSome(List<Integer> ids) {
        for (Integer id : ids) {
            Product exist = productRepository.getOne(id);
            exist.setStatus(1);
            productRepository.save(exist);
        }
    }
}