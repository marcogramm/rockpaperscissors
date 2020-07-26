package mg.rockpaperscissors.domain

import mg.rockpaperscissors.domain.strategy.RandomChoiceStrategy
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class RoundTest {

    @Test
    fun addActionAndResultForPlayer() {
        val round: Round = Round()
        val player: Player = Player("test", RandomChoiceStrategy())
        val expectedAction = Action.ROCK
        val expectedResult = Result.WIN

        Assertions.assertThat(round.results.containsKey(player)).isFalse()
        Assertions.assertThat(round.actions.containsKey(player)).isFalse()

        round.addActionAndResultForPlayer(player, expectedAction, expectedResult)

        Assertions.assertThat(round.results.containsKey(player)).isTrue()
        Assertions.assertThat(round.actions.containsKey(player)).isTrue()

        val actualAction = round.actions[player]
        val actualResult = round.results[player]

        Assertions.assertThat(actualAction).isEqualTo(expectedAction)
        Assertions.assertThat(actualResult).isEqualTo(expectedResult)

    }
}