package com.brunosong.springbootexam.entity.order.code;


import com.brunosong.springbootexam.entity.order.orderenum.UseYnEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "item_detail_code")
@NoArgsConstructor
public class ItemDetailCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailCodeSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "masterCodeSeq")
    private ItemMasterCode itemMasterCode;

    private String itemCode;

    private String itemName;

    private Integer orders;

    @ColumnDefault(value = "'Y'")
    @Enumerated(EnumType.STRING)
    private UseYnEnum useYn; //'사용여부'

    @CreationTimestamp
    private LocalDateTime createDateTime;
    private String createId;
    private String createIp;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    private String updateId;
    private String updateIp;

    @Builder
    public ItemDetailCode(Long detailCodeSeq, ItemMasterCode itemMasterCode, String itemCode, String itemName, Integer orders, UseYnEnum useYn, LocalDateTime createDateTime, String createId, String createIp, LocalDateTime updateDateTime, String updateId, String updateIp) {
        this.detailCodeSeq = detailCodeSeq;
        this.itemMasterCode = itemMasterCode;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.orders = orders;
        this.useYn = useYn;
        this.createDateTime = createDateTime;
        this.createId = createId;
        this.createIp = createIp;
        this.updateDateTime = updateDateTime;
        this.updateId = updateId;
        this.updateIp = updateIp;
    }
}
