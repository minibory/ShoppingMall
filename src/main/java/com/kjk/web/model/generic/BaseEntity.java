package com.kjk.web.model.generic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 7570350685079133673L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
