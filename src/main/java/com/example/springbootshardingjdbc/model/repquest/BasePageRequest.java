package com.example.springbootshardingjdbc.model.repquest;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: BasePageRequest.java, v 0.1 2019年11月21日 9:38 wb-wys567063 Exp $
 */
@Data
public class BasePageRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer pageSize;
    private Integer pageIndex;
}
