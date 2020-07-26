package mg.rockpaperscissors.domain.strategy

import mg.rockpaperscissors.domain.Action

interface Strategy {
    fun nextAction(): Action
}