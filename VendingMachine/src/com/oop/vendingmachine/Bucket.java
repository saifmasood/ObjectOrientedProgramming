package com.oop.vendingmachine;

public class Bucket<E1,E2> {
    E1 first;
    E2 second;

    public void setFirst(E1 first) {
        this.first = first;
    }

    public void setSecond(E2 second) {
        this.second = second;
    }

    public E1 getFirst() {
        return first;
    }

    public E2 getSecond() {
        return second;
    }

    public Bucket(E1 first, E2 second) {
        this.first = first;
        this.second = second;
    }
}
