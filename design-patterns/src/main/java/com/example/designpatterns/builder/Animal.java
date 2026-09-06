package com.example.designpatterns.builder;


public class Animal {
  private final String dog;
  private final String cat;
  private final String fox;
  private final int lion;

    private Animal(AnimalBuilder builder) {
        this.dog = builder.dog;
        this.cat = builder.cat;
        this.fox = builder.fox;
        this.lion = builder.lion;
    }

    public static AnimalBuilder builder() {

        return new AnimalBuilder();

    }

    public static class AnimalBuilder {
        String dog;
        String cat;
        String fox;
        int lion;


        public AnimalBuilder dog(String dog) {
            this.dog = dog;
            return this;
        }

        public AnimalBuilder cat(String cat) {
            this.cat = cat;
            return this;
        }

        public AnimalBuilder fox(String fox) {
            this.fox = fox;
            return this;
        }

        public AnimalBuilder lion(int lion) {
            this.lion = lion;
            return this;
        }

        public Animal build() {
            return new Animal(this);

        }

    }


}
