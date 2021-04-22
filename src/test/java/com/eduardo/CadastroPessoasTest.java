package com.eduardo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoasTest {

    @Test
    @DisplayName("DEVE criar o cadastro de pessoas.")
    public void deveCriarOCadastroDePessoas(){
        //cenário e execução
        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        //verificação
        Assertions.assertThat( cadastroPessoas.getPessoas() ).isEmpty();
    }

    @Test
    @DisplayName("DEVE adicionar uma pessoa")
    public void deveAdicionarUmaPessoa(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Eduardo Tadeu");

        //execução
        cadastroPessoas.adicionar(pessoa);

         //verificação
        Assertions
                .assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);

    }

    @Test
    @DisplayName("NÃO deve adicionar Pessoa com Nome Vazio")
    public void naoDeveAdicionarPessoaComNomeVazio(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
        org.junit.jupiter.api.Assertions
                .assertThrows(PessoaSemNotException.class, ()-> cadastroPessoas.adicionar(pessoa));

    }

    @Test
    @DisplayName("DEVE remover uma pessoa")
    public void deveRemoverUmaPessoa(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Eduardo Tadeu");
        cadastroPessoas.adicionar(pessoa);

        //execucao
        cadastroPessoas.remover(pessoa);

        //verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();

    }

    @Test
    @DisplayName("DEVE lançar erro ao tentar remover pessoa inexistente")
    public void deveLancarErroAoTentarRemoverPessoaInexistente(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução

        org.junit.jupiter.api.Assertions
                .assertThrows(CadastroVazioException.class,()-> cadastroPessoas.remover(pessoa));
    }

}
