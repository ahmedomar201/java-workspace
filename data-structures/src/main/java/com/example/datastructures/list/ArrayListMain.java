package com.example.datastructures.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ArrayListMain {

    public static void main(String[] args) {


        List<String> names = new ArrayList<>();
        List<String> surnames = new ArrayList<>();

        names.add("Ahmed");
        names.add("Bob");
        names.add("Mohamed");
        names.add("Jimmy");
        names.set(1,"Ronaldo");
        names.add(2,"Mahmoud");

        surnames.add("Olise");
        surnames.add("ali");
        names.addAll(surnames);

        //    names.remove("Olise");

//    names.removeAll(Arrays.asList("Olise"));

//    System.out.println(names);
//
//
//    printNME("b","a");

        List<String> ahmed =List.of("Ahmed","Bob","Mohamed","Jimmy");

//    System.out.println(ahmed);


//        Iterator<String> iterator = ahmed.iterator();
//        while(iterator.hasNext()){
//        System.out.println(iterator.next());
//        }



//        Consumer<String> consumerImp = new ConsumerImp<>();
//        names.forEach(consumerImp);

//    Consumer<String> consumerImp = new Consumer<>() {
//
//        @Override
//        public void accept(String name) {
//
//            if (name.startsWith("A")){
//                System.out.println(name);
//        }
//
//    }
//    };

//
//        Consumer<String> consumerImp =  (String name) ->{
//
//
//                if (name.startsWith("A")){
//                    System.out.println(name);
//                }
//
//            };



//    names.forEach( name->printNMEForeach(name ));

    //==

        names.forEach(ArrayListMain::printNMEForeach);



    }
    public static void printNMEForeach(String name){

        if (name.startsWith("A")){
            System.out.println(name);
        }


    }


    public static void printNM(String...parmters){

        for (String s : parmters) {
            System.out.println(s);
        }


    }

}
