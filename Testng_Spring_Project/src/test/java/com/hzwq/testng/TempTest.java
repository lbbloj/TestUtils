package com.hzwq.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TempTest extends a{

    @BeforeMethod
    public void test01(){
        System.out.println(2345);
    }

    @Test
    public void test0(){

        System.out.println(this);
    }


}

class a {
    {
        System.out.println("b");
    }

    public a(){

        System.out.println(this);
        System.out.println("a");
    }
}
