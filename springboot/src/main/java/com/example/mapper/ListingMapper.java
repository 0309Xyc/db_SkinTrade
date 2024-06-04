package com.example.mapper;

import com.example.pojo.Listing;
import com.example.pojo.ListingInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface ListingMapper extends Mapper<Listing> {

    @Select("select listing_id,user_id,item_id,price from listing natural join user where user_id = #{user_id}")
    List<Listing> getListing(@Param("user_id")int user_id);

    @Insert("insert into listing (user_id,item_id,price) value(#{user_id},#{item_id},#{price}) ")
    void addListing(@Param("item_id")int item_id, @Param("user_id")int user_id, @Param("price")double price);

    @Delete("delete from listing where item_id=#{item_id} and #{user_id}")
    void deleteListing(@Param("item_id")int item_id, @Param("user_id")int user_id);

    @Select("select price,username,skin_name,weapon_type from listing natural join user natural join items")
    List<ListingInfo> getListingInfo();

    /*@Select("select listing_id,user_id,item_id,price from listing}")
    List<Listing> getAllListing();*/
}
