package com.zoutly.core.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.Instant;

@Data
public class Entity {

    @Id
    @Column(name = "id", nullable = false)
    @NonNull
    long id;

    @Column(name = "created", nullable = false)
    @NonNull
    Instant created;

    @Column(name = "created_by", nullable = false)
    @NonNull
    String createdBy;

    @Column(name = "modified", nullable = false)
    @NonNull
    Instant modified;

    @Column(name = "modified_by", nullable = false)
    @NonNull
    String modifiedBy;
}
