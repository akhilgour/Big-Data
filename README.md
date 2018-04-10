# Big-Data
Mini projects in Big Data

Directory cards_v1 contains a Hadoop Mapreduce program for counting the total number of numeric cards in a suit.
E.g. every deck of card contains 54 cards of which we are only interested in numeric cards, i.e. 2,3,4 etc.
We ignore the face cards and the joker card. Now we have 40 cards in total. We count the total number of these numeric cards in 
100 such decks of cards and sorting them according to the suits they belong to.

Directory cards_v2 contains another Hadoop Mapreduce program to sum/or add the value of numeric cards in a suit.
Every deck of card contains 54 cards of which we are only interested in numeric cards, i.e. 2,3,4 etc. We ignore the face cards
and the joker card. Now we have 40 cards in total. These cards are then sorted according to their suits and then, their values are
added to give us the sum of numeric cards in each suit.

Directory kMER is a java program to implement a KMER counter using Hadoop. Conceptually this is very similar to the word count
program, but since there are no spaces in the human genome, we counted the overlapping KMERS instead of discrete words.
