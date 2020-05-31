package com.pailsom.design.pattern.solid;

import com.sun.org.apache.regexp.internal.RE;
import lombok.Data;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;

public class DependencyInversionPrinciple {

    /**
     * A. High level module should not be depend on low-level modules.
     * Both should depend on abstraction
     *
     * B.Abstraction should not depend on details.
     * Details should depend on abstractions.
     */
    public static void main(String[] args) {

    }
    enum RelationShip{
        PARENT,CHILD,SIBLING
    }
    @Data
    static class Person {
        String name;
    }

    class RelationShips{
        List<Triplet<Person,RelationShip,Person>> tripletList = new ArrayList<>();

        public void addParentChild(Person parent,Person child){
            tripletList.add(new Triplet<>(parent,RelationShip.CHILD,child));
            tripletList.add(new Triplet<>(child,RelationShip.PARENT,parent));
        }
    }

    class Research {

        /**
         * Relationship class exposing relationship list to outside world.
         * @param tripletList
         */
        public Research(List<Triplet<Person, RelationShip,Person>> tripletList){
            long count = tripletList.stream().filter(t->t.getValue0().getName().equalsIgnoreCase("John"))
                    .filter(t->t.getValue1()==RelationShip.PARENT).count();
            System.out.println(count);
        }
    }


}

