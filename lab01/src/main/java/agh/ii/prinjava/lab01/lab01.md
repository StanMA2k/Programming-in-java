Exercise 1
1.	Explain the concept of encapsulation and the way it is implemented in Java

      It’s a fundamental concept in OOP that involves bundling attributes and methods on a single unit or class. Encapsulation ensures that an object's internal state cannot be directly accessed from outside the object, it is a way of preventing accidental modification of data.
      implement: declare class variables (attributes as private)/setter and getter methods.
2.	Explain the following concepts:

      Mutator method (setter): is used to set or modify the value of a private field of a class. It allows the external code to change the state of an object while the data is encapsulated.

      Accessor method (getter): is used to read the value of a private field without modifying it. It provides an access to the object from outside the class.
3.	Explain two different meanings/roles of:

      this: referencing instance variable, invoke constructors overloading.

      super: access to superclass methods and variables, invoke superclass constructors.
4.	Explain the concept of inheritance and the way it is implemented in Java

      Inheritance allows a class to inherit fields/attributes and method from another class. The concept is consisted of superclass and subclass.

5.	Explain the concept of polymorphism, name its three main kinds/forms, and explain the way they are implemented in Java
      Static polymorphism: this kind of polymorphism contains method overloading and operator overloading.
      Dynamic polymorphism: this kind of polymorphism is using method overriding with inheritance.
      ad-hoc
6.	Explain the relationship between inheritance and sub-type/inclusion polymorphism
    Inheritance is the base of sub-type polymorphism. Through inheritance, a subclass inherits behavior from its parent but can also override inherited methods, providing its specific implementation.

7.	Read Composition vs. Inheritance: How to Choose?
8.	In the analysed code identify testable methods and write a couple of unit tests for them (the IDE can help with it)

Exercise 2
1. Explain the following concepts:

      static variable (field/class member): belongs to the whole class but not only certain instances. Once the variable changed, it can affect the whole class.

      static constant: the value of this constant is shared in the class and can't be changed(final)

      static method: the method can be called directly by its name without creating any instance.
2. Explain why static constants often have public visibility

    A static constant can't be changed and can be called in the whole class, it's often necessary to let it have public visibility to call this instance.
3. Explain why static methods do not have access to instance members (methods and fields)

    A static method belongs to the class itself, not belongs to any instance members.
4. Give one example of a static method application
    Create a class and create a new instance in Main method.

Exercise 3
1. Describe the object initialisation process for a class derived from the Object class (including default values for different types of fields/variables, static variables, static constants, anonymous static blocks, anonymous blocks, constructors)

   At first, all static fields would be initialised at an order of their appearance in the class, the static variables, the static constants and the static methods are initialised in this step. Then it comes to the instances, the instance variable would be set to a default value. In the end the constructors are initialised.
2. For class D9 from (defined in ClassFamily.java):

   draw the class (inheritance) diagram

   explain the sequence of the constructor calls
        
    The sequence would begin from the parent class. After new D9, it would turn to D1, then B1 (B1 is the "big" parent) , it turns back to D1 after the construction then turns back to D9.
4. Compare capabilities of constructors and factory methods
    In constructors, a new instance is created as a basis of constructors. These constructors are encapsulated in the class and when a new instance is being created the program will browse every constructor to creat the demanded instance. But for the factory method which is another encapsulation inside a class, we can't create a new instance directly from outside, but we need to call this method. 
    
5. Give at least two applications of the singleton pattern

    First application: configuration manager (if one PC has two printers, the printers won't print 2 document)
    Second application: logger manager (one for all)
6. Write a couple of unit test (JUnit 5) for singletons from lst01_08

public class EagerSingletonTest {

   @Test
   void testUniqueInstance() {

      EagerSingleton instance1 = EagerSingleton.getInstance();
      EagerSingleton instance2 = EagerSingleton.getInstance();
      assertSame(instance1, instance2, "Instance1 is the same as instance2");
   }
   }
    
public class LazySingletonTest(){

    @Test
    void testNotNullInstance(){
        LazySingleton instance = LazySingleton.getInstance();
        assertNotNull(instance, "Instance is not null")
    
}
}

Exercise 4
1. Explain a strategy for defining immutable objects

    To create an immutable object, we need to use "final" to make sure that all fields are unchangeable. Those fields should also be private and provide getters to call those fields. 
2. Compare the concepts of the immutable object and immutable class

    The immutable object and immutable class are both immutable, which means that "final" and "private" are essential for the two terms. The difference is that an instance created by immutable class can't be changed in all the program. An immutable object focus on unchanging one single instance. 
3. Explain the advantages of immutable objects

    One advantage is that an immutable object can be used safely in concurrent program, and it can be stored and recalled in cache. 
4. Give at least two uses of the Java Records

    First use: as a carrier of immutable object
    Second use: show database result
5. Write a couple of unit tests to for HelloImmutable and HelloJavaRecord

public class HelloImmutableTest(){

    @Test
    void testImmutableInstance(){
        int newI1 = 1;
        String newS1 = "HelloImmu";
        HelloImmutable instanceInt = HelloImmutable.getI1();
        HelloImmutable instanceStr = HelloImmutable.getS1();
        assertEquals(newI1, HelloImmutable.getI1(), "The two values are equal")
        assertEquals(newS1, HelloImmutable.getS1(), "The two values are equal")
    @Test
    void testInstanceEquility(){
        HelloImmutable instance1 = new HelloImmutable(1,"HelloImmu");
        HelloImmutable instance2 = new HelloImmutable(1,"HelloImmu");
        assertEquals(instance1, instance2, "The two instances are equal ")

}
}


Exercise 5
1. Explain the difference between == operator and equals method in Java (consider primitive and reference types)
    
    == is used to compare the values, usually for primitive data type. equals is used to compare the content of 2 objects
2. Explain the following formula o1.equals(o2) $\implies$ hashCode(o1) == hashCode(o2)

    If o1.equals(o2) is true, then hashCode(o1) equals tp hashCode(o2)
3. Familiarize yourself with the Java Object class

4. Explain the general contract of hashCode and equals
    
    If two objects are equal to each other according to equals method, then the hashcode() are the same. But in the contrary, equals may not return true is the hashcode() are the same.
5. Generate JavaDOC documentation for the project (hint: Tools > Generate JavaDoc)