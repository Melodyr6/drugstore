package com.aaa.controller;

import com.aaa.entity.Area;
import com.aaa.entity.Sdrugdictionary;
import com.aaa.entity.Type;
import com.aaa.entity.Unit;
import com.aaa.mapper.SdrugdictionaryMapper;
import com.aaa.service.SdrugdictionaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin(origins = "http://localhost:8082")
@RequestMapping("drugdictionary")
public class SdrugdictionaryController {
    @Autowired
    private SdrugdictionaryService sdrugdictionaryService;
    /*
     * 查询药品
     * */
    @GetMapping("findAllSdrugdictionary")
    @ResponseBody
    public Object SdrugdictionaryList(Sdrugdictionary sdrugdictionary, Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<SdrugdictionaryMapper> listAll = sdrugdictionaryService.findAllSdrugdictionary(sdrugdictionary);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());

        return tableData;
    }
    /*
     * 添加药品
     * */
    @GetMapping("addSdrugdictionary")
    @ResponseBody
    public Object addSdrugdictionary(Sdrugdictionary sdrugdictionary){
        int count = sdrugdictionaryService.count(sdrugdictionary);
        if(count==0){
            int i = sdrugdictionaryService.addSdrugdictionary(sdrugdictionary);
            if(i==1){
                return "添加成功";
            }else{
                return "添加失败";
            }
        }else {
            return sdrugdictionary.getDrugName()+"已存在";
        }

    }
    /*
     * 修改药品
     * */
    @GetMapping("editSdrugdictionary")
    @ResponseBody
    public Object editSdrugdictionary(Sdrugdictionary sdrugdictionary){
        int i = sdrugdictionaryService.editSdrugdictionary(sdrugdictionary);
        if(i==1){
            return "修改成功";
        }else{
            return "修改失败";
        }

    }
    /*
     * 删除药品
     * */
    @PostMapping("deleteSdrugdictionary")
    @ResponseBody
    public Object deleteSdrugdictionary(Integer drugId){
        int i = sdrugdictionaryService.deleteSdrugdictionary(drugId);
        if(i==1){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    @GetMapping("findAllArea")
    @ResponseBody
    public Object findAllArea(){
        List<Area> allArea = sdrugdictionaryService.findAllArea();
        return allArea;
    }
    @GetMapping("findAllType")
    @ResponseBody
    public Object findAllType(){
        List<Type> allType = sdrugdictionaryService.findAllType();
        return allType;
    }
    @GetMapping("findAllUnit")
    @ResponseBody
    public Object findAllUnit(){
        List<Unit> allUnit = sdrugdictionaryService.findAllUnit();
        return allUnit;
    }
}
