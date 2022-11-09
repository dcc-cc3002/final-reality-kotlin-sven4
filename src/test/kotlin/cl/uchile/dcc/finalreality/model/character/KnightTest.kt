package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.model.character.player.Knight
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class KnightTest : FunSpec(
    {
        lateinit var caballo1: Knight
        lateinit var caballo2: Knight
        lateinit var queue: BlockingQueue<GameCharacter>

        beforeEach {
            queue = LinkedBlockingQueue()

            caballo1 = Knight(
                "caballo1",
                100,
                20,
                queue
            )
            caballo2 = Knight(
                "caballo2",
                100,
                10,
                queue
            )
        }
        test("A Knight should should be equal to itself") {
            caballo1 shouldBeSameInstanceAs caballo1
            caballo1 shouldBe caballo1
        }

        test("Two Knights should be equal if their stats and name are the same") {
            val caballo3 = Knight(
                "caballo1",
                100,
                20,
                queue
            )
            caballo1 shouldNotBeSameInstanceAs caballo3
            caballo1 shouldBe caballo3
        }

        test("Two Knights should be different if they have different stats or names") {
            caballo1 shouldNotBe caballo2
        }

        test("Two Knights with same stats and name should have the same hash code") {
            val caballo3 = Knight(
                "caballo1",
                100,
                20,
                queue
            )
            caballo1 should haveSameHashCodeAs(caballo3)
        }

        test("The string representation of a Knight should be correct") {
            "$caballo1" shouldBe "Knight { name: caballo1, maxHp: 100, currentHp: 100," +
                " defense: 20 }"
        }
    })