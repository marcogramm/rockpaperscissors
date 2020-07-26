package mg.rockpaperscissors.domain.strategy

import mg.rockpaperscissors.domain.Action
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class StubbornStrategyTest {
    private val maxIterations = 10000;

    @DisplayName("Assert StubbornStrategy always return the same Action")
    @ParameterizedTest
    @EnumSource(Action::class)
    fun nextAction(expectedAction: Action) {
        val strategy = StubbornStrategy(expectedAction)

        for (x in 0 until maxIterations) {
            val actualAction = strategy.nextAction()
            assertThat(actualAction)
                    .withFailMessage("Expected Action to be $expectedAction but got $actualAction")
                    .isEqualTo(expectedAction)
        }
    }
}