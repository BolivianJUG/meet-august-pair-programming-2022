package org.bolivianjug.pairprogramming;

import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by julio.rocha on 17/8/22.
 *
 * @author julio.rocha
 */
class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("Sumar hasta 2 numeros, toda cadena vacia debe retornar 0")
    public void requrimiento1() {
        Assertions.assertEquals(0, stringCalculator.add(""));
        Assertions.assertEquals(1, stringCalculator.add("1"));
        Assertions.assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void validacionCasoNegativos() {
        StringCalculator.NegativeNumber negativeNumber = assertThrows(StringCalculator.NegativeNumber.class, () -> stringCalculator.add("-1,3,-2,6"));
        assertThat(negativeNumber.getMessage(), is("Negativos no permitidos: -1,-2"));
    }

    @Test
    public void manejoDeCantidadesDesconocidas() {
        Assertions.assertEquals(6, stringCalculator.add("1,2,3"));
        Assertions.assertEquals(610, stringCalculator.add("100,200,310"));
        Assertions.assertEquals(0, stringCalculator.add("100,-200,110,-10"));
    }

    @Test
    public void manejoDeSaltosDeLinea() {
        Assertions.assertEquals(6, stringCalculator.add("1\n2,3"));
        Assertions.assertEquals(621, stringCalculator.add("100\n200,310,10\n1"));
        Assertions.assertEquals(0, stringCalculator.add("100,-200,110\n-10"));
    }


    @Test
    @Disabled
    public void manejoSaltoLineaNegativo() {
        Assertions.assertEquals(620, stringCalculator.add("100\n200,310,10,\n"));
    }

    @Test
    @DisplayName("delimitador personalizado")
    public void admitirDiferentesDelimitadores() {
        Assertions.assertEquals(660, stringCalculator.add("//;\n100;200;310;10;40"));
    }
}
