package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class ThiefTest : FunSpec(
    {
        lateinit var ladron1: Thief
        lateinit var ladron2: Thief
        lateinit var queue: BlockingQueue<GameCharacter>

        beforeEach {
            queue = LinkedBlockingQueue()

            ladron1 = Thief(
                "ladron1",
                100,
                20,
                queue
            )
            ladron2 = Thief(
                "ladron2",
                100,
                10,
                queue
            )
        }
        test("A Thief should should be equal to itself") {
            ladron1 shouldBeSameInstanceAs ladron1
            ladron1 shouldBe ladron1
        }

        test("Two Thiefs should be equal if their stats and name are the same") {
            val ladron3 = Thief(
                "ladron1",
                100,
                20,
                queue
            )
            ladron1 shouldNotBeSameInstanceAs ladron3
            ladron1 shouldBe ladron3
        }

        test("Two Thiefs should be different if they have different stats or names") {
            ladron1 shouldNotBe ladron2
        }

        test("Two Thiefs with same stats and name should have the same hash code") {
            val ladron3 = Thief(
                "ladron1",
                100,
                20,
                queue
            )
            ladron1 should haveSameHashCodeAs(ladron3)
        }

        test("The string representation of a Thief should be correct") {
            "$ladron1" shouldBe "Thief { name: ladron1, maxHp: 100, currentHp: 100," +
                " defense: 20 }"
        }
    })