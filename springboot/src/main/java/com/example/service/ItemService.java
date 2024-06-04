package com.example.service;

import com.example.exception.CustomException;
import com.example.mapper.ItemMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.Item;
import com.example.pojo.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Resource
    private ItemMapper itemMapper;

    public void add(Item item,int user_id) {
        if(item.getWear()==0.0) {
            throw new CustomException("磨损度不能为空！");
        }
        if(item.getSkin_name()==null || "".equals(item.getSkin_name())) {
            throw new CustomException("皮肤名不能为空！");
        }
        if(item.getWeapon_type()==null || "".equals(item.getWeapon_type())) {
            throw new CustomException("武器类型不能为空！");
        }
        if(item.getImage()==null || item.getImage().length==0) {
            throw new CustomException("请上传图像！");
        }
        itemMapper.addItem(item);
        itemMapper.addToInventory(user_id,item.getItem_id());
    }

    public List<Item> getItem(int user_id) {
        return itemMapper.getItem(user_id);
    }

    public List<Item> getItemById(int item_id) {
        return itemMapper.getItemById(item_id);
    }
}
