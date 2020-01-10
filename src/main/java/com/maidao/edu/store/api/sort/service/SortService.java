package com.maidao.edu.store.api.sort.service;

import com.maidao.edu.store.api.sort.model.Sort;
import com.maidao.edu.store.api.sort.qo.SortQo;
import com.maidao.edu.store.api.sort.repository.ISortRepository;
import com.maidao.edu.store.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建人:chenpeng
 * 创建时间:2019-08-31 20:59
 * Version 1.8.0_211
 * 项目名称：store-api
 * 类名称:SortService
 * 类描述:TODO
 **/
@Service
public class SortService implements ISortService {

    @Autowired
    private ISortRepository iSortRepository;

    @Override
    public List<Sort> sorts(SortQo qo, boolean admin) {
        return iSortRepository.findAll(qo);
    }

    @Override
    public Sort sort(int id) {
        return iSortRepository.getOne(id);
    }

    @Override
    public void save(Sort sort) throws ServiceException {
        iSortRepository.save(sort);
    }

    @Override
    public void remove(int id) {
        iSortRepository.deleteById(id);
    }

    @Override
    public void outSome(List<Integer> ids) {
        for (Integer id : ids) {
            Sort exist = iSortRepository.getOne(id);
            exist.setStatus(2);
            iSortRepository.save(exist);
        }
    }

    @Override
    public void putSome(List<Integer> ids) {
        for (Integer id : ids) {
            Sort exist = iSortRepository.getOne(id);
            exist.setStatus(1);
            iSortRepository.save(exist);
        }
    }
}
