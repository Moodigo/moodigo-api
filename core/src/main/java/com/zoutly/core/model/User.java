package com.zoutly.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
@Table(name = "user_table", // user is reserved keyword
        indexes = {@Index(columnList = "user_id", name = "user_idx", unique = true)})
@SequenceGenerator(name = "id_sequence", sequenceName = "user_seq", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    @Column(name = "user_id", unique = true, nullable = false)
    private long id;

    @NonNull
    @Column(name = "first_name", length = 1024, nullable = false)
    private String firstName;

    @NonNull
    @Column(name = "last_name", length = 1024, nullable = false)
    private String lastName;

}
