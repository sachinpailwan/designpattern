package com.pailsom.design.pattern.prototype;

import lombok.Data;
import lombok.ToString;

public class CopyConstructor {
    public static void main(String[] args) {
        Address address = new Address("E-3","Bibvewadi Road","Pune");
        Address address1 = new Address(address);
        address1.building="E-4";
        System.out.println(address);
        System.out.println(address1);
    }
    @Data
    @ToString
    static class Address {
        private String building,street,city;

        public Address(String building, String street, String city) {
            this.building = building;
            this.street = street;
            this.city = city;
        }

        public Address(Address address){
            this(address.building,address.street,address.city);
        }
    }
}
