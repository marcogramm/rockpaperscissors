package mg.rockpaperscissors.domain

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

    abstract fun beats(action: Action): Boolean
}