package com.example.mapper;

import com.example.pojo.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface ItemMapper extends Mapper<Item> {

    @Insert("INSERT INTO items (wear, skin_name, weapon_type, image) VALUES (#{wear}, #{skin_name}, #{weapon_type}, #{image})")
    @Options(useGeneratedKeys = true, keyProperty = "item_id")
    void addItem(Item item);

    @Insert("INSERT INTO inventory (user_id, item_id) VALUES (#{user_id}, #{item_id})")
    void addToInventory(@Param("user_id") int user_id, @Param("item_id") int item_id);

    @Select("select item_id,wear,skin_name,weapon_type from items natural join inventory where user_id = #{user_id}")
    List<Item> getItem(@Param("user_id")int user_id);

    @Select("select item_id,wear,skin_name,weapon_type from items where item_id = #{item_id}")
    List<Item> getItemById(@Param("item_id")int item_id);
}
