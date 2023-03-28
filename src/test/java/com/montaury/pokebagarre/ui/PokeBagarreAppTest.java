package com.montaury.pokebagarre.ui;
import java.util.concurrent.TimeUnit;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
@ExtendWith(ApplicationExtension.class)
class PokeBagarreAppTest {

    private static final String IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_1 = "#nomPokemon1";
    private static final String IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_2 = "#nomPokemon2";
    private static final String IDENTIFIANT_BOUTON_BAGARRE = ".button";
    @Start
    private void start(Stage stage) {
        new PokeBagarreApp().start(stage);
    }

    @Test
    void pokemon_vainqueur_1(FxRobot robot) {
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_1);
        robot.write("lippoutou");
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_2);
        robot.write("Argouste");
        robot.clickOn(IDENTIFIANT_BOUTON_BAGARRE);
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() ->
        assertThat(getResultatBagarre(robot)).isEqualTo("Le vainqueur est: Argouste")
         );
    }
    @Test
    void pokemon_vainqueur_2(FxRobot robot) {
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_1);
        robot.write("Aquali");
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_2);
        robot.write("Gardevoir");
        robot.clickOn(IDENTIFIANT_BOUTON_BAGARRE);
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() ->
                assertThat(getResultatBagarre(robot)).isEqualTo("Le vainqueur est: Gardevoir")
        );
    };

    @Test
    void champ_Pokemon1_pas_rempli(FxRobot robot) {
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_1);
        robot.write("");
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_2);
        robot.write("Argouste");
        robot.clickOn(IDENTIFIANT_BOUTON_BAGARRE);
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() ->
                assertThat(getMessageErreur(robot)).isEqualTo("Erreur: Le premier pokemon n'est pas renseigne")
        );
    }

    @Test
    void champ_Pokemon2_pas_rempli(FxRobot robot) {
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_1);
        robot.write("Pikachu");
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_2);
        robot.write("");
        robot.clickOn(IDENTIFIANT_BOUTON_BAGARRE);
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() ->
                assertThat(getMessageErreur(robot)).isEqualTo("Erreur: Le second pokemon n'est pas renseigne")
        );
    }
    @Test
    void Pokemon1_pas_trouve(FxRobot robot) {
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_1);
        robot.write("Pikachoux");
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_2);
        robot.write("Gardevoir");
        robot.clickOn(IDENTIFIANT_BOUTON_BAGARRE);
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() ->
                assertThat(getMessageErreur(robot)).isEqualTo("Erreur: Impossible de recuperer les details sur 'Pikachoux'")
        );
    }

    @Test
    void Pokemon2_pas_trouve(FxRobot robot) {
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_1);
        robot.write("Pikachu");
        robot.clickOn(IDENTIFIANT_CHAMP_DE_SAISIE_POKEMON_2);
        robot.write("Gardeboire");
        robot.clickOn(IDENTIFIANT_BOUTON_BAGARRE);
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() ->
                assertThat(getMessageErreur(robot)).isEqualTo("Erreur: Impossible de recuperer les details sur 'Gardeboire'")
        );
    }
    private static String getResultatBagarre(FxRobot robot) {
        return robot.lookup("#resultatBagarre").queryText().getText();
    }
    private static String getMessageErreur(FxRobot robot) {
        return robot.lookup("#resultatErreur").queryLabeled().getText();
    }
}