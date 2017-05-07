Define the Actor
----------------

The Actor is the unit of execution in Akka.  Actors are object-oriented in the sense that they encapsulate
state and behavior, but they have much stronger isolation than regular objects in Scala. The Actor
model prevents sharing state between Actors and the only way to observe another actor's state is by sending
it a message asking for it. Actors are extremely lightweight, they are only constrained by memory of which
they consume only a few hundred bytes each &#8212; this means you can easily create millions of concurrent
Actors in a single application. Their strong isolation principles together with the event-driven model (that
we will talk about later on) and location transparency makes it easy to solve hard concurrency and scalability
problems in an intuitive way.

You create an Actor by defining a class that extends `akka.actor.Actor` trait and implement the
`receive` method. It is in the `onReceive` method that you define the behavior; how
the Actor should react to the different messages it receives.  An Actor can have &#8212; and often has &#8212;
state.  Accessing or mutating the internal state of an Actor is fully thread safe since protected by the Actor model.

So, let's now create a `Greeter` Actor with a single variable `greeting` as its state, holding on to the latest
defined greeting, and in its `onReceive` method let's add the behavior for how it should react upon receiving
the `WhoToGreet` and the `Greet` messages.

Now let's implement it. As you can see, Scala's pattern matching features really simplify working
with Actors, but apart from that it's pretty similar to the Java version (you can find the code in the
<a href="#code/src/main/scala/HelloAkka.scala" class="shortcut">HelloAkka.scala</a> file).

@@snip [HelloAkka.scala]($g8src$/scala/HelloAkka.scala) { #actor_snippet }

You will notice one difference to the Java version: here we do not
explicitly pass unhandled messages to the `unhandled()` method.
This is not necessary since the behavior defined by the
`receive` method is expressed as a so-called <em>partial
  function</em>, which means that all messages for which no matching
`case` statement is written down will be recognized as being not
handled and Akka will automatically pass them to the
`unhandled()` method for you.
