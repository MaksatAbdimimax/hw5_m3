package kg.geeks.game.players
import kg.geeks.game.logic.RPG_Game


    class Medic(health: Int, damage: Int, name: String, private val healPoints: Int) :
        Hero(health, damage, name, SuperAbility.HEAL) {
        override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
            for (hero in heroes) {
                if (hero.health > 0 && hero != this) {
                    hero.health += healPoints
                }
            }
        }
    }
