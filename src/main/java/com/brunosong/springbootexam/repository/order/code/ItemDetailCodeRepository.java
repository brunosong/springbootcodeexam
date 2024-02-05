package com.brunosong.springbootexam.repository.order.code;


import com.brunosong.springbootexam.entity.order.code.ItemDetailCode;
import com.brunosong.springbootexam.entity.order.code.ItemMasterCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemDetailCodeRepository extends JpaRepository<ItemDetailCode,Long> {
}
