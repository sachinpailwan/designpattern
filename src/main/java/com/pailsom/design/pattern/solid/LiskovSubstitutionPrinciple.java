package com.pailsom.design.pattern.solid;

import com.sun.xml.internal.ws.api.pipe.Engine;

public class LiskovSubstitutionPrinciple {
    /**
     *
     * Liskov substitution principle :
     *   It was invented by Barbara Liskov
     *              - A famous computer Scientist
     *   It says 'you should be able to substitute sub class with a base class'
     *      'Derived types must be completely substitute able for their base class'
     */
    public static void main(String[] args) {

    }

    static class TransportationDevice{
            Engine engine;
            void startEngine(){

            }
    }
    static class  Car extends TransportationDevice{
        @Override
        void startEngine(){

        }
    }

    static class Bicycle extends TransportationDevice{

        @Override
        void startEngine(){
            // This is problem. Bicycle does not have engine.
        }
    }

    /***
     * Solution
     */

    class DeviceWithEngine extends TransportationDevice{

        void startEngine(){

        }
    }
    class DCar extends DeviceWithEngine{

    }
}
