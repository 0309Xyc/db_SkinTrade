package com.example.controller;

import com.example.common.Result;
import com.example.pojo.Item;
import com.example.service.ItemService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource
    private ItemService itemService;

    @PostMapping("/addItem")
    public Result add(@RequestBody Item item,@RequestParam("user_id") int user_id) {
        itemService.add(item,user_id);
        return Result.success();
    }

    @GetMapping("/getItem")
    public Result getItem(@RequestParam("user_id") int user_id) {
        List<Item> list = itemService.getItem(user_id);
        return Result.success(list);
    }
}
