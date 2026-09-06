package com.example.designpatterns.builder;

public class Main {
    public static void main(String[] args) {

//        Address address =new Address("slam","helwan","Cairo",12345);
        Address2 address2 = new Address2
                ("slam", "helwan", "Cairo", 12345);

        final Address address =
                Address.builder().
                        street("mohy").city("cairo").state("dddd").zip(1).build();


        final Animal animal =
                Animal.builder().dog("dooog").cat("caaaaaaat").fox("fooooox").lion(1).build();


//
//        address.setStreet("slam");
//        address.setCity("helwan");
//        address.setState("Cairo");
//        address.setZip(12345);

        System.out.println(animal);
//        System.out.println("address2.getStreet:" + address2.street());
//        System.out.println("address2.getCity:" + address2.city());
//        System.out.println("address2.getState:" + address2.state());
//        System.out.println("address2.getZip:" + address2.zip());

    }
}