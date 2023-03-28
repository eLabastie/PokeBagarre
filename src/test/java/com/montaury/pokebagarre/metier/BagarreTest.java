package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.webapi.PokeBuildApi;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;

import static org.junit.jupiter.api.Assertions.*;

class BagarreTest {

    @Test
    void should_not_be_empty() {
        // GIVEN
        var fausseApi = Mockito.mock(PokeBuildApi.class) ;
        var Pokemon =  fausseApi.recupererParNom(null);

    }
}