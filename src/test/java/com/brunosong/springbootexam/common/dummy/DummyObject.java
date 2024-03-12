package com.brunosong.springbootexam.common.dummy;

import com.brunosong.springbootexam.codems.repository.ItemMasterCodeEntity;

import java.util.ArrayList;
import java.util.List;

public class DummyObject {

    protected List<ItemMasterCodeEntity> newItemMasterCodeList() {

        List<ItemMasterCodeEntity> list = new ArrayList<>();

        list.add(ItemMasterCodeEntity.builder()
                .masterCodeSeq(1L)
                .masterCode("USER_GRADE")
                .masterCodeName("사용자 등급")
                .build());

        list.add(ItemMasterCodeEntity.builder()
                .masterCodeSeq(2L)
                .masterCode("ORDER_TYPE")
                .masterCodeName("주문 유형")
                .build());

        return list;

    }
}
