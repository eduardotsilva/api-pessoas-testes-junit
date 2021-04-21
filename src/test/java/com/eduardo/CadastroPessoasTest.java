package com.eduardo;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class CadastroPessoasTest {

    @Test
    public void deveCriarOCadastroDePessoas(){
        //cenário e execução
        CadastroPessoas cadastroPessoas = new CadastroPessoas();

        //verificação
        Assertions.assertThat( cadastroPessoas.getPessoas() ).isEmpty();
    }

    @Test
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

    @Test(expected = PessoaSemNotException.class)
    public void naoDeveAdicionarPessoaComNomeVazio(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
        cadastroPessoas.adicionar(pessoa);
    }

    @Test
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

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente(){
        //cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
        cadastroPessoas.remover(pessoa);

        //verificação
    }

}
