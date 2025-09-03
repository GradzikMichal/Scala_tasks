/*
We have bit stream  0001 0010 1101 1101
N_exact = 8
Let say that left most bit have timestamp 0 and the right-most have timestamp 15

i |  Ti|  Bi
 1|  15|   1
 2|  13|   1
 3|  12|   2
 4|   9|   2
 1|   6|   4
Using equat
ion from Lecture I get:
N_dgim = 1/2 * 4 + 2 + 2 + 1 + 1 = 8

i |  Ti|  Bi
 1|  15|   1
 2|  13|   1
 3|  12|   2
 1|   9|   4
Using equation from Lecture I get:
N_dgim = 1/2 * 4 + 2 + 1 + 1 = 6

i |  Ti|  Bi
 1|  15|   1
 2|  13|   2
 3|  11|   2
 4|   8|   4
Using equation from Lecture I get:
N_dgim = 1/2 * 4 + 2 + 2 + 1  = 7

i |  Ti|  Bi
 1|  15|   1
 2|  13|   2
 3|  11|   4
 4|   3|   4
Using equation from Lecture I get:
N_dgim = 1/2 * 4 + 4 + 2 + 1  = 9

i |  Ti|  Bi
 1|  15|   1
 2|  13|   2
 3|  11|   4
 4|   3|   8
Using equation from Lecture I get:
N_dgim = 1/2 * 8 + 4 + 2 + 1  = 11
 */