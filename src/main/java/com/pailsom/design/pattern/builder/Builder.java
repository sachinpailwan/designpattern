package com.pailsom.design.pattern.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Builder {
    public static void main(String[] args) {
        HtmlBuilder htmlBuilder = new HtmlBuilder("html");
        htmlBuilder.addChild("p","sachin");
        htmlBuilder.addChild("ui","sadsa");
        System.out.println(htmlBuilder.toString());
    }
    static class HtmlElement{
        private String name,text;
        private int indent = 2;
        private List<HtmlElement> htmlElements = new ArrayList<>();

        public HtmlElement(){

        }
        public HtmlElement(String name, String childText) {
            this.name=name;
            this.text=childText;
        }

        private String toStringImpl(int indent){
            StringBuilder sb = new StringBuilder();
            String i = String.join("", Collections.nCopies(indent," "));
            sb.append(String.format("%s<%s>%s",i,name,"\n"));
            if(text!=null && !text.isEmpty()){
                //sb.append(String.join("",Collections.nCopies(indent+1," ")));
                //sb.append(text).append("\n");
            }

            htmlElements.forEach(e->sb.append(e.toStringImpl(indent+1)));
            sb.append(String.join("", Collections.nCopies(indent," ")));
            sb.append(String.format("%s<%s>%s",i,name,"\n"));
            return sb.toString();
        }

        @Override
        public String toString(){
            return toStringImpl(indent);
        }
    }
    static class HtmlBuilder{
        private String rootName;
        private HtmlElement root = new HtmlElement();
        HtmlBuilder(String rootName){
            this.rootName=rootName;
            this.root.name=rootName;
        }

        public void addChild(String name,String childText){
            HtmlElement e = new HtmlElement(name,childText);
            root.htmlElements.add(e);
        }

        @Override
        public String toString(){
            return root.toStringImpl(0);
        }

    }
}
