package com.jow.employeeservice.practice;

import java.util.Arrays;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        //create a list of string with empty

        List<String> employees = Arrays.asList("Bageeradha","Sivani","Santosh","Ram","");

        //print only empty list count

        long emptyCount = employees.stream()
                .filter(String::isEmpty).count();

       // employees.stream().filter()

        System.out.println(emptyCount);
    }
}
