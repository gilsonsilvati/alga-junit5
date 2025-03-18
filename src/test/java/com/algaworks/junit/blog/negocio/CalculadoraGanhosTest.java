package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.modelo.Editor;
import com.algaworks.junit.blog.modelo.Ganhos;
import com.algaworks.junit.blog.modelo.Post;
import com.algaworks.junit.blog.utilidade.ProcessadorTextoSimples;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraGanhosTest {

    static final int VALOR_PAGO_PALAVRA = 5;

    static CalculadoraGanhos calculadora;

    Editor autor;
    Post post;

    // Arrange
    @BeforeAll
    static void beforeAll() {
//        System.out.println("Antes de TODOS os testes");

        calculadora = new CalculadoraGanhos(new ProcessadorTextoSimples(), BigDecimal.TEN);
    }

    // Arrange
    @BeforeEach
    void setUp() {
//        System.out.println("Antes de CADA teste");

        autor = new Editor(1L, "Gilson", "gilson@gmail.com", new BigDecimal(VALOR_PAGO_PALAVRA), true);

        post = new Post(1L, "Ecossistema Java", "O ecossistema do Java é muito maduro", autor,
                "ecossistema-java-abc123", null, false, false);
    }

//    @AfterAll
//    static void afterAll() {
//        System.out.println("Depois de TODOS os testes");
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("Depois de CADA teste");
//    }

    @Test
    void deveCalcularGanhosComPremium() {

        // Act
        Ganhos ganhos = calculadora.calcular(post);

        // Assert
        assertEquals(new BigDecimal(45), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }

    @Test
    void deveCalcularGanhosSemPremium() {
        autor.setPremium(false);

        // Act
        Ganhos ganhos = calculadora.calcular(post);

        // Assert
        assertEquals(new BigDecimal(35), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }
}