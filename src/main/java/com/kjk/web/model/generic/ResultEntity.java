package com.kjk.web.model.generic;

import java.io.Serializable;

/**
 * RestController Json 데이터 리턴용
 */
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

    public String getResultCd() {
        return resultCd;
    }

    public void setResultCd(String resultCd) {
        this.resultCd = resultCd;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
