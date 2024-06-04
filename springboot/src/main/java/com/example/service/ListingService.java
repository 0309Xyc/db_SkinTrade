package com.example.service;

import com.example.mapper.ItemMapper;
import com.example.mapper.ListingMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.Item;
import com.example.pojo.Listing;
import com.example.pojo.User;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pojo.ListingInfo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingService {
    @Resource
    private ListingMapper listingMapper;


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ItemMapper itemMapper;

    public List<Listing> getlisting(int user_id) {
        return listingMapper.getListing(user_id);
    }

    public void add(int item_id, int user_id, double price) {
        listingMapper.addListing(item_id, user_id, price);
    }

    public void delete(Item item, int user_id) {
        listingMapper.deleteListing(item.getItem_id(), user_id);
    }

    public List<ListingInfo> getListingInfo() {
        return listingMapper.getListingInfo();
    }
}

    /*List<Listing> listings = listingMapper.getAllListing();

        return listings.stream().map(listing -> {
        User user = (User) userMapper.findById(listing.getUser_id());
        Item item = (Item) itemMapper.getItemById(listing.getItem_id());
        return new ListingInfo(listing, user, item);
    }).collect(Collectors.toList());
}

    public List<Listing> getAllListing() {
        return listingMapper.getAllListing();
    }
    }*/
