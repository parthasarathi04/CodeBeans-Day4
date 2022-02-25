# CodeBeans-Day4
Day 4 of 5 day Coding Challenge &lt;C{o}deBeans/> 1.0 by CoffeeBeans Consulting
# Colordle
The game begins with the code maker secretly selecting a code which is a sequence of 4 colours from a set of 8 colours (red, blue, green, yellow, violet, white, orange, pink). The aim of the game is that you have to guess the code that the codemaker picked within a specified number of guesses. 
For every guess you have, the codemaker will give you 2 indicator feedbacks on the correctness of your guess. Based on this feedback, you can better your next guess. 
First indicator from 1 to 4 indicates correct colours at correct positions.
Second indicator from 1 to 4 indicates correct colours but wrong positions.

For example, the code maker picked ( R G B Y ) as the code and you guessed ( W O G Y ) in the 1st turn. Since 2 colours are correct (G and Y),  one is in the right position and one is in the wrong position, in this turn, the codemaker would give feedback as 1,1. The game ends when you either successfully break the code or fail to guess the right code within the allowed number of guesses.
You win if your feedback is (4, 0).

# Input
The first line is n which is the number of guesses allowed. 
Second line is c which is a secret code selected by a code maker, 
Third line is g, your first guess.

Constraints : 

5 <= n <= 20
c and g comprises a combination of non-repeated letters [ R, G, B, Y, W, V, O, P ] of length 4.

**Inputs must follo the constraints**
# Requirements
Java 8+

# Run
```
javac Colordle.java
java Colordle
```
* then as mentioned in the input section

# Example 

Example 1
```
5
GRVW
GORP
(1,1)
GWOY
(1,1)
WYOG
(0,2)
GOBW
(2,0)
GRBW
(3,0)
You Lose!
```

Example 2
```
10
GRVW
GORP
(1,1)
GPOR
(1,1)
GROP
(2,0)
GRBV
(2,1)
GRVB
(3,0)
GRVY
(3,0)
GRVY
(3,0)
GRVW
(4,0)
You Win!
```
