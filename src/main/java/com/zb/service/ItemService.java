package com.zb.service;

import com.zb.entity.Item;
import com.zb.util.SendData;

import java.util.List;


public interface ItemService {

    List<Item> getPriceList(String name);

    List<Item> getItemList(String qualified, String name);

    Double totalPrice(SendData sendData);

    Integer addItem(Item item);

    Integer deleteItem(String name);

    Integer updateItem(Item item);

}
