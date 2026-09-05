package com.example.universitytask.models.dtos.requests;

import lombok.*;

import java.util.Objects;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@ToString(onlyExplicitlyIncluded = true)
//@ToString(of = {"street","city"})
//@ToString(exclude = {"street","city"})
@Value
@RequiredArgsConstructor
public class Address {
    String street;
    //    @ToString.Exclude
    String city;
    //    @ToString.Include
    String state;
    int zip;
}




