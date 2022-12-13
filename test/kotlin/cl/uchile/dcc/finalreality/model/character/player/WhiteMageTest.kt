package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class WhiteMageTest : FunSpec(
    {
        lateinit var blancomago1: WhiteMage
        lateinit var blancomago2: WhiteMage
        lateinit var queue: BlockingQueue<GameCharacter>

        beforeEach {
            queue = LinkedBlockingQueue()

            blancomago1 = WhiteMage(
                "blancomago1",
                100,
                100,
                10,
                queue
            )
            blancomago2 = WhiteMage(
                "blancomago2",
                100,
                50,
                20,
                queue
            )
        }
        test("A WhiteMage should be equal to itself") {
            blancomago1 shouldBeSameInstanceAs blancomago1
            blancomago1 shouldBe blancomago1
        }

        test("Two WhiteMages should be equal if their stats and name are the same") {
            val blancomago3 = WhiteMage(
                "blancomago1",
                100,
                100,
                10,
                queue
            )
            blancomago1 shouldNotBeSameInstanceAs blancomago3
            blancomago1 shouldBe blancomago3
        }

        test("Two WhiteMages should be different if they have different stats or names") {
            blancomago1 shouldNotBe blancomago2
        }

        test("Two WhiteMages with same stats and name should have the same hash code") {
            val blancomago3 = WhiteMage(
                "blancomago1",
                100,
                100,
                10,
                queue
            )
            blancomago1 should haveSameHashCodeAs(blancomago3)
        }

        test("The string representation of a WhiteMage should be correct") {
            "$blancomago1" shouldBe "WhiteMage { name: blancomago1, maxHp: 100, currentHp: 100," +
                " maxMp: 100, currentMp: 100, defense: 10 }"
        }
    })
