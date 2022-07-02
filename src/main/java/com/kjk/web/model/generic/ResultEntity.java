package com.kjk.web.model.generic;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * RestController Json 데이터 리턴용
 */
@Getter
@Setter
public class ResultEntity<T> implements Serializable {
    private static final long serialVersionUID = 5451991367034535082L;

    private String resultCd;
    private T data;

    public ResultEntity() {}

    public ResultEntity(String resultCd) {
        this.resultCd = resultCd;
    }

    public ResultEntity(String resultCd, T data) {
        this.resultCd = resultCd;
        this.data = data;
    }
}
