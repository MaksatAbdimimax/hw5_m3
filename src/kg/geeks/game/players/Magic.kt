package kg.geeks.game.players
import kg.geeks.game.logic.RPG_Game


    class Magic(health: Int, damage: Int, name: String) :
        Hero(health, damage, name, SuperAbility.BOOST) {
        override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
            // Реализация эффекта увеличения силы
            println("$name boosted heroes!")
        }
    }
