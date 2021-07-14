package com.liu.crm.mapper;

import com.liu.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictMapper {
    List<BaseDict> findItemNameByTypeCode(String code);
}
