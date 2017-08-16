package com.zoutly.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor()
@Entity(name = "dummy")
@Table(name = "dummy",
        indexes = {@Index(columnList = "dummy_id", name = "dummy_idx", unique = true)})
public class Dummy extends BaseEntity {

    private static final long serialVersionUID = -1219284328957406785L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_sequence")
    @SequenceGenerator(name = "id_sequence", sequenceName = "dummy_seq", allocationSize = 1)
    @Column(name = "dummy_id", unique = true, nullable = false, updatable = false)
    private long id;

    @NonNull
    @Column(length = 1024, nullable = false)
    private String value;

}
