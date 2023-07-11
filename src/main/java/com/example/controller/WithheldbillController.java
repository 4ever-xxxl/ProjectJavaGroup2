package com.example.controller;

import com.example.common.Result;
import com.example.controller.Request.AccountPageRequest;
import com.example.dao.WithheldbillDao;
import com.example.entity.Withheldbill;
import com.example.service.Imp.WithheldbillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/Withheldbill")
public class WithheldbillController {

    @Resource
    private WithheldbillService withheldbillService;

    @Resource
    private WithheldbillDao withheldbillDao;

    @GetMapping("/getAllWithheldbill")
    public Result getAllWithheldbill(){
        return Result.success(withheldbillService.list());
    }

    @PostMapping("/addWithheldbill")
    public Result addWithheldbill(@RequestBody Withheldbill withheldbill){
        try{
            withheldbillDao.insert(withheldbill);
            return Result.success();
        }catch(Exception e){
            System.out.println("insert error");
            return Result.error(e.toString());
        }
    }

    @PutMapping("/updateWithheldbill")
    public Result updateWithheldbill(@RequestBody Withheldbill withheldbill){
        try{
            withheldbillService.updateById(withheldbill);
            return Result.success();
        }catch(Exception e){
            System.out.println("update error");
            return Result.error(e.toString());
        }
    }
    @DeleteMapping("/deleteWithheldbill/{wbid}")
    public Result deleteWithheldbill(@PathVariable long wbid){
        try{
            withheldbillDao.deleteById(wbid);
            return Result.success();
        }catch(Exception e){
            System.out.println("delete error");
            return Result.error(e.toString());
        }
    }

    @PostMapping("/searchWithheldbill")
    public Result searchWithheldbill(@RequestBody AccountPageRequest accountPageRequest){
        PageHelper.startPage(accountPageRequest.getPageNum(),accountPageRequest.getPageSize());

        List<Withheldbill> withheldbills=withheldbillDao.selectList(null);

        //生成新的分页信息
        return Result.success(new PageInfo<>(withheldbills));
    }


}
