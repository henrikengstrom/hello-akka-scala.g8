Test the App
------------

The <a href="#code/src/test/scala/HelloAkkaSpec.scala" class="shortcut">Scala tests</a> use ScalaTest.

@@snip [HelloAkkaSpec.scala]($g8srctest$/scala/HelloAkkaSpec.scala) { #test_snippet }

The tests are making use of the excellent Akka
<a href="http://doc.akka.io/docs/akka/2.5.1/scala/testing.html" target="_blank">TestKit</a> module,
which makes it so much easier to test and verify concurrent code.

Making changes to the sample's source or the test source will cause the tests to be automatically re-run.
