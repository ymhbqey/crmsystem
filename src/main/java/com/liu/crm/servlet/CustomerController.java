package com.liu.crm.servlet;

import com.liu.crm.mapper.BaseDictMapper;
import com.liu.crm.pojo.BaseDict;
import com.liu.crm.pojo.Customer;
import com.liu.crm.pojo.QueryVo;
import com.liu.crm.service.BaseDictService;
import com.liu.crm.service.CustomerService;
import com.liu.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    @Value("${customer_from_type}")
    private String customer_from_type;
    @Value("${customer_industry_type}")
    private String customer_industry_type;
    @Value("${customer_level_type}")
    private String customer_level_type;

    // 到达主页面的请求
    @GetMapping(value = "/list")
    public String toMain(QueryVo queryVo,Model model) {
        // 得到客户来源选项
        List<BaseDict> fromType = baseDictService.findDictItemNameByTypeCode(customer_from_type);
        List<BaseDict> industryType = baseDictService.findDictItemNameByTypeCode(customer_industry_type);
        List<BaseDict> levelType = baseDictService.findDictItemNameByTypeCode(customer_level_type);

        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);

        Page<Customer> page = customerService.findCustomersByCriteriaByPage(queryVo);
        model.addAttribute("page", page);

        return "customer";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteCustomer(Long id) {
        customerService.deleteCustomer(id);
        return "customer";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
        return "customer";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Customer getCustomerById(Long id) {
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    @RequestMapping("/add")
    public String addCustomer(Customer customer){
        customerService.addCustomer(customer);
        return "customer";
    }



}
