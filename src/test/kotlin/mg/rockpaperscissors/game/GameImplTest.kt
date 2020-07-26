package mg.rockpaperscissors.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


internal class GameImplTest {
    lateinit var game: Game


    @DisplayName("Assert Players are correctly registered to the Game")
    @Test
    fun registerPlayers() {
        game = GameImplTestHelper.getGame()
        val player1 = GameImplTestHelper.getPlayer1()
        val player2 = GameImplTestHelper.getPlayer2()
        game.registerPlayer1(player1)
        game.registerPlayer2(player2)

        assertThat(game.getRegisteredPlayers())
                .withFailMessage("Player1 was not registered")
                .contains(player1)

        assertThat(game.getRegisteredPlayers())
                .withFailMessage("Player2 was not registered")
                .contains(player2)
    }

    @DisplayName("Assert Exception is thrown on start with less than 2 Players")
    @Test
    fun startGameThrowsExceptionWhenNotEnoughPlayers() {
        var game = GameImplTestHelper.getGame()
        val player1 = GameImplTestHelper.getPlayer1()
        val player2 = GameImplTestHelper.getPlayer2()

        // throws with no registered players
        assertThrows(IllegalStateException::class.java) {
            game.startGame(1)
        }

        game.registerPlayer2(player1)

        // throws when only player one is registered
        assertThrows(IllegalStateException::class.java) {
            game.startGame(1)
        }

        game = GameImplTestHelper.getGame()
        game.registerPlayer2(player2)

        // throws when only player2 is registered
        assertThrows(IllegalStateException::class.java) {
            game.startGame(1)
        }

    }

    @DisplayName("Rounds are correctly calculated")
    fun calculatedRounds() {

    }

    @DisplayName("Rounds played gives all played rounds")
    @ParameterizedTest
    @ValueSource(ints = [1, 10, 100])
    fun getRoundsPlayed(roundsToPlay: Int) {
        val game: Game = GameImplTestHelper.getGameWithPlayers()
        game.startGame(roundsToPlay)

        val roundsPlayed = game.getRoundsPlayed()
        assertThat(roundsPlayed.size).isEqualTo(roundsToPlay)
    }
}