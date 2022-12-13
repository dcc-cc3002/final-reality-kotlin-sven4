package cl.uchile.dcc.finalreality.controller

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.weapon.Axe
import cl.uchile.dcc.finalreality.model.weapon.Knife
import cl.uchile.dcc.finalreality.model.weapon.Staff
import cl.uchile.dcc.finalreality.model.weapon.Sword
import cl.uchile.dcc.finalreality.model.weapon.Weapon
import java.util.concurrent.LinkedBlockingQueue

class GameController {
    private val turnsQueue = LinkedBlockingQueue<GameCharacter>()
    private val playerCharacters = mutableListOf<GameCharacter>()
    private val enemyCharacters = mutableListOf<Enemy>()

    init {
        for (i in 1..10) {
            // TODO: Add enemies to the game
            val enemy: Enemy = Enemy("Enemigo $i", 20, 50, 5, turnsQueue)
            enemy.waitTurn()
            enemyCharacters.add(enemy)
            // TODO: Add characters to the turns queue
        }
        val caballero = Knight("Lord", 300, 20, turnsQueue)
        val rogue = Thief("Thief", 150, 12, turnsQueue)
        val mago = WhiteMage("Priestess", 150, 150, 10, turnsQueue)
        val engineer = Engineer("Ingenierio", 200, 20, turnsQueue)

        val espada = Sword("Rapier", 20, 5)
        val knife = Knife("Daga", 15, 5)
        val baston = Staff("Baston de aprendiz", 10, 3, 10)
        val martillo = Axe("Martillo ingles", 20, 10)

        caballero.equip(espada)
        rogue.equip(knife)
        mago.equip(baston)
        engineer.equip(martillo)

        playerCharacters.add(caballero)
        playerCharacters.add(rogue)
        playerCharacters.add(mago)
        playerCharacters.add(engineer)

        // TODO: Add players to the game
    }

    fun createKnight(name: String, hp: Int, defense: Int, weapon: Weapon) {
        val newKnight = Knight(name, hp, defense, turnsQueue)
        newKnight.equip(weapon)
        playerCharacters.add(newKnight)
    }
    fun createThief(name: String, hp: Int, defense: Int, weapon: Weapon) {
        val newThief = Thief(name, hp, defense, turnsQueue)
        newThief.equip(weapon)
        playerCharacters.add(newThief)
    }
    fun createEngineer(name: String, hp: Int, defense: Int, weapon: Weapon) {
        val newEngineer = Engineer(name, hp, defense, turnsQueue)
        newEngineer.equip(weapon)
        playerCharacters.add(newEngineer)
    }
    fun createWhiteMage(name: String, hp: Int, mp: Int, defense: Int, weapon: Weapon) {
        val newWhiteMage = WhiteMage(name, hp, mp, defense, turnsQueue)
        newWhiteMage.equip(weapon)
        playerCharacters.add(newWhiteMage)
    }
    fun createBlackMage(name: String, hp: Int, mp: Int, defense: Int, weapon: Weapon) {
        val newBlackMage = BlackMage(name, hp, mp, defense, turnsQueue)
        newBlackMage.equip(weapon)
        playerCharacters.add(newBlackMage)
    }

    fun createEnemy(name: String, hp: Int, defense: Int, weight: Int) {
        enemyCharacters.add(Enemy(name, weight, hp, defense, turnsQueue))
    }

    fun enemyAttackPlayer(attacker: Enemy, target: GameCharacter) {
        target.currentHp -= attacker.weight
        if (target.currentHp <= 0) {
            target.currentHp = 0
            playerCharacters.remove(target)
        }
    }

    fun playerAttackEnemy(attacker: PlayerCharacter, target: Enemy) {
        target.currentHp -= attacker.equippedWeapon.damage
        if (target.currentHp <= 0) {
            target.currentHp = 0
            enemyCharacters.remove(target)
        }
    }

    fun useMagic(attacker: GameCharacter, target: GameCharacter) {
        // TODO: Use magic on a target
    }

    fun waitTurn(character: GameCharacter) {
        character.waitTurn()
    }

    fun onPlayerWin() {
        print("Glorius Victory!")
    }

    fun onEnemyWin() {
        print("You lose")
    }
}
