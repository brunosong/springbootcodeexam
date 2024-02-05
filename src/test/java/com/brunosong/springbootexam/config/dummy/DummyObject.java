package com.brunosong.springbootexam.config.dummy;

import com.brunosong.springbootexam.entity.order.code.ItemMasterCode;

import java.util.ArrayList;
import java.util.List;

public class DummyObject {

    protected List<ItemMasterCode> newItemMasterCodeList() {

        List<ItemMasterCode> list = new ArrayList<>();

        list.add(ItemMasterCode.builder()
                .masterCodeSeq(1L)
                .masterCode("USER_GRADE")
                .masterCodeName("사용자 등급")
                .build());

        list.add(ItemMasterCode.builder()
                .masterCodeSeq(2L)
                .masterCode("ORDER_TYPE")
                .masterCodeName("주문 유형")
                .build());

        return list;

    }
}
