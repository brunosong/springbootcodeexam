package com.brunosong.springbootexam.dto.orderms.code;

import com.brunosong.springbootexam.entity.order.code.ItemMasterCode;
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

        public MasterCodeListRespDto(List<ItemMasterCode> itemMasterCodes) {
            this.masterCodeDtoList = itemMasterCodes.stream().map((MasterCodeDto::new)).collect(Collectors.toList());
        }

        @Getter
        public class MasterCodeDto {
            private Long masterCodeSeq;
            private String masterCode;
            private String masterCodeName;

            public MasterCodeDto(ItemMasterCode itemMasterCode) {
                this.masterCodeSeq = itemMasterCode.getMasterCodeSeq();
                this.masterCode = itemMasterCode.getMasterCode();
                this.masterCodeName = itemMasterCode.getMasterCodeName();
            }
        }
    }

}
