package mg.rockpaperscissors.domain

enum class Action {
    ROCK {
        override fun beats(action: Action): Boolean {
            TODO("Not yet implemented")
        }
    },
    SCISSORS {
        override fun beats(action: Action): Boolean {
            TODO("Not yet implemented")
        }
    },
    PAPER {
        override fun beats(action: Action): Boolean {
            TODO("Not yet implemented")
        }
    };

    abstract fun beats(action: Action) : Boolean
}