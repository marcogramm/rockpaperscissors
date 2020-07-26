package mg.rockpaperscissors.game

import mg.rockpaperscissors.domain.Round

interface GameOutput {
    fun outputRound(round: Round)

    fun outputGameStatistics()
}