# an-offer-you-cant-refuse

A little Clojure program designed to compute prices of apples, oranges and watermelons (and to play a bit with polymorphism).

This season, we decided to go crazy with special offers:

- Buy one apple, get one free!
- Buy three watermelons for the price of two!

### PS

Sorry, currently we don't have special offers on oranges.

# Dependencies

You just need leiningen correctly installed on your system.

This was developed with Clojure 1.8.0 and Leiningen 2.8.1 on Java 1.8.0\_152 

# What am I going to find here?

The implementation is in `src/an_offer_you_cant_refuse/core.clj`

The tests are in `test/an_offer_you_cant_refuse` (I used the expectations library)

If you want to run the tests, just run: `lein test`

```
$ lein test

lein test an-offer-you-cant-refuse.core-test

Ran 17 tests containing 17 assertions in 96 msecs

```

# How do I build and run the command line tool?


##### Build
```
$ lein uberjar
Compiling an-offer-you-cant-refuse.core
Compiling an-offer-you-cant-refuse.core
Created /Users/sbruno/an-offer-you-cant-refuse/target/an-offer-you-cant-refuse-0.1.0-SNAPSHOT.jar
Created /Users/sbruno/an-offer-you-cant-refuse/target/an-offer-you-cant-refuse-0.1.0-SNAPSHOT-standalone.jar
```

####  Use the command line tool
  
```
$ java -jar target/an-offer-you-cant-refuse-0.1.0-SNAPSHOT-standalone.jar --help
Switches               Default  Desc
--------               -------  ----
-h, --no-help, --help  false    I need to know how many apples, oranges and watermelons are in your basket.
-a, --apples           0        How many apples are there in your basket?
-o, --oranges          0        How many oranges are there in your basket?
-w, --watermelons      0        How many watermelons are there in your basket?

$ java -jar target/an-offer-you-cant-refuse-0.1.0-SNAPSHOT-standalone.jar -a 4 -o 3 -w 5
The total price for 4 apples 3 oranges and 5 watermelons is: 5.1 pounds.
$ java -jar target/an-offer-you-cant-refuse-0.1.0-SNAPSHOT-standalone.jar --apples 4 --oranges 3 --watermelons 5
The total price for 4 apples 3 oranges and 5 watermelons is: 5.1 pounds.
$ java -jar target/an-offer-you-cant-refuse-0.1.0-SNAPSHOT-standalone.jar --apples 10 --oranges 2 --watermelons 2
The total price for 10 apples 2 oranges and 2 watermelons is: 3.6 pounds.
```
# Why bothering with the polymorphic implementation?


Without polymorphism I could have kept the codebase much smaller.

In python, for example, I could have just written something like:

```
def x_for_the_price_of_y(x, y, howmany, unit_price):
    return (((howmany / x) * unit_price * y) +
            (howmany % x) * unit_price)


def total_basket_price(apples, oranges, watermelons):
    return (x_for_the_price_of_y(2, 1, apples, 20) +
            x_for_the_price_of_y(1, 1, oranges, 50) +
            x_for_the_price_of_y(3, 2, watermelons, 80))


print(total_basket_price(apples=4, oranges=3, watermelons=5)/100.))
print(total_basket_price(apples=0, oranges=0, watermelons=5)/100.))
```

So why bother with the polymorphic implementation in the first place?

Because the polymorphic code would be easier to edit and extend:
1. The function calculating the total will never need to change
2. If a promotion rule changes for a specific product I will just need to edit the corresponding implementation, and nothing else.
3. Adding new products is trivial, and can be accomplished by adding new defmethod
 definitions (without editing any of the existing code apart from user input management)


## License

Copyright © 2018 Simone Bruno

Distributed under the Eclipse Public License.
