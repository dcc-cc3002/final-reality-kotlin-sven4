package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapon.Axe
import cl.uchile.dcc.finalreality.model.weapon.Knife
import cl.uchile.dcc.finalreality.model.weapon.Staff
import cl.uchile.dcc.finalreality.model.weapon.Sword
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class AbstractPlayerCharacterTest : FunSpec(
    {
        lateinit var queue: BlockingQueue<GameCharacter>
        lateinit var caballeroso1: Knight
        lateinit var espadaCaballerosa: Sword
        lateinit var engineer: Engineer
        lateinit var llaveInglesa: Axe
        lateinit var negromago: BlackMage
        lateinit var varitaOscura: Staff
        lateinit var magoblanco: WhiteMage
        lateinit var varitaBlanca: Staff
        lateinit var ladron: Thief
        lateinit var cuchillo: Knife
        beforeEach {
            queue = LinkedBlockingQueue<GameCharacter>()
            caballeroso1 = Knight(
                "Artorias",
                100,
                20,
                queue
            )
            espadaCaballerosa = Sword(
                "Excalibur",
                200,
                100
            )
            engineer = Engineer(
                "engineer tf2",
                200,
                20,
                queue
            )
            llaveInglesa = Axe(
                "llaveInglesa",
                15,
                50
            )
            negromago = BlackMage(
                "negromago",
                20,
                2000,
                10,
                queue
            )
            varitaOscura = Staff(
                "varitaOscura",
                10,
                10,
                200
            )
            magoblanco = WhiteMage(
                "magoblanco",
                300,
                200,
                10,
                queue
            )
            varitaBlanca = Staff(
                "varitablanca",
                10,
                30,
                100
            )
            ladron = Thief(
                "aza",
                100,
                10,
                queue
            )
            cuchillo = Knife(
                "cuchillo",
                10,
                20
            )
            caballeroso1.equip(espadaCaballerosa)
            caballeroso1.waitTurn()
            engineer.equip(llaveInglesa)
            engineer.waitTurn()
            negromago.equip(varitaOscura)
            negromago.waitTurn()
            magoblanco.equip(varitaBlanca)
            magoblanco.waitTurn()
            ladron.equip(cuchillo)
            ladron.waitTurn()
        }

        test("The character should have equipped their weapons") {
            caballeroso1.equippedWeapon shouldBe espadaCaballerosa
            engineer.equippedWeapon shouldBe llaveInglesa
            negromago.equippedWeapon shouldBe varitaOscura
            magoblanco.equippedWeapon shouldBe varitaBlanca
            ladron.equippedWeapon shouldBe cuchillo
        }

        test("The characters should popup in the correct order (by weapon weight)") {
            Thread.sleep(10000)
            queue.poll() shouldBe negromago
            queue.poll() shouldBe ladron
            queue.poll() shouldBe magoblanco
            queue.poll() shouldBe engineer
            queue.poll() shouldBe caballeroso1
            queue.isEmpty() shouldBe true
        }
    })
