package com.maidao.edu.store.api.order.controller;

import com.maidao.edu.store.api.order.model.SalesOrder;
import com.maidao.edu.store.api.order.qo.OrderQo;
import com.maidao.edu.store.api.order.service.OrderService;
import com.maidao.edu.store.common.authority.AdminType;
import com.maidao.edu.store.common.authority.RequiredPermission;
import com.maidao.edu.store.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/save")
    @RequiredPermission(adminType = AdminType.USER)
    public ModelAndView save(String order) throws Exception {
        orderService.save(parseModel(order, new SalesOrder()));
        return feedback(null);
    }

    @RequestMapping(value = "/pay")
    @RequiredPermission(adminType = AdminType.USER)
    public ModelAndView pay(String order) throws Exception {
        orderService.pay(parseModel(order, new SalesOrder()));
        return feedback(null);
    }

    @RequestMapping(value = "/receive")
    @RequiredPermission(adminType = AdminType.USER)
    public ModelAndView receive(String order) throws Exception {
        orderService.receive(parseModel(order, new SalesOrder()));
        return feedback(null);
    }

    @RequestMapping(value = "/evalproduct")
    @RequiredPermission(adminType = AdminType.USER)
    public ModelAndView evalProduct(String order) throws Exception {
        orderService.evalProduct(parseModel(order, new SalesOrder()));
        return feedback(null);
    }

    @RequestMapping(value = "/remove")
    @RequiredPermission(adminType = AdminType.USER)
    public ModelAndView remove(Integer id) throws Exception {
        orderService.remove(id);
        return feedback(null);
    }

    @RequestMapping(value = "/order")
    @RequiredPermission(adminType = AdminType.USER)
    public ModelAndView order(Integer id) throws Exception {
        return feedback(orderService.order(id));
    }

    @RequestMapping(value = "/orders")
    @RequiredPermission(adminType = AdminType.USER)
    public ModelAndView orders(String orderQo) throws Exception {
        return feedback(orderService.orders(parseModel(orderQo, new OrderQo()), true));
    }
}