package com.brunosong.springbootexam.service.order.code;

import com.brunosong.springbootexam.config.dummy.DummyObject;
import com.brunosong.springbootexam.dto.order.code.CodeReqDto;
import com.brunosong.springbootexam.dto.order.code.CodeRespDto;
import com.brunosong.springbootexam.repository.order.code.ItemMasterCodeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.brunosong.springbootexam.dto.order.code.CodeReqDto.*;
import static com.brunosong.springbootexam.dto.order.code.CodeRespDto.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CodeServiceTest extends DummyObject {

    @InjectMocks
    private CodeService codeService;

    @Mock
    private ItemMasterCodeRepository masterCodeRepository;

    @Test
    @DisplayName("프로퍼티 업데이트 서비스 테스트")
    void insertAndUpdateLevelProperty() {

        MasterCodeReqDto reqDto1 = new MasterCodeReqDto();
        reqDto1.setMasterCode("USER_GRADE");

        MasterCodeReqDto reqDto2 = new MasterCodeReqDto();
        reqDto1.setMasterCode("ORDER_TYPE");

        List<MasterCodeReqDto> reqDtoList = new ArrayList<>();
        reqDtoList.add(reqDto1);
        reqDtoList.add(reqDto2);

        //stub
        when(masterCodeRepository.findByMasterCode(anyList())).thenReturn(newItemMasterCodeList());

        MasterCodeListRespDto masterCodes = codeService.findMasterCode(reqDtoList);


        Assertions.assertThat(masterCodes.getMasterCodeDtoList())
                .extracting("masterCodeSeq")
                .containsExactly(1L,2L);

    }

}