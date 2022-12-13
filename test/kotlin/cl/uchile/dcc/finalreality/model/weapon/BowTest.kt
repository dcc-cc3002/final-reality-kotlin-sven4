package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class BowTest : FunSpec(
    {
        lateinit var arco1: Bow
        lateinit var arco2: Bow
        beforeEach {
            arco1 = Bow(
                "arco1",
                20,
                10
            )
            arco2 = Bow(
                "arco2",
                50,
                25
            )
        }
        test("An Bow should be equal to itself") {
            arco1 shouldBeSameInstanceAs arco1
            arco1 shouldBe arco1
        }

        test("Two Bows should be equal if their stats and their names are the same") {
            val arco3 = Bow(
                "arco1",
                20,
                10
            )
            arco1 shouldNotBeSameInstanceAs arco3
            arco1 shouldBe arco3
            arco1 should haveSameHashCodeAs(arco3)
        }

        test("Two Bows should be different if their stats are different") {
            arco1 shouldNotBe arco2
        }

        test("The string representation should be correct") {
            "$arco1" shouldBe "Bow { name: arco1, damage: 20, weight: 10 }"
        }
    })
