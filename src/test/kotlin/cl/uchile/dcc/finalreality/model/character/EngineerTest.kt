package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.model.character.player.Engineer
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class EngineerTest : FunSpec(
    {
        lateinit var injeniero1: Engineer
        lateinit var injeniero2: Engineer
        lateinit var queue: BlockingQueue<GameCharacter>

        beforeEach {
            queue = LinkedBlockingQueue()

            injeniero1 = Engineer(
                "injeniero1",
                100,
                20,
                queue
            )
            injeniero2 = Engineer(
                "injeniero2",
                100,
                10,
                queue
            )
        }
        test("A Engineer should should be equal to itself") {
            injeniero1 shouldBeSameInstanceAs injeniero1
            injeniero1 shouldBe injeniero1
        }

        test("Two Engineers should be equal if their stats and name are the same") {
            val injeniero3 = Engineer(
                "injeniero1",
                100,
                20,
                queue
            )
            injeniero1 shouldNotBeSameInstanceAs injeniero3
            injeniero1 shouldBe injeniero3
        }

        test("Two Engineers should be different if they have different stats or names") {
            injeniero1 shouldNotBe injeniero2
        }

        test("Two Engineers with same stats and name should have the same hash code") {
            val injeniero3 = Engineer(
                "injeniero1",
                100,
                20,
                queue
            )
            injeniero1 should haveSameHashCodeAs(injeniero3)
        }

        test("The string representation of a Engineer should be correct") {
            "$injeniero1" shouldBe "Engineer { name: injeniero1, maxHp: 100, currentHp: 100," +
                " defense: 20 }"
        }
    })