package cl.uchile.dcc.finalreality.model.character

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

class EnemyTest : FunSpec(
    {
        lateinit var enemigo1: Enemy
        lateinit var enemigo2: Enemy
        lateinit var queue: BlockingQueue<GameCharacter>
        beforeEach {
            queue = LinkedBlockingQueue()
            enemigo1 = Enemy(
                "enemigo1",
                20,
                100,
                20,
                queue
            )
            enemigo2 = Enemy(
                "enemigo2",
                30,
                300,
                20,
                queue
            )
            enemigo1.waitTurn()
            enemigo2.waitTurn()
        }

        test("An enemy should be equal to itself") {
            enemigo1 shouldBeSameInstanceAs enemigo1
            enemigo1 shouldBe enemigo1
            enemigo1 should haveSameHashCodeAs(enemigo1)
        }

        test("Two enemies should not be equal if they have different stats") {
            enemigo1 shouldNotBe enemigo2
        }

        test("Two enemies should be equal if they have the same stats") {
            val enemigo3 = Enemy(
                "enemigo1",
                20,
                100,
                20,
                queue
            )
            enemigo1 shouldNotBeSameInstanceAs enemigo3
            enemigo1 shouldBe enemigo3
            enemigo1 should haveSameHashCodeAs(enemigo3)
        }
        test("Enemies should popup in the correct order") {
            Thread.sleep(4000)
            queue.poll() shouldBe enemigo1
            queue.poll() shouldBe enemigo2
            queue.isEmpty()
        }
    })
