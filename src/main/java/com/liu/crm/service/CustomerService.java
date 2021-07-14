package com.liu.crm.service;

import com.liu.crm.pojo.Customer;
import com.liu.crm.pojo.QueryVo;
import com.liu.crm.utils.Page;


public interface CustomerService {
    // 依据查询条件按液查询客户列表
    Page<Customer> findCustomersByCriteriaByPage(QueryVo vo);

    void deleteCustomer(Long id);
    void updateCustomer(Customer customer);
    void addCustomer(Customer customer);
    Customer getCustomerById(Long id);
}
