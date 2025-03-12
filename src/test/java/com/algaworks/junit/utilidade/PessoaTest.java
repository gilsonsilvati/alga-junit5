package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaTest {

    @Test
    void assercaoAgrupada() {

        var pessoa = new Pessoa("Gilson", "Silva");

//        assertEquals("Gilson", pessoa.getNome());
//        assertEquals("Silva", pessoa.getSobrenome());
//        assertEquals("Gilson Silva", pessoa.getNomeCompleto());

        assertAll("Asserções de Pessoa",
                () -> assertEquals("Gilson", pessoa.getNome()),
                () -> assertEquals("Silva", pessoa.getSobrenome()),
                () -> assertEquals("Gilson Silva", pessoa.getNomeCompleto()));
    }
}
