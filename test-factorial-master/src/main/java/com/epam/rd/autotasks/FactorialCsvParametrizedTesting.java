package com.epam.rd.autotasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialCsvParametrizedTesting {

    Factorial factorial = new Factorial();

    @ParameterizedTest
    @CsvFileSource(resources = "/csvCases.csv")
    void testFactorial(String input, String output){
//        assertEquals(input, factorial.factorial(output));
         assertEquals(output, factorial.factorial(input));

    }
}
