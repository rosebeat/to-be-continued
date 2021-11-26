package com.example.designpattern.factory_pattern;

/**
 * @author kai·yang
 * @Date 2021/11/25 14:29
 */
public class Test {

    public static void main(String[] args) {
        AnimalFactory whiteAnimal = new WhiteAnimalFactory();
        Cat whitecat = whiteAnimal.createCat();
        Dog whitedog = whiteAnimal.createDog();
        System.out.print("一只名叫：");whitecat.name();whitecat.sex();System.out.print("正在");whitecat.eat();

        System.out.print("一只名叫：");whitedog.name();whitedog.sex();System.out.print("正在");whitedog.eat();

    }
}
