package com.zoutly.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.Instant;

@Data
@NoArgsConstructor
public class Entity {

    @Id
    @Column(name = "id", nullable = false)
    @NonNull
    long id;

    @Column(name = "created", nullable = false)
    @NonNull
    Instant created;

    // TODO history or just last?
//    Instant modified;
//    String modifiedBy;
}
