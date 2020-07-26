package mg.rockpaperscissors.domain

import mg.rockpaperscissors.domain.Action.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ActionTest {
    private val beatingActions: Map<Action, Action> = mapOf(
            Pair(ROCK, SCISSORS),
            Pair(SCISSORS, PAPER),
            Pair(PAPER, ROCK))

    @ParameterizedTest
    @EnumSource(Action::class)
    fun actionBeatsBeatableAction(action1: Action) {
        values().forEach { action2 -> assertThat(action1.beats(action2)).isEqualTo(shouldBeat(action1, action2)) }
    }


    private fun shouldBeat(action1: Action, action2: Action): Boolean {
        return when {
            beatingActions[action1] == action2 -> true
            else -> false
        }
    }
}