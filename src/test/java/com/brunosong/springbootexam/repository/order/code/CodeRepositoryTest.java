package com.brunosong.springbootexam.repository.order.code;

import com.brunosong.springbootexam.entity.order.code.ItemDetailCode;
import com.brunosong.springbootexam.entity.order.code.ItemMasterCode;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {"spring.config.location = classpath:application-test.yml"})
class CodeRepositoryTest {

    @Autowired
    ItemMasterCodeRepository itemMasterCodeRepository;

    @Autowired
    ItemDetailCodeRepository itemDetailCodeRepository;

    @Autowired
    EntityManager entityManager;


    @BeforeEach
    void setup() {

        ItemMasterCode masterEntity1 = ItemMasterCode.builder()
                .masterCode("USER_GRADE")
                .masterCodeName("사용자 등급")
                .build();

        itemMasterCodeRepository.save(masterEntity1);

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

        entityManager.flush();
        entityManager.clear();

    }


    @Test
    @DisplayName("마스터 코드로 아이템까지 가져오기")
    void findByMasterCodeNameTest() {

        String masterCode = "USER_GRADE";

        ItemMasterCode itemMasterCode = itemMasterCodeRepository.findByMasterCode(masterCode).get();
        assertThat(itemMasterCode.getMasterCodeName()).isEqualTo("사용자 등급");

        List<ItemDetailCode> itemList = itemMasterCode.getItemList();
        assertThat(itemList.size()).isEqualTo(2);

    }



}