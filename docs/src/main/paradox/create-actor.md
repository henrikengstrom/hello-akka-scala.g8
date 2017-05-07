Create the Actor
----------------

So far we have defined our Actor and its messages. Now let's create an instance of this actor. In Akka you can't
create an instance of an Actor the regular way using `new`, instead you create it using a factory. What is
returned from this factory is not an instance of the Actor itself but an `ActorRef` pointing to our actor
instance.

This level of indirection adds a lot of power and flexibility. It enables for example location transparency
meaning that the `ActorRef` can, while retaining the same semantics, represent an instance of the running actor
in-process or on a remote machine. I.e. location doesn't matter. This also means that the runtime can if needed
optimize the system by changing an actor's location or the application's topology while it is running. Another
thing that this level of indirection enables is the "let it crash" model of failure management in which the
system can heal itself by crashing and restarting faulty actors.

This factory in Akka is the `ActorSystem` and is to some extent similar to Spring's `BeanFactory`
in that it also acts as a container for your Actors, managing their life-cycles etc.  You create an Actor through the
`actorOf` factory method. This method takes a configuration object called `Props` and a name.
Actor (and ActorSystem) names are important in Akka, you use them for example when looking Actors up as well as when you
configure them in the <a href="http://doc.akka.io/docs/akka/2.5.1/general/configuration.html">configuration
file</a>, so you should take your time giving your Actors good names.

@@snip [HelloAkka.scala]($g8src$/scala/HelloAkka.scala) { #create_snippet }

Now we have a running instance of a `Greeter` actor. Next we will learn how to communicate with it.
