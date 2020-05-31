package com.pailsom.design.pattern.solid;

public class InterfaceSegregationPrinciple {
    /**
     * Interface segregation principle ISP.
     * it is recommendation how to split interfaces into smaller interfaces
     */
    public static void main(String[] args) {

    }
    class Document {

    }
    interface Machine{
        void print(Document document);
        void fax(Document document);
        void scan(Document document);
    }

    class MultiFunctionPrinter implements Machine{
        @Override
        public void print(Document document) {

        }

        @Override
        public void fax(Document document) {

        }

        @Override
        public void scan(Document document) {

        }
    }

    /**
     * Here is problem with old fashioned printer.
     * Old fashioned printer does not have fax and scan functionality.
     * This could be violation of ISP.
     * Simple solution to has divide machine interface into 3 smaller interface
     * for print, fax and scan interfaces. And let MultiFunctionPrinter would implements all
     * those 3 interface. But old fashioned printer must implement print interface
     */
    class OldFashionedPrinter implements Machine{
        @Override
        public void print(Document document) {

        }

        @Override
        public void fax(Document document) {

        }

        @Override
        public void scan(Document document) {

        }
    }

    interface Printer {
        void print();
    }
    interface Scanner{
        void scan();
    }

    class JustAPrinter implements Printer{
        @Override
        public void print() {

        }
    }

    interface MultiFunctionDevice extends Printer,Scanner{

    }

    /**
     * Decorator pattern
     */
    class SMultiFunctionMachine implements MultiFunctionDevice{
        private Printer printer;
        private Scanner scanner;

        public SMultiFunctionMachine(Printer printer, Scanner scanner) {
            this.printer = printer;
            this.scanner = scanner;
        }

        @Override
        public void print() {
            printer.print();
        }

        @Override
        public void scan() {
            scanner.scan();
        }
    }
}
