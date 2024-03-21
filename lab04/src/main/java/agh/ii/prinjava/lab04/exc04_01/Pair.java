package agh.ii.prinjava.lab04.exc04_01;

import java.util.Objects;

public class Pair<F,S> implements Cloneable {
    private F fst;
    private S snd;
    public Pair(F fst, S snd) {
        this.fst = fst;
        this.snd = snd;
    }


    public void setF (F fst){
        this.fst = fst;
    }
    public F getF(){
        return this.fst;
    }


    public void setS (S snd){
        this.snd = snd;
    }
    public S getS(){
        return this.snd;
    }

    @Override
    public String toString(){
        return ("First is: " + getF() + "\nSecond is: " + getS());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        };
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(fst, pair.fst) && Objects.equals(snd, pair.snd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fst, snd);
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

