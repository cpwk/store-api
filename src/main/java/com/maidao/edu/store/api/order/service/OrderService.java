package com.maidao.edu.store.api.order.service;

import com.maidao.edu.store.api.order.model.SalesOrder;
import com.maidao.edu.store.api.order.qo.OrderQo;
import com.maidao.edu.store.api.order.repository.IOrderRepository;
import com.maidao.edu.store.common.context.Contexts;
import com.maidao.edu.store.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * 创建人:chenpeng
 * 创建时间:2019-08-31 20:59
 * Version 1.8.0_211
 * 项目名称：store-api
 * 类名称:orderService
 * 类描述:TODO
 **/

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public void save(SalesOrder salesOrder) throws ServiceException {

        salesOrder.setOrderNum(System.currentTimeMillis());

        Integer userId = Contexts.requestUserId();
        salesOrder.setUserId(userId);

        salesOrder.setStatus(1);

        salesOrder.setCreatedAt(System.currentTimeMillis());

        iOrderRepository.save(salesOrder);
    }

    @Override
    public void pay(SalesOrder salesOrder) throws ServiceException {

        SalesOrder exist = iOrderRepository.getOne(salesOrder.getId());

        exist.setStatus(2);

        iOrderRepository.save(exist);
    }

    @Override
    public void receive(SalesOrder salesOrder) throws ServiceException {

        SalesOrder exist = iOrderRepository.getOne(salesOrder.getId());

        exist.setStatus(3);

        iOrderRepository.save(exist);
    }

    @Override
    public void evalProduct(SalesOrder salesOrder) throws ServiceException {

        SalesOrder exist = iOrderRepository.getOne(salesOrder.getId());

        exist.setStatus(4);

        iOrderRepository.save(exist);
    }

    @Override
    public void remove(int id) {
        iOrderRepository.deleteById(id);
    }

    @Override
    public Page<SalesOrder> orders(OrderQo qo, boolean admin) {
        return iOrderRepository.findAll(qo);
    }

    @Override
    public SalesOrder order(int id) {
        return iOrderRepository.getOne(id);
    }
}
