package com.lightbend.akka.sample

import org.scalatest.{ BeforeAndAfterAll, FlatSpecLike, Matchers }
import akka.actor.{ Actor, Props, ActorSystem }
import akka.testkit.{ ImplicitSender, TestKit, TestActorRef, TestProbe }
import scala.concurrent.duration._
import Greeter._
import Common._

class HelloAkkaSpec(_system: ActorSystem)
  extends TestKit(_system)
  with ImplicitSender
  with Matchers
  with FlatSpecLike
  with BeforeAndAfterAll {

  def this() = this(ActorSystem("HelloAkkaSpec"))

  override def afterAll: Unit = {
    TestKit.shutdownActorSystem(system)
  }

  "An HelloAkkaActor" should "be able to set a greeting message" in {
    val helloGreetingMessage = "hello"
    val hiGreetingMessage = "hi"
    val helloGreeter = TestActorRef(Greeter.props(helloGreetingMessage, null))
    val hiGreeter = TestActorRef(Greeter.props(hiGreetingMessage, null))
    val greetPerson = "Akka"
    helloGreeter ! WhoToGreet(greetPerson)
    hiGreeter ! WhoToGreet(greetPerson)
    helloGreeter.underlyingActor.asInstanceOf[Greeter].greeting should be(s"$helloGreetingMessage, $greetPerson")
    hiGreeter.underlyingActor.asInstanceOf[Greeter].greeting should be(s"$hiGreetingMessage, $greetPerson")
  }

  it should "be able to get a new greeting" in {
    val testProbe = TestProbe()
    val helloGreetingMessage = "hello"
    val helloGreeter = system.actorOf(Greeter.props(helloGreetingMessage, testProbe.ref))
    val greetPerson = "Akka"
    helloGreeter ! WhoToGreet(greetPerson)
    helloGreeter ! Greet
    testProbe.expectMsg(500 millis, Greeting(s"$helloGreetingMessage, $greetPerson"))
  }
}
