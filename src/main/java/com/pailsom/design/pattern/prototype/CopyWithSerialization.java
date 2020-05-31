package com.pailsom.design.pattern.prototype;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class CopyWithSerialization {
    public static void main(String[] args) {

        Foo foo = new Foo("some","other");
        Foo copyFoo = SerializationUtils.roundtrip(foo);
        foo.stuff="another";
        System.out.println(foo);
        System.out.println(copyFoo);
    }
    @Data
    @ToString
    static class Foo implements Serializable {
        String stuff,Whatever;

        public Foo(String stuff, String whatever) {
            this.stuff = stuff;
            Whatever = whatever;
        }
    }
}
