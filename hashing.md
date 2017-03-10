-hashing requires uniquess and randomness
-can have two separate types hashing to the same thing

polynomial accumulation:
-h(y) = y0 + y1x + y2x^2+y3x^3.... + ynx^an
horner's method:
-h(y) = y0 + x(y1+y2x^1+...ynx^n-1)
      = y0 + x(y1 + x(yx + ... ynx^n-2))

example:
y0 = h(bar)

-prime number must be above 13 
-capacity of a hash table must be prime
-if primitive call static method
-if two objects are equal, their hashcodes must be equal
-strings are immutable, concatenation creates a new string every time

-hashtable is a glorified array


-first step is to make the hashcode function
-then you make the compression function
--need this bc hash function outputs huge numbers
--simple compression fn is c(h) = h mod N where N = size of the array

EX:
say there's a hash table of size 7 with character values a b c 
hashcodes: a = 4, b = 11, c = 40;
using the compression function h mod N,
we start placing stuff in by doing h mod 7 but see two things map to 4
so at 4, we create a linked list that chains all the elements at that index together (this is collision solution by chaining)
want to avoid making this list huge... voids the lookup feature of the hashtable
if we reach max capacity, rehash using the next prime for the mod segment

load factor: measure of how full the table is allowed to get before being automatically increased
-always be underload rather than overlaod
if n = 8, N = 18, and lambda = 0.4
lambda = n/ N 
N = n/lambda

open hashing -> linear probing
objects that hash to the same hashcode are now just shifted one over if the current hash is full
a "marked" state exists now ------> go learn about this again by yourself bc u got distracted niceeee
//never hash marked value (tip for lab5)
- scenario to show what it is:
add a at hash 4, try to add b at hash 4 but its full so its added at hash 5
now we delete a
recall that b still maps to 4, but it cant show null or else the hash will return unsuccessful
so 4 has to hold a placeholder, or a "marker", to indicate that the table must be probed to retrieve the element we want

class Foo{
    int bar;
    double baz;
}

public int hashCode(){
int out = Integer.hashCode(bar);
out = 31 * out + double.hashCode(baz);
return out;
}


