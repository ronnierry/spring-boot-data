package com.ronnie.data.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/9/1$ 15:33$
 * @Remark:
 */
@Data
@Table
@Entity
public class MemberOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goodsName;

    private Integer number;

    @JoinColumn(name = "member_id")
    @ManyToOne
    private Member member;

    @CreationTimestamp
    private Date creationTime;

}
