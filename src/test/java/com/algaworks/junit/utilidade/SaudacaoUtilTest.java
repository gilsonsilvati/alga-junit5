package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Testes no utilitário de saudação")
class SaudacaoUtilTest {

    /*
     * Organizando testes com o padrão Triple A
     *
     * Arrange: Arranjo (Cenário)
     * Act: Agir (Executar)
     * Assert: Afirmar (Asserção)
     */

    @Test
    @DisplayName("Deve saudar com bom dia")
    void deveSaudarBomDia() {
        // Arrange
        var horaValida = 9;

        // Act
        var saudacao = saudar(horaValida);

        // Assert
        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deve saudar com bom dia às 5 horas")
    void deveSaudarBomDiaApartir5h() {
        var horaValida = 5;

        var saudacao = saudar(horaValida);

        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deve saudar com boa tarde")
    void deveSaudarBoaTarde() {
        var horaValida = 15;

        var saudacao = saudar(horaValida);

        assertEquals("Boa tarde", saudacao, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deve saudar com boa noite")
    void deveSaudarBoaNoite() {
        var horaValida = 20;

        var saudacao = saudar(horaValida);

        assertEquals("Boa noite", saudacao, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deve saudar com boa noite às 4 horas")
    void deveSaudarBoaNoiteAte4h() {
        var horaValida = 4;

        var saudacao = saudar(horaValida);

        assertEquals("Boa noite", saudacao, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deve lançar exceção")
    void deveLancarException() {
        var horaInvalida = -10;

        Executable chamadaInvalida = () -> saudar(horaInvalida);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, chamadaInvalida);
        assertEquals("Hora inválida", exception.getMessage());
    }

    @Test
    @DisplayName("Não deve lançar exceção")
    void naoDeveLancarException() {
        var horaValida = 0;

        Executable chamadaValida = () -> saudar(horaValida);

        assertDoesNotThrow(chamadaValida);
    }
}
