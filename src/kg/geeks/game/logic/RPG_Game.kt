package kg.geeks.game.logic

import kg.geeks.game.players.*
import kotlin.random.Random




    object RPG_Game {
        internal val random = Random
        private var roundNumber = 0

        fun startGame() {
            val boss = Boss(1000, 50, "Skeleton")
            val warrior1 = Warrior(280, 10, "Knight")
            val warrior2 = Warrior(290, 15, "Ahiles")
            val magic = Magic(270, 10, "Skymag")
            val doc = Medic(250, 5, "Dumbledor", 15)
            val assistant = Medic(300, 5, "Shaman", 5)
            val berserk = Berserk(260, 10, "Guts")

            val heroes = arrayOf(warrior1, doc, warrior2, magic, berserk, assistant)

            showStatistics(boss, heroes)
            while (!isGameOver(boss, heroes)) {
                playRound(boss, heroes)
            }
        }

        private fun playRound(boss: Boss, heroes: Array<Hero>) {
            roundNumber++
            boss.chooseDefence()
            boss.attack(heroes)
            for (hero in heroes) {
                if (hero.health > 0 && boss.health > 0 && hero.ability != boss.defence) {
                    hero.attack(boss)
                    hero.applySuperPower(boss, heroes)
                }
            }
            showStatistics(boss, heroes)
        }

        private fun isGameOver(boss: Boss, heroes: Array<Hero>): Boolean {
            if (boss.health <= 0) {
                println("Heroes won!!!")
                return true
            }
            val allHeroesDead = heroes.all { it.health <= 0 }
            if (allHeroesDead) {
                println("Boss won!!!")
                return true
            }
            return false
        }

        private fun showStatistics(boss: Boss, heroes: Array<Hero>) {
            println("ROUND $roundNumber -------------")
            println(boss)
            for (hero in heroes) {
                println(hero)
            }
        }
    }

