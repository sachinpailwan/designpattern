package com.pailsom.design.pattern.factory;

public class AbstractFactory {
    public static void main(String[] args) {

    }

    interface HotDrink{
        void consume();
    }
    class Tea implements HotDrink{
        @Override
        public void consume() {
            System.out.println("This tea is very test");
        }
    }
    class Coffee implements HotDrink{
        @Override
        public void consume() {
            System.out.println("This coffee is very delicious");
        }
    }
    interface HotDrinkFactory{

    }
}
