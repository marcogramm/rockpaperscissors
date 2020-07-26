package mg.rockpaperscissors.domain


class Round {
    var results: MutableMap<Player, Result> = mutableMapOf()
        private set
    var actions: MutableMap<Player, Action> = mutableMapOf()
        private set

    fun addActionAndResultForPlayer(player: Player, action: Action, result: Result) {
        results[player] = result
        actions[player] = action
    }
}