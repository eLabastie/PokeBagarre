package com.montaury.pokebagarre.metier;
import com.montaury.pokebagarre.fixtures.ConstructeurDePokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
/*
    @BeforeEach
    void setup(){
    //GIVEN
        Pokemon pokemon1 = new Pokemon("Pikachu","", new Stats(120,50));
        Pokemon pokemon2 = new Pokemon("Tortank","", new Stats(220,250));

    }

 */
    @Test
    void pokemon1_meilleure_attaque_remporte_bagarre() {
        //GIVEN
        Pokemon pokemon1 = new Pokemon("Pikachu","", new Stats(220,50));
        Pokemon pokemon2 = new Pokemon("Tortank","", new Stats(120,250));
    //WHEN
     boolean vainqueur = pokemon1.estVainqueurContre(pokemon2);
    //THEN
    assertEquals(true, vainqueur);
    }
    @Test
    void pokemon2_meilleure_attaque_remporte_bagarre() {
        //GIVEN
        Pokemon pokemon1 = new Pokemon("Pikachu","", new Stats(120,50));
        Pokemon pokemon2 = new Pokemon("Tortank","", new Stats(220,250));
        //WHEN
        boolean vainqueur = pokemon2.estVainqueurContre(pokemon1);
        //THEN
        assertEquals(true, vainqueur);
    }
    @Test
    void pokemon1_meilleure_defense_remporte_bagarre() {
        //GIVEN
        Pokemon pokemon1 = new Pokemon("Pikachu","", new Stats(220,350));
        Pokemon pokemon2 = new Pokemon("Tortank","", new Stats(220,250));
        //WHEN
        boolean vainqueur = pokemon1.estVainqueurContre(pokemon2);
        //THEN
        assertEquals(true, vainqueur);
    }
    @Test
    void pokemon2_meilleure_defense_remporte_bagarre() {
        //GIVEN
        Pokemon pokemon1 = new Pokemon("Pikachu","", new Stats(220,50));
        Pokemon pokemon2 = new Pokemon("Tortank","", new Stats(220,250));
        //WHEN
        boolean vainqueur = pokemon2.estVainqueurContre(pokemon1);
        //THEN
        assertEquals(true, vainqueur);
    }
};
