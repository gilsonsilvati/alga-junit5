package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {

    @Test
    void dever_saudar_sucesso() {

        var saudacao = SaudacaoUtil.saudar(9);

        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    void deve_lancar_exception() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(-10));

        assertEquals("Hora inválida", exception.getMessage());
    }

    @Test
    void nao_deve_lancar_exception() {

        assertDoesNotThrow(() -> SaudacaoUtil.saudar(0));
    }
}
