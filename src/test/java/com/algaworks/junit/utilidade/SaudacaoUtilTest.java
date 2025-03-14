package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SaudacaoUtilTest {

    /*
     * Organizando testes com o padrão Triple A
     *
     * Arrange: Arranjo (Cenário)
     * Act: Agir (Executar)
     * Assert: Afirmar (Asserção)
     */

    @Test
    void deverSaudarBomDia() {
        // Arrange
        var horaValida = 9;

        // Act
        var saudacao = saudar(horaValida);

        // Assert
        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    void deverSaudarBomDiaApartir5h() {
        var horaValida = 5;

        var saudacao = saudar(horaValida);

        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    void deverSaudarBoaTarde() {
        var horaValida = 15;

        var saudacao = saudar(horaValida);

        assertEquals("Boa tarde", saudacao, "Saudação incorreta!");
    }

    @Test
    void deverSaudarBoaNoite() {
        var horaValida = 20;

        var saudacao = saudar(horaValida);

        assertEquals("Boa noite", saudacao, "Saudação incorreta!");
    }

    @Test
    void deverSaudarBoaNoiteAte4h() {
        var horaValida = 4;

        var saudacao = saudar(horaValida);

        assertEquals("Boa noite", saudacao, "Saudação incorreta!");
    }

    @Test
    void deveLancarException() {
        var horaInvalida = -10;

        Executable chamadaInvalida = () -> saudar(horaInvalida);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, chamadaInvalida);
        assertEquals("Hora inválida", exception.getMessage());
    }

    @Test
    void naoDeveLancarException() {
        var horaValida = 0;

        Executable chamadaValida = () -> saudar(horaValida);

        assertDoesNotThrow(chamadaValida);
    }
}
