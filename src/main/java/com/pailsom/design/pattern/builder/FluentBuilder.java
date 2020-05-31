package com.pailsom.design.pattern.builder;

public class FluentBuilder {
    public static void main(String[] args) {
        System.out.println(new PersonBuilder().forName("sachin").age(35).build());
    }
    static class Person {
        private String name;
        private int age;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    static class Employee extends Person{

    }
    static class PersonBuilder<T extends Person>{
        private Person person = new Person();
        PersonBuilder(){

        }
        public PersonBuilder forName(String name){
            person.name=name;
            return this;
        }

        public PersonBuilder age(int age){
            person.age=age;
            return this;
        }

        private Person build(){
            return person;
        }
    }
}
