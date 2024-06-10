package ru.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CacheTests {
    @Test
    public void testNoCacheMethods(){
        TestFraction fr = new TestFraction(5,2);
        Fractionable num = Utils.cache(fr);
        num.toString(); //++
        num.toString(); //++
        num.toString(); //++
        Assertions.assertEquals(fr.count,3);
    }
    @Test
    public void testCacheMethod(){
        TestFraction fr = new TestFraction(5,2);
        Fractionable num = Utils.cache(fr);
        num.doubleValue();  //++
        num.toString();     //++
        num.doubleValue();
        num.toString();     //++
        num.doubleValue();
        num.doubleMult();   //++
        num.toString();     //++
        num.doubleMult();
        Assertions.assertEquals(fr.count,5);
    }
    @Test
    public void testResetCache(){
        TestFraction fr = new TestFraction(5,2);
        Fractionable num = Utils.cache(fr);
        num.doubleValue();  //++
        num.doubleValue();
        num.doubleValue();
        num.setNum(10);
        num.doubleValue();     //++
        num.doubleValue();
        num.doubleValue();
        num.setDenum(5);
        num.doubleValue();     //++
        num.doubleValue();
        num.doubleValue();
        Assertions.assertEquals(fr.count,3);
    }
}
