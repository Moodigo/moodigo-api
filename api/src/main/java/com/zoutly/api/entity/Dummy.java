package com.zoutly.api.entity;

import lombok.*;

@Data
public class Dummy extends BaseEntity {

    @NonNull
    long id;

    @NonNull
    String value;
}
