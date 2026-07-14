package com.example.datastructures.list;

import java.util.function.Consumer;

public class ConsumerImp<E> implements Consumer<E> {

    @Override
    public void accept(E e) {

//        System.out.print(e);

        if (((String)e).startsWith("A")){
            System.out.print(e);
        }

    }


}
