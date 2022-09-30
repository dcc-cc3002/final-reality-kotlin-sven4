package cl.uchile.dcc

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.weapon.Knife
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {
    val queue = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val cuchillo = Knife("Daga lvl $i", 0, Random.nextInt(1, 50))
        val character = Thief("$i", 10, 10, queue)
        character.equip(cuchillo)
        character.waitTurn()
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000)
    while (!queue.isEmpty()) {
        // Pops and prints the names of the characters of the queue to illustrate the turns
        // order
        println(queue.poll())
    }
}
