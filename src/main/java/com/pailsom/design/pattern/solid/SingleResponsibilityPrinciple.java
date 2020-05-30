package com.pailsom.design.pattern.solid;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Employee employee = Employee.builder()
                .empNo(101)
                .empName("Sachin Pailwan")
                .salary(12000).build();
        EmailContent textContent = EmailContent
                .builder()
                .content("Hi All, i will be out of office tomorrow 31/5/2020.")
                .type("text").build();
        EmailContent xmlContent = EmailContent
                .builder().content("<employee>" +
                        "<empNo>1012</empNo>" +
                        "<empName>Somnath Pailwan</empName>" +
                        "<salaray>12000</salary>" +
                        "</employee>")
                .type("xml")
                .build();

        EmailSender emailSender = new EmailSender();
        emailSender.sendEmail(employee, textContent);
        emailSender.sendEmail(employee, xmlContent);
    }

    @Data
    @Builder
    @ToString
    static class Employee {
        private int empNo;
        private String empName;
        private double salary;

        /*
        This method implementation would violate SRP principle.

        public void sendMail(Employee toEmployee, String content){

        }*/
    }

    @Data
    @Builder
    @ToString
    static class EmailContent {
        private String type;
        private String content;

    }

    @Data
    static
    class EmailSender {

        public boolean sendEmail(Employee toEmployee, EmailContent content) {
            // logic to send mail
            System.out.println("Sending email to Employee :"+toEmployee+" with email content :"+content);
            return true;
        }
    }
}
