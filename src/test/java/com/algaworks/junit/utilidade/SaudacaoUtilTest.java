package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaudacaoUtilTest {

    @Test
    public void dever_saudar() {

        var saudacao = SaudacaoUtil.saudar(9);

        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

}
