import org.scalatestplus.play._
import services._

class NGServiceImplTestSpec extends PlaySpec {
    "The NGServiceImpl" must {
        "Generate a random number" in {
            val service:NGContract = new NGServiceImpl
            val double = service.generateDouble
            assert( double >= 1)
        }
        "Generate a list of 3 random numbers" in {
            val service:NGContract = new NGServiceImpl
            val doubles = service.generateDoubleBatch(3)
            doubles.size mustBe 3
            assert( doubles(0) >= 1 )
            assert( doubles(1) >= 1 )
            assert( doubles(2) >= 1 )
        }
    }
}
