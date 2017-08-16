package com.zoutly.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
abstract public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 4993247878775240224L;

//    @Id
//    @Column(name = "id", nullable = false)
//    protected long id;

    @Column(name = "created", nullable = false)
    protected Instant created;

    @Column(name = "created_by", nullable = false)
    protected long createdBy;

    @Column(name = "modified", nullable = false)
    protected Instant modified;

    @Column(name = "modified_by", nullable = false)
    protected long modifiedBy;

    public void setModification(User user) {
        long userId = user != null ? user.getId() : 0L; // 0L for SYSTEM
        Instant now = Instant.now();

        if(this.getCreated() == null) {
            this.created = now;
            this.createdBy = userId;
        }
        this.modified = now;
        this.modifiedBy = userId;
    }
}
