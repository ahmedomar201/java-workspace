package org.example.functionalprogramming.utils;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        final int result = ProcessIntegers(Calculator::add);

        System.out.println("result= " + result);

        final Employee employee = new Employee(
                "ahmed",
                "omar",
                28,
                "ahmedomar@gmail.com");
        final Employee employee1 = new Employee(
                "bbbbbb",
                "ccccccc",
                20,
                "bbbbccc@gmail.com");
        final Employee employee2 = new Employee(
                "kkkkkk",
                "lllll",
                21,
                "kkkkllll@gmail.com");

        final String emp = ProcessEmployee(Employee::buildFullName, employee1);
        System.out.println("emp111111111= " + emp);

        final Function<String, String> function = toFunction(Main::buildFullName, employee1);

//        final String info = Function.( "the");
//        System.out.println("info = " + info);
    }

    private static int ProcessIntegers(FirstFunctional functional) {

        return functional.apply(1, 2);
    }

    public static String ProcessEmployee(ToStringFromEmployee toStringFromEmployee, Employee employee) {

        return toStringFromEmployee.apply(employee);

    }

    public static String buildFullName(final Employee employee) {
        return employee.firstName() + " " + employee.secondName();
    }

    public static ToStringFromEmployee toStringFromEmployee(
            final String firstName,
            final String secondName,
            final int age,
            final String email
    ) {
        final Employee employee=new Employee(firstName,secondName,age,email);

        return Main::buildFullName;
    }

    public static <T> Function<T, String> toFunction(
            final Function<Employee, T> function,
            final Employee employee
    ) {
        final T t = function.apply(employee);

        return element -> "This is " + element + " " + t;
    }

}
