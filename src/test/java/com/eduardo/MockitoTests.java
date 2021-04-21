package com.eduardo;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {

    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMockito(){
        Mockito.when(lista.size() ).thenReturn(20);

        int size = 0;
        if(true){
          size = lista.size();
          size = lista.size();
        }
//        Assertions.assertThat(size).isEqualTo(20);
        //verifica se chamou método size da lista
        Mockito.verify(lista, Mockito.times(2)).size();

        //verifica se nunca foi executado
//        Mockito.verify(lista, Mockito.never()).size();
    }
}
