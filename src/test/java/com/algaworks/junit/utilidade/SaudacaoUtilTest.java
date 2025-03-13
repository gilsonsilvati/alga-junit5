package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SaudacaoUtilTest {

    @Test
    void deverSaudarBomDia() {

        var saudacao = saudar(9);

        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    void deverSaudarBoaTarde() {

        var saudacao = saudar(15);

        assertEquals("Boa tarde", saudacao, "Saudação incorreta!");
    }

    @Test
    void deverSaudarBoaNoite() {

        var saudacao = saudar(20);

        assertEquals("Boa noite", saudacao, "Saudação incorreta!");
    }

    @Test
    void deveLancarException() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> saudar(-10));

        assertEquals("Hora inválida", exception.getMessage());
    }

    @Test
    void naoDeveLancarException() {

        assertDoesNotThrow(() -> saudar(0));
    }
}
