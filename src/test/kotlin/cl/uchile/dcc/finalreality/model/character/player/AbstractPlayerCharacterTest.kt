package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponEquipped
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapon.Axe
import cl.uchile.dcc.finalreality.model.weapon.Bow
import cl.uchile.dcc.finalreality.model.weapon.Knife
import cl.uchile.dcc.finalreality.model.weapon.Staff
import cl.uchile.dcc.finalreality.model.weapon.Sword
import io.kotest.assertions.throwables.shouldThrow
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
        lateinit var arco: Bow
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
            arco = Bow(
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

        test("The game should allow the knight to equip a sword") {
            caballeroso1.equip(espadaCaballerosa)
            caballeroso1.equippedWeapon shouldBe espadaCaballerosa
        }

        test("The game should allow the knight to equip an axe") {
            caballeroso1.equip(llaveInglesa)
            caballeroso1.equippedWeapon shouldBe llaveInglesa
        }

        test("The game should allow the knight to equip a knife") {
            caballeroso1.equip(cuchillo)
            caballeroso1.equippedWeapon shouldBe cuchillo
        }

        test("The game should throw an exception if the knight equips a staff") {
            shouldThrow<InvalidWeaponEquipped> {
                caballeroso1.equip(varitaOscura)
            }
        }

        test("The game should throw an exception if the knight equips a bow") {
            shouldThrow<InvalidWeaponEquipped> {
                caballeroso1.equip(arco)
            }
        }

        test("The game should throw an exception if the engineer equips a sword") {
            shouldThrow<InvalidWeaponEquipped> {
                engineer.equip(espadaCaballerosa)
            }
        }

        test("The game should allow the engineer to equip an axe") {
            engineer.equip(llaveInglesa)
            engineer.equippedWeapon shouldBe llaveInglesa
        }

        test("The game should throw an exception if the engineer equips a knife") {
            shouldThrow<InvalidWeaponEquipped> {
                engineer.equip(cuchillo)
            }
        }

        test("The game should throw an exception if the engineer equips a staff") {
            shouldThrow<InvalidWeaponEquipped> {
                engineer.equip(varitaOscura)
            }
        }

        test("The game should allow the engineer to equip a bow") {
            engineer.equip(arco)
            engineer.equippedWeapon shouldBe arco
        }

        test("The game should allow the thief to equip a sword") {
            ladron.equip(espadaCaballerosa)
            ladron.equippedWeapon shouldBe espadaCaballerosa
        }

        test("The game should throw an exception if the thief equips an axe") {
            shouldThrow<InvalidWeaponEquipped> {
                ladron.equip(llaveInglesa)
            }
        }

        test("The game should allow the thief to equip a knife") {
            ladron.equip(cuchillo)
            ladron.equippedWeapon shouldBe cuchillo
        }

        test("The game should throw an exception if the thief equips a staff") {
            shouldThrow<InvalidWeaponEquipped> {
                ladron.equip(varitaOscura)
            }
        }

        test("The game should allow the thief to equip a bow") {
            ladron.equip(arco)
            ladron.equippedWeapon shouldBe arco
        }

        test("The game should throw an exception if the black mage equips a sword") {
            shouldThrow<InvalidWeaponEquipped> {
                negromago.equip(espadaCaballerosa)
            }
        }

        test("The game should throw an exception if the black mage equips an axe") {
            shouldThrow<InvalidWeaponEquipped> {
                negromago.equip(llaveInglesa)
            }
        }

        test("The game should allow the black mage to equip a knife") {
            negromago.equip(cuchillo)
            negromago.equippedWeapon shouldBe cuchillo
        }

        test("The game should allow the black mage to equip a staff") {
            negromago.equip(varitaOscura)
            negromago.equippedWeapon shouldBe varitaOscura
        }

        test("The game should throw an exception if the black mage equips a bow") {
            shouldThrow<InvalidWeaponEquipped> {
                negromago.equip(arco)
            }
        }

        test("The game should throw an exception if the white mage equips a sword") {
            shouldThrow<InvalidWeaponEquipped> {
                magoblanco.equip(espadaCaballerosa)
            }
        }

        test("The game should throw an exception if the white mage equips an axe") {
            shouldThrow<InvalidWeaponEquipped> {
                magoblanco.equip(llaveInglesa)
            }
        }

        test("The game should throw an exception if the white mage equips a knife") {
            shouldThrow<InvalidWeaponEquipped> {
                magoblanco.equip(cuchillo)
            }
        }

        test("The game should allow the white mage to equip a staff") {
            magoblanco.equip(varitaOscura)
            magoblanco.equippedWeapon shouldBe varitaOscura
        }

        test("The game should throw an exception if the white mage equips a bow") {
            shouldThrow<InvalidWeaponEquipped> {
                magoblanco.equip(arco)
            }
        }
    })
