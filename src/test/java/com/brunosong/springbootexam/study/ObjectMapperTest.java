package com.brunosong.springbootexam.study;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class ObjectMapperTest {

    List<PropertyLevelDto> propertyLevelDtoList;

    List<PropertyQstDto> propertyQstDtoList;


    @BeforeEach
    void setup() {
        PropertyLevelDto propertyLevelDto1 = new PropertyLevelDto(1L,"1번");
        PropertyLevelDto propertyLevelDto2 = new PropertyLevelDto(2L,"2번");
        PropertyLevelDto propertyLevelDto3 = new PropertyLevelDto(3L,"3번");
        propertyLevelDtoList = new ArrayList<>();
        propertyLevelDtoList.add(propertyLevelDto1);
        propertyLevelDtoList.add(propertyLevelDto2);
        propertyLevelDtoList.add(propertyLevelDto3);


        PropertyQstDto propertyQstDto1 = new PropertyQstDto(1L,"1번");
        PropertyQstDto propertyQstDto2 = new PropertyQstDto(2L,"2번");
        PropertyQstDto propertyQstDto3 = new PropertyQstDto(3L,"3번");
        propertyQstDtoList = new ArrayList<>();
        propertyQstDtoList.add(propertyQstDto1);
        propertyQstDtoList.add(propertyQstDto2);
        propertyQstDtoList.add(propertyQstDto3);
    }


    @Test
    void convertTest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();

        String asString = objectMapper.writeValueAsString(propertyLevelDtoList);
        log.info("json = {}", asString);

        //방법 1
        PropertyLevelDto[] result1 =
                objectMapper.readValue(asString, PropertyLevelDto[].class);

        //방법 2
        List<PropertyLevelDto> result2 =
                Arrays.asList(objectMapper.readValue(asString, PropertyLevelDto[].class));

        //방법 3
        List<PropertyLevelDto> result3 =
                objectMapper.readValue(asString, new TypeReference<List<PropertyLevelDto>>() {});

    }

    @Test
    void useReflectionConvertTest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        String levelJson = objectMapper.writeValueAsString(propertyLevelDtoList);
        String qstJson = objectMapper.writeValueAsString(propertyQstDtoList);

        log.info("levelJson = {}", levelJson);
        log.info("qstJson = {}", qstJson);

        List<PropertyLevelDto> propertyLevelDtos =
                changeJsonToDtoList1(levelJson, PropertyLevelDto.class);

        Assertions.assertThat(propertyLevelDtos.get(0)).isInstanceOf(PropertyLevelDto.class);


        List<PropertyQstDto> propertyQstDtos =
                changeJsonToDtoList1(qstJson, PropertyQstDto.class);

        Assertions.assertThat(propertyQstDtos.get(0)).isInstanceOf(PropertyQstDto.class);

    }

    private <T> List<T> changeJsonToDtoList1(String asString, Class<T> type) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, type);
        List<T> list = objectMapper.readValue(asString, collectionType);

        return list;
    }


    /* Class<T> type 으로 인해 List<PropertyQstDto[]>를 리턴한다 */
    private <T> List<T> changeJsonToDtoList2(String asString, Class<T> type) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> list = Arrays.asList(objectMapper.readValue(asString, type));
        return list;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PropertyLevelDto {
        Long levelSeq;
        String levelName;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PropertyQstDto {
        Long qstSeq;
        String qstName;
    }

}
