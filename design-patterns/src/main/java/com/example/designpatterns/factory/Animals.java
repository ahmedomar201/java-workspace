package com.example.designpatterns.factory;

public enum Animals {

    Lion("lion"),
    Dog("dog");
    private String type;

    Animals(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Animals fromType(String type) throws IllegalArgumentException {
        for (Animals animals : Animals.values()) {
            if (type.getType().equalsIgnoreCase(animals.getType())) {
                return animals;
            }
        }
        throw new IllegalArgumentException("No such animals with type " + type);
    }
}
