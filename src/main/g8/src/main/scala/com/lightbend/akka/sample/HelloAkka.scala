package com.lightbend.akka.sample

import akka.actor.{ ActorRef, ActorSystem, Props, Actor, ActorLogging }
import scala.concurrent.duration._

object Common {
  case class Greeting(greeting: String)
}

object Greeter {
  def props(message: String, printerActor: ActorRef): Props = Props(new Greeter(message, printerActor))
  case object Greet
  case class WhoToGreet(who: String)
}

class Greeter(message: String, printerActor: ActorRef) extends Actor {
  import Greeter._
  import Common._

  var greeting = ""

  def receive = {
    case WhoToGreet(who) => greeting = s"$message, $who"
    case Greet           => printerActor ! Greeting(greeting) // Send the current greeting back to the sender
  }
}

object Printer {
  def props: Props = Props[Printer]
}

class Printer extends Actor with ActorLogging {
  import Common._

  def receive = {
    case Greeting(greeting) => log.info(s"Greeting received (from ${sender()}): $greeting")
  }
}

object HelloAkka extends App {
  import Greeter._

  // Create the 'helloakka' actor system
  val system = ActorSystem("helloakka")

  // Create the printer actor
  val printer = system.actorOf(Printer.props, "printerActor")

  // Create the 'greeter' actors
  val howdiGreeter = system.actorOf(Greeter.props("Howdi", printer), "howdiGreeter")
  val helloGreeter = system.actorOf(Greeter.props("Hello", printer), "helloGreeter")
  val goodDayGreeter = system.actorOf(Greeter.props("Good day", printer), "goodDayGreeter")

  howdiGreeter ! WhoToGreet("Akka")
  howdiGreeter ! Greet

  howdiGreeter ! WhoToGreet("Lightbend")
  howdiGreeter ! Greet

  helloGreeter ! WhoToGreet("Scala")
  helloGreeter ! Greet

  goodDayGreeter ! WhoToGreet("Play")
  goodDayGreeter ! Greet


  import scala.concurrent.ExecutionContext.Implicits.global
  system.terminate() onComplete {
    case _ => System.exit(0)
  }
}
