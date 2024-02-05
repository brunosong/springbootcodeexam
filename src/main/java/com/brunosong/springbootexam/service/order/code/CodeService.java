package com.brunosong.springbootexam.service.order.code;

import com.brunosong.springbootexam.entity.order.code.ItemMasterCode;
import com.brunosong.springbootexam.repository.order.code.ItemMasterCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.brunosong.springbootexam.dto.order.code.CodeReqDto.MasterCodeReqDto;
import static com.brunosong.springbootexam.dto.order.code.CodeRespDto.MasterCodeListRespDto;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final ItemMasterCodeRepository masterCodeRepository;

    /**
     *  마스터 코드 리스트를 사용해서 마스터 코드에 정보를 가져온다
     *  stub 활용을 위한 억지 서비스
     */
    public MasterCodeListRespDto findMasterCode(List<MasterCodeReqDto> masterCodes ) {

        // 1. masterCode만 추출한다
        List<String> masterCodeList = masterCodes.stream().map( m -> m.getMasterCode ()).collect(Collectors.toList());

        // 2. metaCode 를 이용해서 tb_goods_meta_master 에 정보를 꺼낸다.
        List<ItemMasterCode> masterList = masterCodeRepository.findByMasterCode(masterCodeList);

        return new MasterCodeListRespDto(masterList);

    }





}
