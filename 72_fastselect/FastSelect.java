// Acid: Faiyaz Rafee, Yuki Feeng, Tasnim Chowdhury
// APCS pd8
// HW72 -- So So Fast
// 2022-03-08
// Time spent: 0.5 hours

/*
DISCO:
 -Running partitioner will make the C value sorted
 -Similar algo to BinarySearch. After each run, we shorten the array to either side of the C value to find yth smallest value.
 
QCC:
 -Is there a better method where teh complexity will be less then O(n^2) all the time
 
ALGO:
 1. Pivot point is the average value in the array. 
 2. All the values less then Pivot point are placed on the left side and all the values greater then Pivot point are placed on the right side.
 3. Check if Pivot point index == y-1
 4. If true, return pivot point.
 5. Otherwise, check if pivot point index is smaller or larger than the y-1
 6, If smaller, shorten the array by making the start pivot + 1.
 7. If larger, shorten the array by making the end pivot -1.
 8. Repeat all steps until step 4 is true.
 
 BEST CASE:
 The postion of the first pivot value after partitioning is y-1. O(n)
 
 WORST CASE:
 The last pivot value that can be partitioned is the one that is in the position y-1. O(n^2)
 */

 
