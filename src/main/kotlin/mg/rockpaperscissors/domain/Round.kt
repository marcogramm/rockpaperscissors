package mg.rockpaperscissors.domain

/**
 * A Round represents a played round in the Game.
 * A round saves the actions of the players participating in that round, as well as the
 * round-result per player
 */
class Round {
    var results: MutableMap<Player, Result> = mutableMapOf()
        private set
    var actions: MutableMap<Player, Action> = mutableMapOf()
        private set

    /**
     * Adds a round result for a Player
     * Adds the Action of the player, as well as the result this Action led to.
     *
     * Does not do any validation checks
     */
    fun addActionAndResultForPlayer(player: Player, action: Action, result: Result) {
        results[player] = result
        actions[player] = action
    }
}