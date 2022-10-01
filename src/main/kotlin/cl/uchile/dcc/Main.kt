package cl.uchile.dcc

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.weapon.Axe
import cl.uchile.dcc.finalreality.model.weapon.Bow
import cl.uchile.dcc.finalreality.model.weapon.Knife
import cl.uchile.dcc.finalreality.model.weapon.Staff
import cl.uchile.dcc.finalreality.model.weapon.Sword
import java.util.concurrent.LinkedBlockingQueue

fun main() {
    val queue = LinkedBlockingQueue<GameCharacter>()

    // ---------------------------------Armas-----------------------------------------
    val cuchillo1 = Knife("daga1", 2, 20)
    val cuchillo2 = Knife("daga1", 2, 20)
    val cuchillo3 = Knife("daga3", 2, 20)

    val espada1 = Sword("espada1", 4, 20)
    val espada2 = Sword("espada1", 4, 20)
    val espada3 = Sword("espada3", 4, 20)

    val llaveInglesa1 = Axe("llave inglesa1", 3, 20)
    val llaveInglesa2 = Axe("llave inglesa1", 3, 20)
    val llaveInglesa3 = Axe("llave inglesa3", 3, 20)

    val arco1 = Bow("Arco de leyenda1", 3, 20)
    val arco2 = Bow("Arco de leyenda1", 3, 20)
    val arco3 = Bow("Arco de leyenda3", 3, 20)

    val bastonVainilla1 = Staff("baston blanco", 1, 20, 20)
    val bastonVainilla2 = Staff("baston blanco", 1, 20, 20)
    val bastonChocolate = Staff("baston negro", 1, 20, 30)

    // ---------------------------------Party-----------------------------------------
    val ladron1 = Thief("ladronzuelo1", 10, 10, queue)
    val ladron2 = Thief("ladronzuelo1", 10, 10, queue)
    val ladron3 = Thief("ladronzuelo3", 10, 10, queue)

    val caballero1 = Knight("Caballo1", 20, 15, queue)
    val caballero2 = Knight("Caballo1", 20, 15, queue)
    val caballero3 = Knight("Caballo3", 20, 15, queue)

    val ingeniero1 = Engineer("Yop1", 15, 20, queue)
    val ingeniero2 = Engineer("Yop1", 15, 20, queue)
    val ingeniero3 = Engineer("Yop3", 15, 20, queue)

    val magoBlanco1 = WhiteMage("Mago blanco1", 20, 20, 5, queue)
    val magoBlanco2 = WhiteMage("Mago blanco1", 20, 20, 5, queue)
    val magoBlanco3 = WhiteMage("Mago blanco3", 20, 20, 5, queue)

    val magoNegro1 = BlackMage("Mago negro1", 20, 15, 10, queue)
    val magoNegro2 = BlackMage("Mago negro1", 20, 15, 10, queue)
    val magoNegro3 = BlackMage("Mago negro3", 20, 15, 10, queue)

    // ---------------------------------Enemigos-----------------------------------------
    val enemigo1 = Enemy("enemigo enemiga1", 12, 20, 1, queue)
    val enemigo2 = Enemy("enemigo enemiga1", 12, 20, 1, queue)
    val enemigo3 = Enemy("enemigo enemiga3", 12, 20, 1, queue)

    ladron1.equip(cuchillo1)
    ladron1.waitTurn()

    ladron1.equip(arco1)

    caballero1.equip(espada1)
    caballero1.waitTurn()

    ingeniero1.equip(llaveInglesa1)
    ingeniero1.waitTurn()

    magoBlanco1.equip(bastonVainilla1)
    magoBlanco1.waitTurn()

    magoNegro1.equip(bastonChocolate)
    magoNegro1.waitTurn()
    println("----------------------Probando Equals---------------------\n")
    println("cuchillo 1 es igual a cuchillo 2 : " + cuchillo1.equals(cuchillo2))
    println("cuchillo 2 es igual a cuchillo 1 : " + cuchillo2.equals(cuchillo1))
    println("cuchillo 3 es igual a cuchillo 1 : " + cuchillo3.equals(cuchillo1) + "\n")

    println("espada 1 es igual a espada 2 : " + espada1.equals(espada2))
    println("espada 2 es igual a espada 1 : " + espada2.equals(espada1))
    println("espada 3 es igual a espada 1 : " + espada3.equals(espada1) + "\n")

    println("arco 1 es igual a arco 2 : " + arco1.equals(arco2))
    println("arco 2 es igual a arco 1 : " + arco2.equals(arco1))
    println("arco 3 es igual a arco 1 : " + arco3.equals(arco1) + "\n")

    println("llaveInglesa 1 es igual a llaveInglesa 2 : " + llaveInglesa1.equals(llaveInglesa2))
    println("llaveInglesa 2 es igual a llaveInglesa 1 : " + llaveInglesa2.equals(llaveInglesa1))
    println("llaveInglesa 3 es igual a llaveInglesa 1 : " + llaveInglesa3.equals(llaveInglesa1) + "\n")

    println("bastonVainilla 1 es igual a bastonVainilla 2 : " + bastonVainilla1.equals(bastonVainilla2))
    println("bastonVainilla 2 es igual a bastonVainilla 1 : " + bastonVainilla2.equals(bastonVainilla1))
    println("bastonChocolate 3 es igual a bastonVainilla 1 : " + bastonChocolate.equals(bastonVainilla1) + "\n")

    println("ladron 1 es igual a ladron 2 : " + ladron1.equals(ladron2))
    println("ladron 2 es igual a ladron 1 : " + ladron2.equals(ladron1))
    println("ladron 3 es igual a ladron 1 : " + ladron3.equals(ladron1) + "\n")

    println("caballero 1 es igual a caballero 2 : " + caballero1.equals(caballero2))
    println("caballero 2 es igual a caballero 1 : " + caballero2.equals(caballero1))
    println("caballero 3 es igual a caballero 1 : " + caballero3.equals(caballero1) + "\n")

    println("ingeniero 1 es igual a ingeniero 2 : " + ingeniero1.equals(ingeniero2))
    println("ingeniero 2 es igual a ingeniero 1 : " + ingeniero2.equals(ingeniero1))
    println("ingeniero 3 es igual a ingeniero 1 : " + ingeniero3.equals(ingeniero1) + "\n")

    println("magoBlanco 1 es igual a magoBlanco 2 : " + magoBlanco1.equals(magoBlanco2))
    println("magoBlanco 2 es igual a magoBlanco 1 : " + magoBlanco2.equals(magoBlanco1))
    println("magoBlanco 3 es igual a magoBlanco 1 : " + magoBlanco3.equals(magoBlanco1) + "\n")

    println("magoNegro 1 es igual a magoNegro 2 : " + magoNegro1.equals(magoNegro2))
    println("magoNegro 2 es igual a magoNegro 1 : " + magoNegro2.equals(magoNegro1))
    println("magoNegro 3 es igual a magoNegro 1 : " + magoNegro3.equals(magoNegro1) + "\n")

    // Waits for 6 seconds to ensure that all characters have finished waiting
    println("--------------------------------Personajes-------------------------------\n")
    Thread.sleep(6000)
    while (!queue.isEmpty()) {
        // Pops and prints the names of the characters of the queue to illustrate the turns
        // order
        println(queue.poll())
    }
    println("--------------------------------Armas------------------------------------\n")
    println(cuchillo1)
    println(espada1)
    println(arco1)
    println(llaveInglesa1)
    println(bastonVainilla1)
    println(bastonChocolate)
}
