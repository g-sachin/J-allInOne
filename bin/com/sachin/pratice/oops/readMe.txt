
In Java, only nested classes can be static.

When a nested class is declared “static”, this means that it’s independent from the enclosing class. Enclosing class only acts as
a name prefix, much like a package does. You can create an instance of this static nested class as long as it’s “public enough”.

When a nested class is not “static”, this means its instances depend on having an instance of the enclosing class. Under the hood,
the compiler adds a implicit (hidden) reference to enclosing class, and will refuse to compile the code unless you somehow provide
an enclosing object along with the “new” keyword.

So to use “new”, you have to do it either in the non-static methods of enclosing class,
or use a special syntax “x.new Y()’ where x is an enclosing object.

As a consequence, the nested class can reference any fields of the
enclosing class.

So when should you use them?

Use nested classes when they are short and when their functionality is 90% or more used within the enclosing class.
Use static nested class by default.
When you need to access the fields in enclosing class from the nested class, remove the “static” keyword from nested class.
This will save you a few lines of code because you don’t have to declare and pass the enclosing instance manually.
Apart from that, nested classes are just syntactic sugar, so they are not in any way neccessary - they’re just a matter of style.