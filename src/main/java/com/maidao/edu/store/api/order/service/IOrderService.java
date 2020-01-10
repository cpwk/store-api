package com.maidao.edu.store.api.order.service;

import com.maidao.edu.store.api.order.model.SalesOrder;
import com.maidao.edu.store.api.order.qo.OrderQo;
import com.maidao.edu.store.common.exception.ServiceException;
import org.springframework.data.domain.Page;

public interface IOrderService {

    Page<SalesOrder> orders(OrderQo qo, boolean admin);

    SalesOrder order(int id);

    void save(SalesOrder salesOrder) throws ServiceException;

    void pay(SalesOrder salesOrder) throws ServiceException;

    void receive(SalesOrder salesOrder) throws ServiceException;

    void evalProduct(SalesOrder salesOrder) throws ServiceException;

    void remove(int id);
}
