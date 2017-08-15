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
@SequenceGenerator(name = "id_sequence", sequenceName = "dummy_seq", allocationSize = 1)
public class Dummy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @Column(name = "dummy_id", unique = true, nullable = false)
    private long id;

    @NonNull
    @Column(length = 1024, nullable = false)
    private String value;

}
