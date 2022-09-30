package cl.uchile.dcc

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.weapon.Axe
import cl.uchile.dcc.finalreality.model.weapon.Knife
import cl.uchile.dcc.finalreality.model.weapon.Staff
import cl.uchile.dcc.finalreality.model.weapon.Sword
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {
    val queue = LinkedBlockingQueue<GameCharacter>()
    // Gives a random speed to each character to generate different waiting times
    val armaLadron = Knife("daga", 2, Random.nextInt(1, 50))
    val armaCaballero = Sword("espada", 4, Random.nextInt(1, 50))
    val armaIngeniero = Axe("llave inglesa", 3, Random.nextInt(1, 50))
    val armaMagoBlanco = Staff("baston blanco", 5, Random.nextInt(1, 50), 20)
    val armaMagoNegro = Staff("baston negro", 5, Random.nextInt(1, 50), 30)
    val ladron = Thief("Piñera", 10, 10, queue)
    val caballero = Knight("Caballo", 20, 15, queue)
    val ingeniero = Engineer("Yop", 15, 20, queue)
    val magoBlanco = WhiteMage("Mago blanco", 20, 20, 5, queue)
    val magoNegro = BlackMage("Mago negro", 20, 15, 10, queue)

    ladron.equip(armaLadron)
    ladron.waitTurn()

    caballero.equip(armaCaballero)
    caballero.waitTurn()

    ingeniero.equip(armaIngeniero)
    ingeniero.waitTurn()

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
    println("--------------------------------Armas-------------------------------")
    println(armaLadron)
    println(armaCaballero)
    println(armaIngeniero)
    println(armaMagoBlanco)
    println(armaMagoNegro)
}
