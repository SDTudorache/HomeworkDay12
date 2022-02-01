package com.endava.calculator;

import com.endava.calculator.Basic.Basic;
import com.endava.calculator.Basic.BasicOperations;
import com.endava.calculator.Expert.Expert;
import com.endava.calculator.Expert.ExpertOperations;
import com.endava.extensions.TestREporterExtension;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(TestREporterExtension.class)
public class CalculatorTestIT {
    private BasicOperations basic;
    private ExpertOperations expertOperations;
    private static final Logger LOGGER = LogManager.getLogger(CalculatorTestIT.class);

    @BeforeAll
    public static void setUpAllTests() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDownAllTest() {
        System.out.println("After All");
    }

    @BeforeEach
    public void setUpEachTest() {
        System.out.println("\nBefore Each");
        basic = new Basic();
        expertOperations = new Expert();
    }

    @AfterEach
    public void tearDownEachTest() {
        System.out.println("After Each\n");
    }

    @Tags({@Tag("smoke"), @Tag("ui")})
    @ParameterizedTest
    @MethodSource("numberProvider")
    public void shouldAddNumberGivenOperand0(int a, int b, long expected) {
        //GIVEN

        //WHEN
        long result = basic.add(a, b);
        //THEN
        assertThat(result, is(expected));

    }

    public static List<Arguments> numberProvider() {
        List<Arguments> argumentsList = new ArrayList<>();
        argumentsList.add(Arguments.of(2, 0, 2));
        argumentsList.add(Arguments.of(0, 2, 2));
        return argumentsList;
    }

    @Tag("smoke")
    @Test
    public void shouldAddNegativeNumbers() {
        //GIVEN

        //WHEN
        Integer result = basic.add(-2, -4);
        //THEN
        assertEquals(-6, result);
        assertTrue(result.equals(-6));
    }

    @Test
    @DisplayName("test that adds a big number as : MAX INT ")
    public void shouldAddBigNumbers() {
        assertThrows(AssertionError.class,()-> {
            //GIVEN

            //WHEN
            long result = basic.add(Integer.MAX_VALUE, 1);

            //THEN
            assertThat(result, is(Integer.MAX_VALUE + 1L));
            assertThat(result, lessThan(0L));
            assertThat(result, notNullValue());
        });

    }

    @ParameterizedTest
    @CsvSource({"1,2,3,6","2,4,5,11"})
    @CsvFileSource(resources = "numberSource.csv")
    public void shouldAddMoreThan2Operands(int a1, int a2, int a3, Long expected) {
        //GIVEN

        //WHEN
        long result = basic.add(a1, a2, a3);
        //THEN
        assertThat(result,is(expected));
    }

    @Test
    public void shouldAddNoOperands() {
        //GIVEN

        //WHEN
        Integer result = basic.add();
        //THEN
        assertThat(result,is(equalTo(0)));
        assertThat(result,is(notNullValue()));
        assertThat(result,greaterThanOrEqualTo(0));
    }

    @Test
    public void shouldAdd1Operands() {
        //GIVEN

        //WHEN
        long result = basic.add(167L);
        //THEN
        assertThat(result,is(equalTo(167L)));
        assertThat(result,is(notNullValue()));
    }
    //MULTIPLY


    @Tag("smoke")
    @Test
    public void shouldMultiplyWithNegativeNumbers() {
        //GIVEN

        //WHEN
        long result = basic.multiply(-2, -4);
        //THEN
        assertEquals(8L, result);
        assertEquals(8L, is(greaterThanOrEqualTo(8L)));
    }

    @Test
    public void shouldMultiplyWithGiven0Number() {
        //GIVEN

        //WHEN
        double result = basic.multiply(0.0, 12.1);
        //THEN
        assertThat(result,lessThanOrEqualTo (0.1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "numberSource2.csv")
    public void shouldMultiplyMoreThan2Operands(int a1, int a2, int a3, Long exp) {
        //GIVEN

        //WHEN
        Long result = basic.multiply(a1, a2, a3);
        //THEN
        assertThat(result,is(exp));
    }

    @Test
    public void shouldMultiplyNoOperands() {
        //GIVEN

        //WHEN
        long result = basic.multiply();
        //THEN
        assertThat(result,is(1L));
    }

    @Test
    public void shouldMultiply1Operands() {
        //GIVEN

        //WHEN
        long result = basic.multiply(2);
        //THEN
        assertThat(result,is(2L));
    }

    @Test
    public void shouldMultiplyBigNumbers() {
        //GIVEN

        //WHEN
        Long result = basic.multiply(Integer.MAX_VALUE, 1);
        //THEN
        assertThat(result,greaterThanOrEqualTo(0L));
    }

    //POW
    @Tag("smoke")
    @Test
    public void shouldUsePowWithExponentNegativeNumbers() {
        //GIVEN

        //WHEN
        double result = expertOperations.pow(2, -4);
        //THEN
        assertThat(result,is(greaterThanOrEqualTo(0.000001)));
        assertThat(result,is(lessThanOrEqualTo(1.0)));
    }

    @Test
    public void shouldUsePowWith0Exponent() {
        //GIVEN

        //WHEN
        double result = expertOperations.pow(2, 0);
        //THEN
        assertThat(result,is(greaterThanOrEqualTo(1.0)));
    }

    @Test
    public void shouldUsePowWith0Base() {
        //GIVEN

        //WHEN
        double result = expertOperations.pow(0, 2);
        //THEN
        assertThat(result,anything());
        assertThat(result,is(lessThan(0.1)));
    }

    //FACTORIAL
    @Tag("smoke")
    @Test
    public void shouldFactorialWith0() {
        //GIVEN

        //WHEN
        double result = expertOperations.factRec(0);
        //THEN
        assertThat(result,is(equalTo(0)));
    }

    @Test
    public void shouldFactorialWithNegative() {
        //GIVEN

        //WHEN
        double result = expertOperations.factRec(-1);
        //THEN
        LOGGER.info(result);
    }

    @Test
    public void shouldFactorialWithPositive() {
        //GIVEN

        //WHEN
        double result = expertOperations.factRec(2);
        //THEN
        assertThat(result,is(greaterThanOrEqualTo(1.0)));
    }
}
