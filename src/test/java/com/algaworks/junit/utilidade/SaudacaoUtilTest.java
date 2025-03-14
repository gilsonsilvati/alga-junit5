package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SaudacaoUtilTest {

    /*
     * Aplicando a nomenclatura do BDD para nomear métodos de teste
     *
     * Given, When e Then
     * Dado, Quando, Então
     */

    /*
     * Organizando testes com o padrão Triple A
     *
     * Arrange: Arranjo (Cenário)
     * Act: Agir (Executar)
     * Assert: Afirmar (Asserção)
     */

    @Test
    void Dado_um_horario_matutino_Quando_saudar_Entao_deve_retornar_bom_dia() {
        // Arrange
        var horaValida = 9;

        // Act
        var saudacao = saudar(horaValida);

        // Assert
        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    void Dado_um_horario_vespertino_Quando_saudar_Entao_deve_retornar_boa_tarde() {
        var horaValida = 15;

        var saudacao = saudar(horaValida);

        assertEquals("Boa tarde", saudacao, "Saudação incorreta!");
    }

    @Test
    void Dado_um_horario_noturno_Quando_saudar_Entao_deve_retornar_boa_noite() {
        var horaValida = 4;

        var saudacao = saudar(horaValida);

        assertEquals("Boa noite", saudacao, "Saudação incorreta!");
    }

    @Test
    void Dado_uma_hora_invalida_Quando_saudar_Entao_deve_lancar_excecao() {
        var horaInvalida = -10;

        Executable chamadaInvalida = () -> saudar(horaInvalida);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, chamadaInvalida);
        assertEquals("Hora inválida", exception.getMessage());
    }

    @Test
    void Dado_uma_hora_valida_Quando_saudar_Entao_nao_deve_lancar_excecao() {
        var horaValida = 0;

        Executable chamadaValida = () -> saudar(horaValida);

        assertDoesNotThrow(chamadaValida);
    }
}
