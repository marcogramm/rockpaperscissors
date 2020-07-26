package mg.rockpaperscissors.domain.strategy

import mg.rockpaperscissors.domain.Action
import kotlin.random.Random

/**
 * Implementing the Strategy Interface to determine a next Action according to
 * the "Random Choice Strategy".
 * The Random Choice strategy randomly returns Actions
 */
class RandomChoiceStrategy : Strategy {
    private val moves = Action.values()

    override fun nextAction(): Action = moves[Random.nextInt(moves.size)]
}