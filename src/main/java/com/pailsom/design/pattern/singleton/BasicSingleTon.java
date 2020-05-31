package com.pailsom.design.pattern.singleton;

import lombok.Data;

import java.io.*;

@Data
public class BasicSingleTon implements Serializable {
    static private BasicSingleTon instance = null;
    private int value;

    public static BasicSingleTon getInstance(){
        if(instance==null){
            instance = new BasicSingleTon();
        }
        return instance;
    }

    protected Object readResolve(){
        return instance;
    }

    public static void main(String[] args) throws Exception{
        //1. reflection
        //2. serialization
        BasicSingleTon basicSingleTon = BasicSingleTon.getInstance();
        basicSingleTon.setValue(111);
        save(basicSingleTon,"basicSingleTon.obj");
        basicSingleTon.setValue(222);
        BasicSingleTon basicSingleTon1 = read("basicSingleTon.obj");
        System.out.println(basicSingleTon==basicSingleTon1);
        System.out.println(basicSingleTon.getValue());
        System.out.println(basicSingleTon1.getValue());

    }
    public static void save(BasicSingleTon singleTon,String fileName) throws Exception{
        try(FileOutputStream outputStream = new FileOutputStream(fileName);
            final ObjectOutputStream out = new ObjectOutputStream(outputStream)){
            out.writeObject(singleTon);
        }
    }

    public static BasicSingleTon read(String fileName) throws Exception{
        try(final FileInputStream inputStream = new FileInputStream(fileName);
            final ObjectInputStream in = new ObjectInputStream(inputStream)){
            return (BasicSingleTon) in.readObject();
        }
    }
}
