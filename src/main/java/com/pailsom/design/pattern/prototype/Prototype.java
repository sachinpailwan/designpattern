package com.pailsom.design.pattern.prototype;

import lombok.Data;
import lombok.ToString;

public class Prototype {
    public static void main(String[] args) throws Exception {

        Person john = new Person(new String[]{"john","smith"},
                new Address("London Road","123"));
        Person jane = (Person) john.clone();
        jane.names[0]="Jane";
        System.out.println(john);
        System.out.println(jane);

    }
    @Data
    @ToString
    static class Address implements Cloneable{
        private String streetName;
        private String houseName;

        public Address(String streetName, String houseName) {
            this.streetName = streetName;
            this.houseName = houseName;
        }

        @Override
        public Address clone() throws CloneNotSupportedException{
            return new Address(streetName,houseName);
        }
    }
    @Data
    @ToString
    static class  Person implements Cloneable{
        String [] names;
        Address address;

        public Person(String[] names, Address address) {
            this.names = names;
            this.address = address;
        }

        @Override
        public Object clone()throws  CloneNotSupportedException{
            return new Person(names.clone(),(Address)address.clone()) ;
        }
    }
}
