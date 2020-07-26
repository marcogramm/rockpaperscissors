package mg.rockpaperscissors.domain

import mg.rockpaperscissors.domain.strategy.Strategy

/**
 * Represents a player in the Game.
 * A Player is currently only identified by its name.
 *
 * Also, a player is using a certain Strategy to be able to decide
 * about it's next Action
 */
class Player(val name: String, private var strategy: Strategy) {
    /**
     * Returns the next Action of this player, according to the Strategy used by this Player
     * @return The next Action of this Player
     */
    fun nextAction(): Action = strategy.nextAction()
}