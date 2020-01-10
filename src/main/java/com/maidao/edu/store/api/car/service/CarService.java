package com.maidao.edu.store.api.car.service;

import com.maidao.edu.store.api.car.model.Car;
import com.maidao.edu.store.api.car.repository.ICarRepository;
import com.maidao.edu.store.api.product.repository.IProductRepository;
import com.maidao.edu.store.common.context.Contexts;
import com.maidao.edu.store.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建人:chenpeng
 * 创建时间:2019-08-31 20:59
 * Version 1.8.0_211
 * 项目名称：store-api
 * 类名称:carService
 * 类描述:TODO
 **/
@Service
public class CarService implements ICarService {

    @Autowired
    private ICarRepository iCarRepository;

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public void save(Car car) throws ServiceException {

        Integer userId = Contexts.requestUserId();

        Car exist = iCarRepository.findByUserIdAndAndProductId(userId, car.getProductId());

        if (exist != null) {

            exist.setNum(car.getNum());
            iCarRepository.save(exist);
        } else {
            iCarRepository.save(car);
        }
    }

    @Override
    public void remove(int id) {
        iCarRepository.deleteById(id);
    }

    @Override
    public List<Car> cars() throws Exception {

        Integer userId = Contexts.requestUserId();

        List<Car> c = iCarRepository.findByUserId(userId);

        for (Car car : c) {
            car.setProduct(iProductRepository.getOne(car.getProductId()));
        }
        return c;
    }


    @Override
    public Car car(int id) {
        return iCarRepository.getOne(id);
    }

    @Override
    public List<Car> findByIds(List<Integer> ids) {

        List<Car> car = iCarRepository.findAllByIdIn(ids);

        for (Car cars : car) {
            cars.setProduct(iProductRepository.getOne(cars.getProductId()));
        }
        return car;
    }
}
