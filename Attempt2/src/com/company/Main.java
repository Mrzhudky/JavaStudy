package com.company;

//接口与多态
public class Main extends Clowns{

    public static void main(String[] args) {
	// write your code here
        Nose []obj = new Nose[3];
        obj[0] = new Acts();
        obj[1] = new Clowns();
        obj[2] = new Main();
        for(int i=0;i<3;i++){
            System.out.println(obj[i].iMethod() + " " + obj[i].getClass());
        }
    }
}

interface Nose{
    public int iMethod();
}

abstract class Picasso implements Nose{
    public int iMethod(){
        return 7;
    }
}

class Clowns extends Picasso{}

class Acts implements Nose{
    public int iMethod(){
        return 5;
    }
}