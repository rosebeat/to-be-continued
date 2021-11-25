package com.example.designpattern.factory;

/**
 * @author kai·yang
 * @Date 2021/11/25 14:05
 */
public class WhiteAnimalFactory implements  AnimalFactory{


    @Override
    public Cat createCat() {
        return new WhiteCat();
    }

    @Override
    public Dog createDog() {
        return new WhiteDog();
    }

}
