package com.maidao.edu.store.api.sort.service;


import com.maidao.edu.store.api.sort.model.Sort;
import com.maidao.edu.store.api.sort.qo.SortQo;
import com.maidao.edu.store.common.exception.ServiceException;

import java.util.List;

public interface ISortService {

    List<Sort> sorts(SortQo qo, boolean admin);

    Sort sort(int id);

    void save(Sort sort) throws ServiceException;

    void remove(int id);

    void outSome(List<Integer> ids);

    void putSome(List<Integer> ids);

}
