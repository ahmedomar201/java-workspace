package com.example.designpatterns.builder;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

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
//@Value
//@RequiredArgsConstructor
@Builder
public class Address {
    String street;
    //    @ToString.Exclude
    String city;
    //    @ToString.Include
    String state;
    int zip;
}




