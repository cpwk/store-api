package com.maidao.edu.store.common.exception;


import com.maidao.edu.store.common.entity.ErrorCode;

public class DetailedException extends ServiceException {

    public DetailedException(String msg) {
        super(ErrorCode.DETAILED.getCode(), msg);
    }

}
