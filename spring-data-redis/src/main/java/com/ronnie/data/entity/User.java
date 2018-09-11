package com.ronnie.data.entity;

import lombok.Data;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/9/10$ 14:06$
 * @Remark:
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
}
