package com.brunosong.springbootexam.dto.order.code;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CodeReqDto {

    @Getter
    @Setter
    public static class MasterCodeReqDto {

        private Long masterCodeSeq;

        private String masterCode;

    }


    @Getter
    @Setter
    public static class MasterCodeListReqDto {

        private List<MasterCodeReqDto> masterCodes;

    }




}
