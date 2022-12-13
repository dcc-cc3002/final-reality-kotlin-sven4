package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class KnifeTest : FunSpec(
    {
        lateinit var cuchillo1: Knife
        lateinit var cuchillo2: Knife
        beforeEach {
            cuchillo1 = Knife(
                "cuchillo1",
                20,
                10
            )
            cuchillo2 = Knife(
                "cuchillo2",
                50,
                25
            )
        }
        test("An Knife should be equal to itself") {
            cuchillo1 shouldBeSameInstanceAs cuchillo1
            cuchillo1 shouldBe cuchillo1
        }

        test("Two Knifes should be equal if their stats and their names are the same") {
            val cuchillo3 = Knife(
                "cuchillo1",
                20,
                10
            )
            cuchillo1 shouldNotBeSameInstanceAs cuchillo3
            cuchillo1 shouldBe cuchillo3
            cuchillo1 should haveSameHashCodeAs(cuchillo3)
        }

        test("Two Knifes should be different if their stats are different") {
            cuchillo1 shouldNotBe cuchillo2
        }

        test("The string representation should be correct") {
            "$cuchillo1" shouldBe "Knife { name: cuchillo1, damage: 20, weight: 10 }"
        }
    })
