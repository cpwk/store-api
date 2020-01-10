package com.maidao.edu.store.api.home;

import com.maidao.edu.store.api.banner.qo.BannerQo;
import com.maidao.edu.store.api.banner.service.IBannerService;
import com.maidao.edu.store.api.product.qo.ProductQo;
import com.maidao.edu.store.api.product.service.IProductService;
import com.maidao.edu.store.common.authority.AdminType;
import com.maidao.edu.store.common.authority.RequiredPermission;
import com.maidao.edu.store.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usr/home")
public class HomeController extends BaseController {

    @Autowired
    private IBannerService bannerService;


    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/banners")
    @RequiredPermission(adminType = AdminType.NONE)
    public ModelAndView banners(String bannerQo) throws Exception {
        return feedback(bannerService.banners(parseModel(bannerQo, new BannerQo()), false));
    }


    @RequestMapping(value = "/products")
    @RequiredPermission(adminType = AdminType.NONE)
    public ModelAndView products(String productQo) throws Exception {
        return feedback(productService.products(parseModel(productQo, new ProductQo()), true));
    }
}