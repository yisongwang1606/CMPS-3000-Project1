package com.zb.controller;

import com.zb.entity.Item;
import com.zb.service.ItemService;
import com.zb.util.ResponseResult;
import com.zb.util.SendData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value="itemController",tags={"PriceListApi"})
@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource
    private ItemService itemService;

    @ApiImplicitParam(name="name",required=false)
    @GetMapping("priceList")
    public ResponseResult priceList(@RequestParam("name") String name){
        if (name.equals("null") || name.equals("")){
            name = null;
        }
        return ResponseResult.success(itemService.getPriceList(name));
    }

    @GetMapping("itemList")
    public ResponseResult itemList(@RequestParam("qualified") String qualified, @RequestParam("name") String name){
        if (name.equals("null") || name.equals("")){
            name = null;
        }
        if (qualified.equals("null") || qualified.equals("")){
            qualified = null;
        }
        return ResponseResult.success(itemService.getItemList(qualified,name));
    }

    @PostMapping("total")
    public ResponseResult total(@RequestBody SendData sendData){
        return ResponseResult.success(itemService.totalPrice(sendData));
    }

    @PostMapping("add")
    public ResponseResult add(@RequestBody Item item){
        return ResponseResult.success(itemService.addItem(item));
    }

    @PostMapping("update")
    public ResponseResult update(@RequestBody Item item){
        return ResponseResult.success(itemService.updateItem(item));
    }

    @DeleteMapping("delete")
    public ResponseResult delete(@RequestParam("name") String name){
        return ResponseResult.success(itemService.deleteItem(name));
    }
}
