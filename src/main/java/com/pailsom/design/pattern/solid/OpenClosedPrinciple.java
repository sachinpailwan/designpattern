package com.pailsom.design.pattern.solid;

import com.sun.glass.ui.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class OpenClosedPrinciple {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                Product.builder().color(Color.BLACK)
                        .name("Black Product")
                        .size(new Size(10, 20))
                        .build(),
                Product.builder().color(Color.WHITE)
                        .name("Black Product")
                        .size(new Size(100, 100))
                        .build(),
                Product.builder().color(Color.BLACK)
                        .name("Black Product")
                        .size(new Size(100, 100))
                        .build()

        );
        BetterFilter betterFilter = BetterFilter.builder().products(products).build();
        Specification<Product> blackColourSpecification = new Specification<Product>() {
            @Override
            public boolean isSatisfied(Product item) {
                return item.color==Color.BLACK;
            }
        };

        Specification<Product> colourAndSizeSpecification = new Specification<Product>() {
            @Override
            public boolean isSatisfied(Product item) {
                return item.color==Color.BLACK && item.size.width==100 && item.size.height==100;
            }
        };

        betterFilter.filter(blackColourSpecification).forEach(System.out::print);
        System.out.println();
        System.out.println("Color And Size Filter :");
        betterFilter.filter(colourAndSizeSpecification).forEach(System.out::println);

    }

    @Data
    @Builder
    @ToString
    static class Product {
        private String name;
        private Color color;
        private Size size;
    }

    /**
     * Open closed principle says. Class should be open for extension but closed for modification
     * If we get more filter requirements then we eventually will end up in adding multiple methods
     * to Product Filter class. Which is not good.
     * So we will solve this by introducing filter with specifications approach
     */
    static class ProductFilter {
        public Stream<Product> filterByColor(List<Product> productList, final Color color) {
            return productList.stream().filter(p -> p.color == color);
        }

        public Stream<Product> filterBySize(List<Product> productList, final Size size) {
            return productList.stream().filter(p -> p.size == size);
        }

        public Stream<Product> filterByColorAndSize(List<Product> products, final Size size, final Color color) {
            return products.stream().filter(p -> p.color == color && p.size == size);
        }
    }

    interface Specification<T> {
        boolean isSatisfied(T item);
    }

    interface Filter<T> {
        Stream<T> filter(Specification specification);
    }

    @Data
    @Builder
    static class BetterFilter implements Filter<Product>{

        private List<Product> products;


        @Override
        public Stream<Product> filter(Specification specification) {
            return products.stream().filter(specification::isSatisfied);
        }
    }
}
