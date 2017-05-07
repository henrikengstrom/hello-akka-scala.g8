Using the Inbox
---------------

Most real-world Actor applications make use of more than one Actor. The inventor of the Actor Model,
Carl Hewitt, recently said in an interview that; "One Actor is no Actor. Actors come in systems."
This is important wisdom. To truly leverage the Actor Model you should use lots of Actors. Every hard
problem in Actor programming can be solved by adding more Actors; by breaking down the problem into
subtasks and delegate by handing them to new Actors.

However, for simplicity we are just using a single Actor in this sample. This means that if we communicate
with this single actor from a `main` program then we have no `sender`, since we are
not communicating with the Actor from within another Actor. Luckily Akka has a nice solution to this problem;
`Inbox`.

`Inbox` allows you to create an "actor-in-a-box", i.e. it contains an Actor which can be used as a puppet
for sending messages to other Actors and receiving their replies. You can create an `Inbox` using
`Inbox.create` and send messages from it using `inbox.send`. The internal Actor will just
put any message it receives into a queue from which it can be retrieved by calling `inbox.receive`;
if the queue is empty then that call will block until a message becomes available. Pretty simple.

As you probably know, blocking is something that can really inhibit performance and scalability, and that
you should use very sparingly and with care. That said, we are making use of it in this sample since it
simplifies the sample and makes it very easy to follow the message flow.

Now let's complete this tutorial by writing the driver code that will exercise our `Greeter` Actor.

@@snip [HelloAkka.scala]($g8src$/scala/HelloAkka.scala) { #inbox_snippet }
