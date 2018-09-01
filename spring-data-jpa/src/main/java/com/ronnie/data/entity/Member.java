package com.ronnie.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/8/31$ 10:06$
 * @Remark:
 */
@Data
@Table
@Entity
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

}
