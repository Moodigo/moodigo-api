package com.zoutly.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "dummy")
@Table(name = "dummy",
        indexes = {@Index(columnList = "id", name = "dummy_idx", unique = true)})
@SequenceGenerator(name = "id_sequence", sequenceName = "dummy_seq", allocationSize = 1)
public class Dummy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @Column(name = "id", unique = true, nullable = false)
    long id;

    @NonNull
    @Column(length = 1024, nullable = false)
    String value;

}
