### In a Medical Laboratory, you have 240 Injections, one of which is for Anesthesia for a rat. If Anesthesia injection is injected in a rat, it will faint in within 24 hours. You have 5 rats available to determine which one injection contains the Anesthesia. How do you achieve this in 48 hours ?

Clarifications:

1. If a rat faints, it cannot be used again.

2. If a rat receives the anesthesia injection, it can faint at any point in time within a 24-hour window (not necessarily exactly 24 hours from the injection time).

## Solution

[Solution Youtube Link](https://www.youtube.com/watch?v=3oFpncvCWnM)

Let us number the each injection with unique 5 digit numbers consisting of only 0, 1 and 2. Let us number the Rats as 1, 10, 100, 1000, 10000.

The action corresponding to the digit in the unit place will be executed by rat numbered 1. The action corresponding to the digit in the tenth place will be executed by rat numbered 10. The action corresponding to the digit in the 100th place will be executed by rat numbered 100. The action corresponding to the digit in the 1000th place will be executed by rat numbered 1000. The action corresponding to the digit in the 10000th place will be executed by rat numbered 10000.

Number 0 on an Injection represents that the injection will not be injected to rat.  
Number 1 on an Injection represents that the injection will be injected to rat on 1st day.  
Number 2 on an Injection represents that the injection will be injected to rat on 2nd day (after 24 hours).

Example: Let us say the Injection is numbered 11201. The Injections is injected on the first day to rat numbered 10000, 1000 and 1. It is injected on the second day to rat numbered 100. And it is not injected to rat numbered 10.

So if the rats numbered 10000, 1000 and 1 faint within first 24 hours, rat numbered 100 faints in the next 24 hours and the rat numbered 10 does not faint, then the Anesthesia Injection has to be 11201.

Total number of injections that can be tested in this way will be:

= 3 _ 3 _ 3 _ 3 _ 3 = 3^5 = 243 Injections  
So with the help of 5 rats and within 48 hours we will be able to find a Anesthesia Injection among 243 Injections.

Note – The language of this puzzle has been changed: rats from slaves, Anesthesia injection from poison, faint from death, etc.

Please write comments if you find anything incorrect, or you want to share more information about the topic discussed above.  

