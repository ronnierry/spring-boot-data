package com.ronnie.data.document;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/9/1$ 14:25$
 * @Remark:
 */
@Data
@Document
public class Member {
    private Long memberId;

    private String username;

    private String password;
}
