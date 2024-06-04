package com.example.controller;

import com.example.common.Result;
import com.example.pojo.Item;
import com.example.pojo.Listing;
import com.example.pojo.ListingInfo;
import com.example.service.ListingService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/listing")
public class ListingController {

    @Resource
    private ListingService listingService;

    @GetMapping("/getListing")
    public Result getItem(@RequestParam("user_id") int user_id) {
        List<Listing> list = listingService.getlisting(user_id);
        return Result.success(list);
    }

    @RequestMapping("/addListing")
    public Result add(@RequestParam int item_id,@RequestParam int user_id,@RequestParam double price) {
        listingService.add(item_id,user_id,price);
        return Result.success();
    }

    @PostMapping("/deleteListing")
    public Result delete(@RequestBody Item item,@RequestParam("user_id") int user_id) {
        listingService.delete(item,user_id);
        return Result.success();
    }

    @GetMapping("/getListingInfo")
    public Result getListingInfo() {
        List<ListingInfo> list = listingService.getListingInfo();
        return Result.success(list);
    }

    /*@GetMapping("/getAllListing")
    public Result getAllListing() {
        List<Listing> list = listingService.getAllListing();
        return Result.success(list);
    }*/
}
