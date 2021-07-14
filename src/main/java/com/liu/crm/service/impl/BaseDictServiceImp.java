package com.liu.crm.service.impl;

import com.liu.crm.mapper.BaseDictMapper;
import com.liu.crm.pojo.BaseDict;
import com.liu.crm.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BaseDictServiceImp implements BaseDictService {
    @Autowired
    private BaseDictMapper mapper;
    public List<BaseDict> findDictItemNameByTypeCode(String code) {
        return mapper.findItemNameByTypeCode(code);
    }
}
