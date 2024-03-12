package com.brunosong.springbootexam.codems.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemMasterCodeRepository extends JpaRepository<ItemMasterCodeEntity,Long> {

    Optional<ItemMasterCodeEntity> findByMasterCode(String masterCode);

    @Query("select m from ItemMasterCodeEntity m where m.masterCode in :masterCodeList")
    List<ItemMasterCodeEntity> findByMasterCode(List<String> masterCodeList);

}
