package mg.rockpaperscissors.game

import mg.rockpaperscissors.domain.Action
import mg.rockpaperscissors.domain.Player
import mg.rockpaperscissors.domain.Result
import mg.rockpaperscissors.domain.strategy.StubbornStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


internal class GameImplTest {
    @DisplayName("Players are correctly registered to the Game")
    @Test
    fun registerPlayers() {
        val game = GameImplTestHelper.getGame()
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

    @DisplayName("Exception is thrown on start with less than 2 Players")
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

    @DisplayName("Rounds are calculated and saved correctly")
    @Test
    fun roundsAreCalculatedCorrectly() {
        var player1 = Player("1", StubbornStrategy(Action.ROCK))
        var player2 = Player("2", StubbornStrategy(Action.SCISSORS))
        var lastLound = GameImplTestHelper.getGameWithOneRoundPlayed(player1, player2)
        assertThat(lastLound.actions[player1]).isEqualTo(Action.ROCK)
        assertThat(lastLound.actions[player2]).isEqualTo(Action.SCISSORS)
        assertThat(lastLound.results[player1]).isEqualTo(Result.WIN)
        assertThat(lastLound.results[player2]).isEqualTo(Result.LOSS)

        player1 = Player("1", StubbornStrategy(Action.ROCK))
        player2 = Player("2", StubbornStrategy(Action.PAPER))
        lastLound = GameImplTestHelper.getGameWithOneRoundPlayed(player1, player2)
        assertThat(lastLound.actions[player1]).isEqualTo(Action.ROCK)
        assertThat(lastLound.actions[player2]).isEqualTo(Action.PAPER)
        assertThat(lastLound.results[player1]).isEqualTo(Result.LOSS)
        assertThat(lastLound.results[player2]).isEqualTo(Result.WIN)

        player1 = Player("1", StubbornStrategy(Action.ROCK))
        player2 = Player("2", StubbornStrategy(Action.ROCK))
        lastLound = GameImplTestHelper.getGameWithOneRoundPlayed(player1, player2)
        assertThat(lastLound.actions[player1]).isEqualTo(Action.ROCK)
        assertThat(lastLound.actions[player2]).isEqualTo(Action.ROCK)
        assertThat(lastLound.results[player1]).isEqualTo(Result.DRAW)
        assertThat(lastLound.results[player2]).isEqualTo(Result.DRAW)
    }

    @DisplayName("Rounds played gives all played rounds")
    @ParameterizedTest
    @ValueSource(ints = [1, 10, 100])
    fun getRoundsPlayed(roundsToPlay: Int) {
        val game: GameImpl = GameImplTestHelper.getGameWithPlayers()
        game.startGame(roundsToPlay)

        val roundsPlayed = game.getRoundsPlayed()
        assertThat(roundsPlayed.size).isEqualTo(roundsToPlay)
    }
}