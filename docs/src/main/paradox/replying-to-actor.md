Replying to an Actor
--------------------

### The 'self' reference

Sometimes the communication pattern is not just a one-way style of communication but instead lends
itself towards request-reply. One explicit way of doing that is by adding a reference of yourself as part
of the message so the receiver can use that reference to send a reply back to you. This is such a common
scenario that it is directly supported by Akka; for every message you send you have the option of passing
along the sender reference (the Actor's `ActorRef`).  If you are sending a message from within
an Actor then you have access to your own `ActorRef` through `self` reference, please
note that you should never use `this`. Access the self reference through the `self` method.

Scala has something called
<a href="http://docs.scala-lang.org/tutorials/tour/implicit-parameters.html">implicit parameters</a> which allows us to automatically and
transparently pass in parameters into methods, a feature that we are taking advantage of here to automatically
pass along the sender reference when you send a message to another Actor.

This code will, if invoked from within Actor 'A' automatically pass along the `ActorRef` of
Actor 'A' as the sender of this message:

@@snip [Snippet.scala]($raw$/Snippet.scala) { #self_snippet }

If you choose not to pass in a sender reference into the `tell` method, or forget it, then a reference to
the 'dead-letter' Actor will be used. The 'dead-letter' Actor is where all unhandled messages end up, and
you can use Akka's <a href="http://doc.akka.io/docs/akka/2.5/java/event-bus.html">Event Bus</a> to subscribe on them.

### The 'sender' reference

This sender reference will then be available in the receiver Actor when it's processing the message. Since
each message is paired with its unique sender reference, the "current" sender reference will change with each
new message you process. So if you for some reason need to use a specific sender reference later then you have
to hold on to it, storing it away in a member field or similar. Access the sender using the `sender` method.

@@snip [Snippet.scala]($raw$/Snippet.scala) { #sender_snippet }
