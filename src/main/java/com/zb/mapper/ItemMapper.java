package com.zb.mapper;

import com.zb.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {

    List<Item> getPriceList(@Param("name") String name);

    List<Item> getItemList(@Param("qualified")String qualified,@Param("name") String name);

    Integer addItem(Item item);

    Integer deleteItem(@Param("name") String name);

    Integer updateItem(Item item);
}
