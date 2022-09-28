package cl.uchile.dcc

import cl.uchile.dcc.finalreality.model.MagicWeapon
import cl.uchile.dcc.finalreality.model.Weapon
import cl.uchile.dcc.finalreality.model.WeaponType
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {
    val queue = LinkedBlockingQueue<GameCharacter>()
    // Gives a random speed to each character to generate different waiting times
    val armaLadron = Weapon("daga", 2, Random.nextInt(1, 50), WeaponType.KNIFE)
    val armaCaballero = Weapon("espada", 4, Random.nextInt(1, 50), WeaponType.SWORD)
    val armaMagoBlanco = MagicWeapon("baston blanco", 5, Random.nextInt(1, 50), WeaponType.STAFF, 20)
    val armaMagoNegro = MagicWeapon("baston negro", 5, Random.nextInt(1, 50), WeaponType.STAFF, 30)
    val ladron = Thief("Piñera", 10, 10, queue)
    val caballero = Knight("Caballo", 20, 15, queue)
    val magoBlanco = WhiteMage("mago blanco", 20, 20, 5, queue)
    val magoNegro = BlackMage("mago negro", 20, 15, 10, queue)

    ladron.equip(armaLadron)
    ladron.waitTurn()

    caballero.equip(armaCaballero)
    caballero.waitTurn()

    magoBlanco.equip(armaMagoBlanco)
    magoBlanco.waitTurn()

    magoNegro.equip(armaMagoNegro)
    magoNegro.waitTurn()
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000)
    while (!queue.isEmpty()) {
        // Pops and prints the names of the characters of the queue to illustrate the turns
        // order
        println(queue.poll())
    }
}
