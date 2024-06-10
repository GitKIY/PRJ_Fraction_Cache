package ru.example;

public class TestFraction implements Fractionable{
    int num, denum;
    int count;

    public TestFraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
        this.count = 0;
    }

    @Mutator
    public void setNum(int num) {
        this.num = num;
    }

    @Mutator
    public void setDenum(int denum) {
        this.denum = denum;
    }

    @Override
    @Cache
    public double doubleValue() {
        count++;
        return (double) num/denum;
    }
    @Override
    @Cache
    public double doubleMult() {
        count++;
        return (double) num*denum;
    }

    @Override
    public String toString() {
        count++;
        return "TestFraction{" +
                "num=" + num +
                ", denum=" + denum +
                ", count=" + count +
                '}';
    }
}
