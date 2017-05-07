
Define the Messages
-------------------

An Actor does not have a public API in terms of methods that you can invoke. Instead its public
API is defined through messages that the actor handles. Messages can be of arbitrary
type (any subtype of `Any`).  This means that we
can send boxed primitive values (such as `String`, `Integer`,
`Boolean` etc.) as messages or plain data structures like arrays and
collection types. However, since the messages are the Actor's public API, you should define
messages with good names and rich semantic and domain specific meaning, even if it's just wrapping
your data type. This will make it easier to use, understand and debug actor-based systems.

Now we want to define three different messages;

- `WhoToGreet` redefines the new greeting
- `Greet` asks the Actor for latest greeting
- `Greeting` returns the latest greeting

Case classes and case objects make excellent messages since they are immutable and have support for pattern matching,
something we will take advantage of in the Actor when matching on the messages it has received. Another advantage case
classes has is that they are marked as serializable by default.

@@snip [HelloAkka.scala]($g8src$/scala/HelloAkka.scala) { #message_snippet }
