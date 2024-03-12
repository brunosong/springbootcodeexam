package com.brunosong.springbootexam.codems.repository;

import com.brunosong.springbootexam.orderms.config.annotation.OrderMsDevDbDataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@OrderMsDevDbDataJpaTest
@Sql("/sql/itemcode-insert.sql")
class CodeRepositoryTest {

    @Autowired
    ItemMasterCodeRepository itemMasterCodeRepository;

    @Test
    void 마스터코드를_사용하여_상세코드_아이템_가져오기_테스트() {

        String masterCode = "USER_GRADE";

        ItemMasterCodeEntity itemMasterCodeEntity = itemMasterCodeRepository.findByMasterCode(masterCode).get();
        assertThat(itemMasterCodeEntity.getMasterCodeName()).isEqualTo("사용자 등급");

        List<ItemDetailCodeEntity> itemList = itemMasterCodeEntity.getItemList();
        assertThat(itemList.size()).isEqualTo(2);

    }



}