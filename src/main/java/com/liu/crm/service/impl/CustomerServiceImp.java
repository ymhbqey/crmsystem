package com.liu.crm.service.impl;

import com.github.pagehelper.PageInfo;
import com.liu.crm.mapper.CustomerMapper;
import com.liu.crm.pojo.Customer;
import com.liu.crm.pojo.QueryVo;
import com.liu.crm.service.CustomerService;
import com.liu.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerMapper mapper;
    public Page<Customer> findCustomersByCriteriaByPage(QueryVo vo) {
        // 计算分页起始记录
        if(vo.getPage()!=null){
            vo.setStart((vo.getPage()-1)*vo.getRows());
        }
        int rows = vo.getRows();
        PageHelper.startPage(vo.getPage(), rows);
        List<Customer> customers = mapper.findCustomersByCriteriaByPage(vo);
        PageInfo<Customer> pageInfo = new PageInfo<Customer>(customers);
        Page<Customer> page = new Page<Customer>((int) pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getList());
        return page;
    }


    // 删除客户
    public void deleteCustomer(Long id) {
        mapper.deleteCustomer(id);
    }

    public void updateCustomer(Customer customer) {
        mapper.updateCustomer(customer);
    }

    public void addCustomer(Customer customer) {
        mapper.addCustomer(customer);
    }

    public Customer getCustomerById(Long id) {
        Customer customer = mapper.getCustomerById(id);
        return customer;
    }
}
