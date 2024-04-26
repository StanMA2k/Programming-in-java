1) Functional interfaces, lambda expressions and method references

Analyse the source code in package lst06_01

Exercises

Explain the following concepts: functional interface, lambda expression, and method reference
- functional interface: usually used with lambda expressions, this interface contains only one abstract method but it can contain many default methods and static methods. 
```java
@FunctionalInterface //not obligated but recommended
public interface SimpleFunctionalInterface {
    void execute(); // abstract method

    default void print() {
        System.out.println("Hello from default method!");
    }

    static void staticMethod() {
        System.out.println("Hello from static method!");
    }
}

```
- lambda: (parameters) -> expression or (parameters) -> { statements; } 
```java
Flyable f1 = (lat, lon) -> System.out.println("Flying (with lambda) to (" + lat + ", " + lon + ")"); //lat and lon are parameters, system.out.println is expression
```
- method reference: is used to directly call a existing method or constructor. Examples: Static method - Integer::parseInt; instance method - System.out::println, String::length; constructor - ArrayList::new

Write and test anonymous functions (lambda expressions) corresponding to:

f1(x)=x−2; x∈ℝ
```java
Function<Double, Double> f1 = x -> x - 2;
//test
 System.out.println("f1(10) = " + f1.apply(10.0));  //output should be 8
 ```     
f2(x,y)=(√x2+y2); x,y∈ℝ
```java
BiFunciton<Double,Double, Double> f2 = (x,y) -> Math.sqrt(x * x + y * y);
//test
System.out.println("f1(2,3) = " + f2.apply(2.0,3.0));
```
f3(x,y,z)=(√x2+y2+z2); x,y,z∈ℤ
```java
TriFunciton<Integer, Integer, Integer, Double> f3 = (x,y,z) -> Math.sqrt(x * x + y * y + z * z);
//test
System.out.println("f3(2, 3, 4) = " + f3.apply(2, 3, 4));
```

Write and test anonymous functions corresponding to: sqrt, abs, log, id
```java
Function<Integer, Double> f1 = x ->Math.sqrt(x);
Function<Integer, Integer> f2 = x -> Math.abs(x);
Function<Double, Double> f3 = x -> Math.log(x);
System.out.println("f1.apply(4): " + f1.apply(4)); // output 2
System.out.println("f2.apply(-4): " + f2.apply(-4)); // output 4
System.out.println("f3.apply(1.0): " + f3.apply(1.0)); //output 0
```
Given:
```java
@FunctionalInterface
interface FunIf<T, R> {
R apply(T t);
}
```
complete the following code using lambda expressions:
```java
FunIf<String, Integer> f1 = s -> s.length;
FunIf<Integer, String> f2 = i -> i.toString();
FunIf<Double, Double> f3 = d -> Math.sqrt(d);
FunIf<Integer, Boolean> f4 = i -> isPositive(i); //suppose I have an isPositive() method
FunIf<Boolean, Integer > f5 = b -> b ? 1 : 0;; //if true, print 1
FunIf<Boolean, Boolean > f6 = b -> true; //always true
```
Repeat the previous exercise using method references instead of lambda expressions (note: you should probably implement these methods first)
```java
FunIf<String, Integer> f1 = String::length;
FunIf<Integer, String> f2 = Integer::parseInt;
FunIf<Double, Double> f3 = Math::sqrt;
```
2) Standard functional interfaces

Analyse the source code in package lst06_02

Exercises

Familiarize yourself with the functional interfaces available in java.util.function package

For each of the standard functional interfaces write at least one example that demonstrates its use, i.e.:
```java
Consumer<String> s = s -> System.out.println(s);
BiConsumer<String, String> bc = (s1, s2) -> System.out.println(s1 + " " + s2);
Supplier<Double> randomSupplier = () -> Math.random();
Function<Double, Double> f = d -> Math.sqrt(d);
BiFunciton<Double,Double, Double> f2 = (x,y) -> Math.sqrt(x * x + y * y);
Predicate<Integer> isPositive = p -> p>0;       
BiPredicate<Integer,Integer> lessThan = (a,b) -> a < b;
UnaryOperator<Integer> u = x -> x * x;        
BinaryOperator<Integer> multiply = (a,b) -> a * b; 
```
Explain the rationale behind the primitive type specialisations of the standard generic functional interfaces (e.g., BooleanSupplier, DoubleConsumer)
- Primitive type specialisation can prevent autoboxing and unboxing, which makes the program more efficiency

3) Higher-order functions

Analyse the source code in package lst06_03

Exercises

Using sumOfWith, without defining any new functions, calculate ∑15i=1i5
```java
public class Main {
    private static int sumOfWith(List<Integer> lst, UnaryOperator<Integer> uop) {
        int sum = 0;
        for (var e : lst) {
            sum += uop.apply(e);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        int sumOfFifthPowers = sumOfWith(numbers, x -> (int) Math.pow(x, 5));
        System.out.println("∑15i=1i5 = " + sumOfFifthPowers);
    }
}
```
Write and test function

DoubleUnaryOperator expApproxUpTo(int n) {
//...
}
that returns the n-th order (n<6) Maclaurin polynomial of the function ex, i.e. expApproxUpTo(n) = ∑nk=0xkk!.
```java
 public static DoubleUnaryOperator expApproxUpTo(int n) {
    if (n >= 6 || n < 0) {
        throw new IllegalArgumentException("n must be between 0 and 5.");
    }

    return x -> {
        double sum = 0.0;
        double factorial = 1.0; 
        double power = 1.0;
        for (int k = 0; k <= n; k++) {
        if (k > 0) {
            factorial *= k; 
            power *= x;
        }
        sum += power / factorial; 
        }
        return sum;
        };
    }
```
Write and test function

