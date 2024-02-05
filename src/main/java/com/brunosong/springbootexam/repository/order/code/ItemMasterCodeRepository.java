package com.brunosong.springbootexam.repository.order.code;


import com.brunosong.springbootexam.entity.order.code.ItemMasterCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemMasterCodeRepository extends JpaRepository<ItemMasterCode,Long> {

    Optional<ItemMasterCode> findByMasterCode(String masterCode);

    @Query("select m from ItemMasterCode m where m.masterCode in :masterCodeList")
    List<ItemMasterCode> findByMasterCode(List<String> masterCodeList);



}
