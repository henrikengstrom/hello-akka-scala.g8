// #tell_snippet
// Tell the 'greeter' to change its 'greeting' message
greeter.tell(WhoToGreet("akka"), ActorRef.noSender)
// end #tell_snippet

// #tell_snippet2
// Tell the 'greeter' to change its 'greeting' message
greeter ! WhoToGreet("akka")
// end #tell_snippet2

// #self_snippet
// From within an Actor
greeter ! Greet
// end #self_snippet

// #sender_snippet
// From within the Greeter Actor
sender ! Greeting(greeting)
// end #sender_snippet
