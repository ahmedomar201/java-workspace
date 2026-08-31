package com.example.universitytask.models.dtos.requests;

import lombok.*;

import java.util.Objects;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@AllArgsConstructor
//@NoArgsConstructor
@Data
//@ToString(onlyExplicitlyIncluded = true)
//@ToString(of = {"street","city"})
@ToString(exclude = {"street","city"})
public class Address {
    private String street;
//    @ToString.Exclude
    private String city;
//    @ToString.Include
    private String state;
    private int zip;


}
