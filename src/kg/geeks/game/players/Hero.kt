package kg.geeks.game.players


    abstract class Hero(
        health: Int,
        damage: Int,
        name: String,
        val ability: SuperAbility
    ) : GameEntity(health, damage, name), HavingSuperAbility {
        fun attack(boss: Boss) {
            boss.health -= damage
        }
    }
