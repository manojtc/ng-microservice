package services

import scala.util.Random
import scala.util.Random.nextDouble

class NGServiceImpl extends NGContract {
    override def generateDouble:Double = {
        Stream.continually(nextDouble * 1000).take(1).toList.head
    }

    override def generateDoubleBatch(n:Int):List[Double] = {
        require(n >= 1, "Number must be bigger than 0")
        val nTimes: Option[Int] = Option(n)
        nTimes match {
            case Some(number:Int) =>
                Stream.continually(nextDouble * 1000).take(n).toList
            case None =>
                throw new IllegalArgumentException("You need to provide a valid number of doubles your need.")
        }
    }
}
