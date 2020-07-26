package mg.rockpaperscissors.domain.strategy

import mg.rockpaperscissors.domain.Action

/**
 * Interface for choosing a next Action according to a given Stategy
 * Implementing classes are free to decide which Action to return next.
 */
interface Strategy {
    /**
     * returns the next Action according to this Strategy
     * @return The next Action
     */
    fun nextAction(): Action
}