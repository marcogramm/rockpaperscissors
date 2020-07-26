package mg.rockpaperscissors.domain

/**
 * Represents a Action or "Move" in the Rock Paper Scissors Game
 */
enum class Action {
    ROCK {
        override fun beats(action: Action) = when (action) {
            SCISSORS -> true
            else -> false
        }
    },
    SCISSORS {
        override fun beats(action: Action) = when (action) {
            PAPER -> true
            else -> false
        }
    },
    PAPER {
        override fun beats(action: Action) = when (action) {
            ROCK -> true
            else -> false
        }
    };

    /**
     * Checks if this Action beats the given Action
     * @param action The action to check against
     * @return true if this Action beats the Action given as a parameter. False otherwise
     */
    abstract fun beats(action: Action): Boolean
}