DoubleUnaryOperator dfr(DoubleUnaryOperator f, double h) {
//...
}
that returns for a given function f, the approximation of its first derivative f′ calculated as (finite-difference): f′(x0,h)≈f(x0+h)−f(x0)h.
```java
 public static DoubleUnaryOperator dfr(DoubleUnaryOperator f, double h) {
    if (h == 0) {
        throw new IllegalArgumentException("Step size h cannot be zero.");
    }
    return x -> (f.applyAsDouble(x + h) - f.applyAsDouble(x)) / h;
}
```
Check the approximation errors corresponding to different values of h

(optional) Write and test function

DoubleUnaryOperator d2f(DoubleUnaryOperator f, double h) {
//...
}
that returns for a given function f, the approximation of its second derivative f″; use different finite-difference schemes

Analyse and test the following method:
```java
private static <T, R> List<R> applyAll(List<Function<T, R>> fs, T x0) {
List<R> ys = new ArrayList<>();

     for (var f : fs) {
         ys.add(f.apply(x0));
     }

     return Collections.unmodifiableList(ys);
}
```
applyAll is a generic method, for an input x0, it applies a function to x0 and returns an unmodifiable list. f.apply(x0)
4) Function composition

Analyse the source code in package lst06_04

Exercises

Using Function.compose create (fi∘gi)(x) for the following pairs of f and g:

f1(x)=2x, g1(x)=x2, x∈ℝ
```java
private static void c1(){
        Function<Integer, Integer> f1 = x -> x * 2;
        Function<Integer, Integer> g1 = x -> x * x;

        int x0 = 3;
        System.out.println("(f1 . g1)(" + x0 +") = " + f1.compose(g1).apply(x0));
    }
```
f2(x)=sin(x), g2(x)=1−x1+x2, x∈ℝ
```java
private static void c2(){
        Function<Integer, Integer> f2 = x -> (int) Math.sin(x);
        Function<Integer, Integer> g2 = x -> 1 - x + x * x;

        int x0 = 3;
        System.out.println("(f2 . g2)(" + x0 +") = " + f2.compose(g2).apply(x0));
    }
```
f3(x)=1−sin(x)1+2x2, g3(x)=cos(x), x∈ℝ
```java
private static void c3(){
        Function<Integer, Integer> f3 = x -> 1 - (int) Math.sin(x) + 2 * x * x;
        Function<Integer, Integer> g3 = x -> (int) Math.cos(x);

        int x0 = 3;
        System.out.println("(f3 . g3)(" + x0 +") = " + f3.compose(g3).apply(x0));
    }
```
Repeat the previous exercise using Function.andThen
```java
 private static void c1WithAndThen() {
        Function<Integer, Integer> f1 = x -> 2 * x;
        Function<Integer, Integer> g1 = x -> x * x;
        
        int x0 = 3;
        System.out.println("(g1 andThen f1)(" + x0 + ") = " + g1.andThen(f1).apply(x0));
    }
private static void c2WithAndThen() {
        Function<Integer, Integer> f2 = x -> (int) Math.sin(x);
        Function<Integer, Integer> g2 = x -> 1 - x + x * x;

        int x0 = 3;
        System.out.println("(g2 andThen f2)(" + x0 + ") = " + g2.andThen(f2).apply(x0));
        }
private static void c3WithAndThen() {
        Function<Integer, Integer> f3 = x -> 1 - (int) Math.sin(x) + 2 * x * x;
        Function<Integer, Integer> g3 = x -> (int) Math.cos(x);
        
        int x0 = 3;
        System.out.println("(g3 andThen f3)(" + x0 + ") = " + g3.andThen(f3).apply(x0));
        }
```

(optional) Write a function/method that composes a given list of functions

5) Dealing with optional data

Analyse the source code in package lst06_05

Exercises

Familiarize yourself with class Optional

Describe pros and cons of the following approaches to represent a "no-valid-result" of a function/method:

throwing an exception
- pros: Throwing an exception can make it very clear that something has gone wrong; Helps to diagnose the issue.
- cons: Throwing and catching exceptions can be expensive in terms of performance.

returning null
- pros: Returning null is a simple way to indicate that no valid result was available.
- cons: It's hard to figure out what a "null" really means, it could mean "no data" or "error"

using Optional
- pros: An Optional explicitly communicates that the return value might be absent. This makes the code more readable and intentions clearer.
- cons: Using Optional can introduce additional object allocation overhead, which might be a concern in performance-critical applications.

Write three variants of a method that returns the tail of a given list (see headOf_v1, headOf_v2, headOf_v3 in lst01_05)
```java
private static <E> List<E> tailOf_v1(List<E> list) {
    if (list == null || list.isEmpty()) throw new IllegalArgumentException("List must not be empty or null");
    return new ArrayList<>(list.subList(1, list.size()));
}
```
```java
private static <E> List<E> tailOf_v2(List<E> list) {
    if (list == null || list.size() <= 1) return null;
    return new ArrayList<>(list.subList(1, list.size()));
}
```
```java
private static <E> Optional<List<E>> tailOf_v3(List<E> list) {
    if (list == null || list.size() <= 1) return Optional.empty();
    return Optional.of(new ArrayList<>(list.subList(1, list.size())));
}
```
Review the code of proj1 and identify the methods that could have Optional as the return type