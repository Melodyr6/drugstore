package com.aaa.controller;

import com.aaa.entity.*;
import com.aaa.mapper.CCashierMapper;
import com.aaa.service.CCashierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class CCashierController {
    @Autowired
    private CCashierService cCashierService;

    @PostMapping("caocc/selware")
    public List<CWarehuose> selware(){
        System.out.println("进入微服务caocc/selware内部");
        return cCashierService.selware();
    }

    @PostMapping("caocc/selpharm")
    public List<CPharmacy> selpharm(@RequestBody CPharmacy requestPharmacy){
        System.out.println("进入微服务caocc/selpharm内部");
        return cCashierService.selpharm(requestPharmacy);
    }

    @PostMapping("caocc/deldrunum")
    public Integer deldrunum(@RequestBody CPharmacy requestPharmacy){
        System.out.println("进入微服务caocc/deldrunum内部");
        return cCashierService.deldrunum(requestPharmacy);
    }

    @PostMapping("caocc/adddrunum")
    public Integer adddrunum(@RequestBody CPharmacy requestPharmacy){
        System.out.println("进入微服务caocc/adddrunum内部");
        return cCashierService.adddrunum(requestPharmacy);
    }

}
