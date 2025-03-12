package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SaudacaoUtilTest {

    @Test
    void deverSaudarSucesso() {

        var saudacao = SaudacaoUtil.saudar(9);

        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    void deveLancarException() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(-10));

        assertEquals("Hora inválida", exception.getMessage());
    }

    @Test
    void naoDeveLancarException() {

        assertDoesNotThrow(() -> SaudacaoUtil.saudar(0));
    }
}
