package com.zoutly.core.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.Instant;

@Data
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    protected long id;

    @Column(name = "created", nullable = false)
    @NonNull
    protected Instant created;

    @Column(name = "created_by", nullable = false)
    @NonNull
    protected String createdBy;

    @Column(name = "modified", nullable = false)
    @NonNull
    protected Instant modified;

    @Column(name = "modified_by", nullable = false)
    @NonNull
    protected String modifiedBy;
}
