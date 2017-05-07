Tell the Actor (to do something)
--------------------------------

All communication with Actors is done through asynchronous message passing. This is what makes Actors
reactive and event driven. An Actor doesn't do anything unless it's been told to do something, and you
tell it to do something by sending the message. Sending a message asynchronously means that the sender
does not stick around waiting for the message to be processed by the recipient actor. Instead the Actor
hands the message off by putting it on the recipient's mailbox and is then free to do something more
important than waiting for the recipient to react on the message. The actor's mailbox is essentially a
message queue and has ordering semantics, this guarantees that the ordering of multiple messages sent
from the same Actor is preserved, while they can be interleaved with the messages sent by another actor.

You might be wondering what the Actor is doing when it is not processing messages, i.e. doing actual work?
It is in a suspended state in which it does not consume any resources apart from memory.

You tell an Actor to do something by passing in a message into the `tell` method on the
`ActorRef`. This method puts the message on the actor's mailbox and then returns immediately.

@@snip [Snippet.scala]($raw$/Snippet.scala) { #tell_snippet }

In Scala it is also possible to use the alias; `!`, called the bang operator.


@@snip [Snippet.scala]($raw$/Snippet.scala) { #tell_snippet2 }
