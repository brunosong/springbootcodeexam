package com.brunosong.springbootexam.repository.orderms.code;

import com.brunosong.springbootexam.config.annotation.OrderMsDevDbDataJpaTest;
import com.brunosong.springbootexam.entity.order.code.ItemDetailCode;
import com.brunosong.springbootexam.entity.order.code.ItemMasterCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@OrderMsDevDbDataJpaTest
class CodeRepositoryTest {

    @Autowired
    ItemMasterCodeRepository itemMasterCodeRepository;

    @Autowired
    ItemDetailCodeRepository itemDetailCodeRepository;

    @BeforeEach
    void setup() {

        ItemMasterCode masterEntity1 = ItemMasterCode.builder()
                .masterCode("USER_GRADE")
                .masterCodeName("사용자 등급")
                .build();

        itemMasterCodeRepository.save(masterEntity1);
        itemMasterCodeRepository.flush();

        ItemDetailCode userTypeItemBronze = ItemDetailCode.builder()
                .itemCode("BRONZE")
                .itemName("브론즈")
                .itemMasterCode(masterEntity1)
                .build();

        ItemDetailCode userTypeItemSilver = ItemDetailCode.builder()
                .itemCode("SILVER")
                .itemName("실버")
                .itemMasterCode(masterEntity1)
                .build();

        itemDetailCodeRepository.save(userTypeItemBronze);
        itemDetailCodeRepository.save(userTypeItemSilver);

        itemDetailCodeRepository.flush();

    }


    @Test
    @DisplayName("마스터 코드로 아이템까지 가져오기")
    void findByMasterCodeNameTest() {

        String masterCode = "USER_GRADE";

        ItemMasterCode itemMasterCode = itemMasterCodeRepository.findByMasterCode(masterCode).get();
        assertThat(itemMasterCode.getMasterCodeName()).isEqualTo("사용자 등급");
        System.out.println("---------------------------------------------------------------------");
        List<ItemDetailCode> itemList = itemMasterCode.getItemList();
        ItemDetailCode itemDetailCode = itemList.get(0);
        System.out.println(itemDetailCode.getItemCode());
        System.out.println("---------------------------------------------------------------------");
        assertThat(itemList.size()).isEqualTo(2);

    }



}