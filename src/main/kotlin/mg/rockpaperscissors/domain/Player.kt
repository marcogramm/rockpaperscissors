package mg.rockpaperscissors.domain

import mg.rockpaperscissors.domain.strategy.Strategy

class Player(val name: String, private var strategy: Strategy) {
    fun nextAction(): Action = strategy.nextAction()
}