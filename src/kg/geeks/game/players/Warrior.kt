package kg.geeks.game.players

import kg.geeks.game.logic.RPG_Game




    class Warrior(health: Int, damage: Int, name: String) :
        Hero(health, damage, name, SuperAbility.CRITICAL_DAMAGE) {
        override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
            val coefficient = RPG_Game.random.nextInt(4) + 2
            boss.health -= coefficient * damage
            println("$name hit critically with damage ${coefficient * damage}")
        }
    }
