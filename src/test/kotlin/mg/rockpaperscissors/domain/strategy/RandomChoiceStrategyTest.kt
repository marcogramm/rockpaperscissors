package mg.rockpaperscissors.domain.strategy

import mg.rockpaperscissors.domain.Action
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class RandomChoiceStrategyTest{
    private val maxIterations = 10000;

    @DisplayName("Assert all possible Actions are at least once returned")
    @ParameterizedTest
    @EnumSource(Action::class)
    fun nextAction(expectedAction: Action) {
        val strategy = RandomChoiceStrategy()
        val actualActions = mutableListOf<Action>()

        for (x in 0 until maxIterations) {
            actualActions.add(strategy.nextAction())
        }

        assertThat(actualActions)
                .withFailMessage("expectedActions did not contain $expectedAction")
                .contains(expectedAction)
    }
}