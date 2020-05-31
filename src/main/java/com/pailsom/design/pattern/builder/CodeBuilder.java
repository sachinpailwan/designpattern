package com.pailsom.design.pattern.builder;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.ArrayList;
import java.util.List;

public class CodeBuilder {
    private String className;
    private List<Field> fields = new ArrayList<>();

    public CodeBuilder(String className){
        this.className = className;
    }

    public CodeBuilder addField(String type,String name){
        fields.add(new Field(type,name));
        return this;
    }
    public CodeBuilder addField(String type,String name,String defaultValue){
        fields.add(new Field(type,name,defaultValue));
        return this;
    }

    public static void main(String[] args) {
        CodeBuilder codeBuilder = new CodeBuilder("Person");
        codeBuilder.addField("String","name")
                .addField("int","age")
        .addField("String","surname","pailwan");
        System.out.println(codeBuilder.toString());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("class").append(" ").append(className).append(" ").append("{").append("\n");
        fields.forEach(f->sb.append(f.toString()).append("\n"));
        sb.append("}");
        return sb.toString();
    }

    class Field {
        private String type;
        private String name;
        private String defaultValue;

        public Field(String type, String name) {
            this.type = type;
            this.name = name;
        }

        public Field(String type, String name, String defaultValue) {
            this.type = type;
            this.name = name;
            this.defaultValue = defaultValue;
        }

        @Override
        public String toString() {
            if(defaultValue!=null)
                return String.format("\tprivate %s  %s = %s;",type,name,defaultValue);
            return String.format("\tprivate %s  %s;",type,name);
        }
    }

}
