package com.brunosong.springbootexam.codems.repository;

import com.brunosong.springbootexam.orderms.repository.UseYnEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item_master_code")
@Getter
@NoArgsConstructor
public class ItemMasterCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "master_code_seq")
    private Long masterCodeSeq;

    @Column(name = "master_code")
    private String masterCode; // '코드'

    @Column(name = "master_name")
    private String masterCodeName;

    @OneToMany(mappedBy = "itemMasterCodeEntity", fetch = FetchType.LAZY)
    private List<ItemDetailCodeEntity> itemList = new ArrayList<>();

    @ColumnDefault(value = "'Y'")
    @Enumerated(EnumType.STRING)
    @Column(name = "use_yn")
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
    public ItemMasterCodeEntity(Long masterCodeSeq, String masterCode, String masterCodeName, List<ItemDetailCodeEntity> itemList, UseYnEnum useYn, LocalDateTime createDateTime, String createId, String createIp, LocalDateTime updateDateTime, String updateId, String updateIp) {
        this.masterCodeSeq = masterCodeSeq;
        this.masterCode = masterCode;
        this.masterCodeName = masterCodeName;
        this.itemList = itemList;
        this.useYn = useYn;
        this.createDateTime = createDateTime;
        this.createId = createId;
        this.createIp = createIp;
        this.updateDateTime = updateDateTime;
        this.updateId = updateId;
        this.updateIp = updateIp;
    }
}
