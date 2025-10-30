package com.zb.service.impl;

import com.zb.entity.Item;
import com.zb.entity.ItemCount;
import com.zb.mapper.ItemMapper;
import com.zb.service.ItemService;
import com.zb.util.SendData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Override
    public List<Item> getPriceList(String name) {
        List<Item> priceList = itemMapper.getPriceList(name);
        return priceList;
    }

    @Override
    public List<Item> getItemList(String qualified, String name) {
        List<Item> itemList = itemMapper.getItemList(qualified,name);
        return itemList;
    }

    @Override
    public Integer addItem(Item item) {
        item.setPromotion(0.0);
        item.setQualified(2);
        Integer num = itemMapper.addItem(item);
        return num;
    }

    @Override
    public Integer deleteItem(String name) {
        Integer num = itemMapper.deleteItem(name);
        return num;
    }

    @Override
    public Integer updateItem(Item item) {
        Integer num = itemMapper.updateItem(item);
        return num;
    }

    @Override
    public Double totalPrice(SendData sendData) {

        Double totalPrice = 0.0;


        if (membershipCheck(sendData.getMembershipStatus())){
            for (ItemCount items : sendData.getCount()){
                if (countCheck(items.getCount())){
                    if (promotionCheck(items.getPromotion())){
                        Double promotion= items.getPromotion();
                        totalPrice = totalPrice + items.getCount() * (items.getPrice() - promotion);
                    }else {
                        totalPrice = totalPrice + items.getCount() * items.getPrice();
                    }
                }else {
                    totalPrice = totalPrice + items.getCount() * items.getPrice();
                }
            }
            return totalPrice;
        }else {
            for (ItemCount items : sendData.getCount()){
                totalPrice = totalPrice + items.getCount() * items.getPrice();
            }
            return totalPrice;
        }
    }

    private boolean membershipCheck(String membership){
        if (membership.equals("true")){
            return true;
        }
        return false;
    }

    private boolean countCheck(Integer count){
        if (count>2){
            return true;
        }
        return false;
    }

    private boolean promotionCheck(Double hasPromotion){
        if (hasPromotion != 0.0){
            return true;
        }
        return false;
    }

}
