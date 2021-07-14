package com.liu.crm.service;

import com.liu.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> findDictItemNameByTypeCode(String code);
}
