package com.brunosong.springbootexam.orderms.dto;

import com.brunosong.springbootexam.codems.repository.ItemMasterCodeEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CodeRespDto {

    @Getter
    @Setter
    public static class MasterCodeListRespDto {

        private List<MasterCodeDto> masterCodeDtoList = new ArrayList<>();

        public MasterCodeListRespDto(List<ItemMasterCodeEntity> itemMasterCodeJpaEntities) {
            this.masterCodeDtoList = itemMasterCodeJpaEntities.stream().map((MasterCodeDto::new)).collect(Collectors.toList());
        }

        @Getter
        public class MasterCodeDto {
            private Long masterCodeSeq;
            private String masterCode;
            private String masterCodeName;

            public MasterCodeDto(ItemMasterCodeEntity itemMasterCodeEntity) {
                this.masterCodeSeq = itemMasterCodeEntity.getMasterCodeSeq();
                this.masterCode = itemMasterCodeEntity.getMasterCode();
                this.masterCodeName = itemMasterCodeEntity.getMasterCodeName();
            }
        }
    }

}
