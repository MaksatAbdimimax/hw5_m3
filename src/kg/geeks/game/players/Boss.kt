package kg.geeks.game.players
import kg.geeks.game.logic.RPG_Game


    class Boss(health: Int, damage: Int, name: String) : GameEntity(health, damage, name) {
        var defence: SuperAbility? = null

        fun chooseDefence() {
            val variants = SuperAbility.values()
            val randomIndex = RPG_Game.random.nextInt(variants.size)
            defence = variants[randomIndex]
        }

        fun attack(heroes: Array<Hero>) {
            for (hero in heroes) {
                if (hero.health > 0) {
                    if (hero is Berserk && defence != SuperAbility.BLOCK_DAMAGE_REVERT) {
                        val blocked = (RPG_Game.random.nextInt(2) + 1) * 5
                        hero.blockedDamage = blocked
                        hero.health -= (damage - blocked)
                    } else {
                        hero.health -= damage
                    }
                }
            }
        }

        override fun toString(): String {
            return "BOSS ${super.toString()} defence: $defence"
        }
    }
