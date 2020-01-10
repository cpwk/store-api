package com.maidao.edu.store.api.sort.controller;

import com.alibaba.fastjson.JSON;
import com.maidao.edu.store.api.admin.authority.AdminPermission;
import com.maidao.edu.store.api.sort.model.Sort;
import com.maidao.edu.store.api.sort.qo.SortQo;
import com.maidao.edu.store.api.sort.service.SortService;
import com.maidao.edu.store.common.authority.AdminType;
import com.maidao.edu.store.common.authority.RequiredPermission;
import com.maidao.edu.store.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adm/sort")
public class SortController extends BaseController {
    @Autowired
    private SortService sortService;

    @RequestMapping(value = "/save")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.SORT_EDIT)
    public ModelAndView save(String sort) throws Exception {
        sortService.save(parseModel(sort, new Sort()));
        return feedback(null);
    }

    @RequestMapping(value = "/remove")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.SORT_EDIT)
    public ModelAndView remove(Integer id) throws Exception {
        sortService.remove(id);
        return feedback(null);
    }

    @RequestMapping(value = "/sort")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.SORT_EDIT)
    public ModelAndView sort(Integer id) throws Exception {
        return feedback(sortService.sort(id));
    }

    @RequestMapping(value = "/sorts")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.SORT_EDIT)
    public ModelAndView sorts(String sortQo) throws Exception {
        return feedback(sortService.sorts(parseModel(sortQo, new SortQo()), true));
    }

    @RequestMapping(value = "/outsome")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.SORT_EDIT)
    public ModelAndView outSome(String ids) throws Exception {
        sortService.outSome(JSON.parseArray(ids, Integer.class));
        return feedback();
    }

    @RequestMapping(value = "/putsome")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.SORT_EDIT)
    public ModelAndView putSome(String ids) throws Exception {
        sortService.putSome(JSON.parseArray(ids, Integer.class));
        return feedback();
    }
}