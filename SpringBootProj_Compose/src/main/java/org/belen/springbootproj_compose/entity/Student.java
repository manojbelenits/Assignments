package org.belen.springbootproj_compose.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sId;

    @NonNull
    @Column(length = 10)
    private String sName;

    @NonNull
    @Column(length = 10)
    private String sLoc;

}
