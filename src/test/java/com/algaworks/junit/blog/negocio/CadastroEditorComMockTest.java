package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.armazenamento.ArmazenamentoEditor;
import com.algaworks.junit.blog.modelo.Editor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CadastroEditorComMockTest {

    CadastroEditor cadastroEditor;
    Editor editor;

    @BeforeEach
    void setUp() {
        editor = new Editor("Gilson", "gilson.silva@email.com.br", BigDecimal.TEN, true);

        ArmazenamentoEditor armazenamentoEditor = Mockito.mock(ArmazenamentoEditor.class);
        Mockito.when(armazenamentoEditor.salvar(editor))
                .thenReturn(new Editor(1L, "Gilson", "gilson@email.com.br", BigDecimal.TEN, true));

        GerenciadorEnvioEmail gerenciadorEnvioEmail = Mockito.mock(GerenciadorEnvioEmail.class);

        cadastroEditor = new CadastroEditor(armazenamentoEditor, gerenciadorEnvioEmail);
    }

    @Test
    void Dado_um_editor_valido_Quando_criar_Entao_deve_retornar_um_id_de_cadastro() {

        Editor editorSalvo = cadastroEditor.criar(editor);

        assertNotNull(editorSalvo);

        assertEquals(1L, editorSalvo.getId());
    }
}
