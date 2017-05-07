Hello Akka
==========

You've just created a simple Akka application! Now lets explore the code and make some changes.

In short, <a href="http://akka.io">Akka</a> is a toolkit and runtime for building highly concurrent,
distributed, and fault-tolerant event-driven applications on the JVM. Akka can be used with both Java
and Scala. One of the most powerful features of Akka is its <a href="http://en.wikipedia.org/wiki/Actor_model">
Actor Model</a> of concurrency, which you will learn more about in this tutorial.

Akka can be used from either Java or Scala and this tutorial uses Scala sample code.

### Source code

The `src/main/scala` directory contains the Scala source code `HelloAkka.scala`.

The sample in this tutorial is pretty simple; it consists of a <code>Greeter</code> Actor who holds
onto the latest defined <code>greeting</code> string and can respond to two actions; set a new greeting
string and return the latest greeting string.

Next let's get started.

@@@index

* [Define the messages](define-messages.md)
* [Define the messages](define-actor.md)
* [Create the Actor](create-actor.md)
* [Tell the Actor (to do something)](tell-actor.md)
* [Replying to Actor](replying-to-actor.md)
* [Using the Inbox](using-inbox.md)
* [Test the App](test-app.md)
* [Run the App](run-app.md)

@@@
