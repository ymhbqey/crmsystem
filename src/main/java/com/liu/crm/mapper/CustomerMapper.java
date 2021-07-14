package com.liu.crm.mapper;

import com.liu.crm.pojo.Customer;
import com.liu.crm.pojo.QueryVo;
import com.liu.crm.utils.Page;

import java.util.List;

public interface CustomerMapper {
    List<Customer> findCustomersByCriteriaByPage(QueryVo vo);

    void deleteCustomer(Long id);
    void updateCustomer(Customer customer);
    void addCustomer(Customer customer);
    Customer getCustomerById(Long id);
}
