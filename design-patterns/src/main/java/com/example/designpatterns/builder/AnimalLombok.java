package com.example.designpatterns.builder;


public record AnimalLombok(
        String dog,
        String cat,
        String fox,
        int lion) {


    private AnimalLombok(AnimalBuilder builder) {
        this(builder.dog, builder.cat, builder.fox, builder.lion);
    }

    public static AnimalBuilder builder() {

        return new AnimalBuilder();


    }

    public static class AnimalBuilder {
        private String dog;
        private String cat;
        private String fox;
        private int lion;



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

        // convert Animal to AnimalBuilder to use
        public AnimalLombok build() {
            return new AnimalLombok(this);

        }

    }

}
