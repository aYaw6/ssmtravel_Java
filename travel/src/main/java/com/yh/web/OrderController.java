package com.yh.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.pojo.Member;
import com.yh.pojo.Orders;
import com.yh.pojo.Product;
import com.yh.pojo.Traveller;
import com.yh.service.MemberService;
import com.yh.service.OrderService;
import com.yh.service.ProductService;
import com.yh.service.TravellerService;
import jdk.nashorn.internal.runtime.ListAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: Yanjw
 * @Date: 2023/11/3 - 11 - 03 - 15:40
 * @Description: com.yh.web
 * @version: 1.0
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private TravellerService travellerService;
    @GetMapping("findAll")
    public String findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "5") Integer size, Model model){
        PageHelper.startPage(page, size);
        List<Orders> ordersList = orderService.findAll();
        PageInfo<Orders>pageInfo = new PageInfo<>(ordersList);
        model.addAttribute("pageInfo", pageInfo);
        return "order-list";
    }

    @GetMapping("findById")
    public String findById(@RequestParam("id")Integer id, Model model){
        Orders order = orderService.findById(id);
        model.addAttribute("order", order);
        return "order-show";
    }

    @GetMapping("add")
    public String toAdd(Model model){
        List<Product> productList = productService.findAll();
        List<Member> memberList = memberService.findAll();
        List<Traveller> travellerList = travellerService.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("memberList", memberList);
        model.addAttribute("travellerList", travellerList);
        return "order-add";
    }

    @PostMapping("save")
    public String save(Orders orders){
        //这里Orders,需要修改一下;
        orderService.save(orders,orders.getTravellerId());
        return "redirect:findAll";
    }
}
