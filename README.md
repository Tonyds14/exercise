Java program that simulate a card game with n players. 
In each round, the player with the highest card wins the round, and will get card of the losing players. 
In ranking of cards:
Diamond (higher than) hearts (higher than) spades (higher than) clubs.
Ace (higher than) king (higher than) queen.... two (as the lowest value card).

pile of cards per round to be pad in sequence from highest to lowest of the winning player.
e.g. ROUND: 1
Player 1 reveals: D-A 
Player 2 reveals: H-J
Player 3 reveals: S-8
Player 4 reveals: C-5
	Winning Card is D-A
	Round Winner is 1

 Sequence of cards to be pad to player #1 will be "D-A, H-J, S-8, C-5"
 
The player who gets all the cards of the deck in his hand wins. 

- String, Arrays, StringTokenizer, LinkedHashSet, Comparator, Collections

Mechanics:
1.	There are 52 cards on the deck. The card values in descending order are:  
•	suits: diamond, heart, spades, clubs
•	ranks: ace, king, queen, jack, ten, nine, eight, seven, six, five, four, three, two
2.	The initial deck will be given in a table in memory.
3.	Shuffling means cutting the card deck in half, then sequencing the cards from the half decks alternately to a new deck.  
4.	Distribute the cards to the players
5.	Each player plays the top card of his deck on each round.  
6.	The winner of the round is the player with the highest card. The winner gets the cards of the round and places them at the bottom of his deck. Note: winning card should be on top
7.	The winner of the game is the player that gets all the cards.  

Input: 
1.	The number of players for the game (via console)
2.	The number of times the deck will be shuffled before the game starts (via console)
3.	The table in memory that contains the initial deck of cards (derived from input text file)

Output:
1.	Display the content of the deck before the shuffle.
2.	Display the content of the deck after the shuffle but before the start of the game. 
3.	Display cards laid by players per round (round number included)
4.	Display the content of the deck of the winning player (for every round).

Initial card sequence: D-A,D-K,D-Q,D-J,D-10,D-9,D-8,D-7,D-6,D-5,D-4,D-3,D-2,H-A,H-K,H-Q,H-J,H-10,H-9,H-8,H-7,H-6,H-5,H-4,H-3,H-2,S-A,S-K,S-Q,S-J,S-10,S-9,S-8,S-7,S-6,S-5,S-4,S-3,S-2,C-A,C-K,C-Q,C-J,C-10,C-9,C-8,C-7,C-6,C-5,C-4,C-3,C-2

Note:
1. Error handling in user input, number of players and number of shuffles.
![NumPlayers_validation](https://github.com/user-attachments/assets/4739809f-fdcd-467f-a911-6f481210130e)
![NumShuffles_validation](https://github.com/user-attachments/assets/dd954ae2-f47b-4d29-872d-658f4d558210)

2. No error handling for the input.txt/deck. assumption is that it has 52 unique elements (in format of Suits+Ranks e.g. "D-A") and is separated by comma.
![input data format](https://github.com/user-attachments/assets/575045f3-369d-4c66-a16a-d1ccd9261c60)

3. Sample output of 4 players and 4 shuffles combination.
![Sample_Out_1of2](https://github.com/user-attachments/assets/3c7855f7-2c66-41d9-87e9-b0540d4d108d)
![Sample_Out_2of2](https://github.com/user-attachments/assets/7168bdee-b60e-4524-97d9-d873b12a6a8b)

[Sample_Output_dump_from_Console_4Plyrs_4Shffles.txt](https://github.com/user-attachments/files/18046114/Sample_Output_dump_from_Console_4Plyrs_4Shffles.txt)
Enter the number of players: 4
Enter the number of shuffles: 4

Initial Deck
D-A, D-K, D-Q, D-J, D-10, D-9, D-8, D-7, D-6, D-5, D-4, D-3, D-2, H-A, H-K, H-Q, H-J, H-10, H-9, H-8, H-7, H-6, H-5, H-4, H-3, H-2, S-A, S-K, S-Q, S-J, S-10, S-9, S-8, S-7, S-6, S-5, S-4, S-3, S-2, C-A, C-K, C-Q, C-J, C-10, C-9, C-8, C-7, C-6, C-5, C-4, C-3, C-2

Shuffled Cards
[D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4, C-A, D-10, H-7, S-4, D-K, H-10, S-7, C-4, H-K, S-10, C-7, D-3, S-K, C-10, D-6, H-3, C-K, D-9, H-6, S-3, D-Q, H-9, S-6, C-3, H-Q, S-9, C-6, D-2, S-Q, C-9, D-5, H-2, C-Q, D-8, H-5, S-2, D-J, H-8, S-5, C-2]

Cards Distributed by Players
Player 1: D-A, H-A, S-A, C-A, D-K, H-K, S-K, C-K, D-Q, H-Q, S-Q, C-Q, D-J, 
Player 2: H-J, S-J, C-J, D-10, H-10, S-10, C-10, D-9, H-9, S-9, C-9, D-8, H-8, 
Player 3: S-8, C-8, D-7, H-7, S-7, C-7, D-6, H-6, S-6, C-6, D-5, H-5, S-5, 
Player 4: C-5, D-4, H-4, S-4, C-4, D-3, H-3, S-3, C-3, D-2, H-2, S-2, C-2, 

ROUND: 1
Player 1 reveals: D-A Remaining Card Size: 12 Remaining Cards: H-A, S-A, C-A, D-K, H-K, S-K, C-K, D-Q, H-Q, S-Q, C-Q, D-J,
Player 2 reveals: H-J Remaining Card Size: 12 Remaining Cards: S-J, C-J, D-10, H-10, S-10, C-10, D-9, H-9, S-9, C-9, D-8, H-8,
Player 3 reveals: S-8 Remaining Card Size: 12 Remaining Cards: C-8, D-7, H-7, S-7, C-7, D-6, H-6, S-6, C-6, D-5, H-5, S-5,
Player 4 reveals: C-5 Remaining Card Size: 12 Remaining Cards: D-4, H-4, S-4, C-4, D-3, H-3, S-3, C-3, D-2, H-2, S-2, C-2,
	Winning Card is D-A
	Round Winner is 1

ROUND: 2
Player 1 reveals: H-A Remaining Card Size: 15 Remaining Cards: S-A, C-A, D-K, H-K, S-K, C-K, D-Q, H-Q, S-Q, C-Q, D-J, D-A, H-J, S-8, C-5,
Player 2 reveals: S-J Remaining Card Size: 11 Remaining Cards: C-J, D-10, H-10, S-10, C-10, D-9, H-9, S-9, C-9, D-8, H-8,
Player 3 reveals: C-8 Remaining Card Size: 11 Remaining Cards: D-7, H-7, S-7, C-7, D-6, H-6, S-6, C-6, D-5, H-5, S-5,
Player 4 reveals: D-4 Remaining Card Size: 11 Remaining Cards: H-4, S-4, C-4, D-3, H-3, S-3, C-3, D-2, H-2, S-2, C-2,
	Winning Card is H-A
	Round Winner is 1

ROUND: 3
Player 1 reveals: S-A Remaining Card Size: 18 Remaining Cards: C-A, D-K, H-K, S-K, C-K, D-Q, H-Q, S-Q, C-Q, D-J, D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4,
Player 2 reveals: C-J Remaining Card Size: 10 Remaining Cards: D-10, H-10, S-10, C-10, D-9, H-9, S-9, C-9, D-8, H-8,
Player 3 reveals: D-7 Remaining Card Size: 10 Remaining Cards: H-7, S-7, C-7, D-6, H-6, S-6, C-6, D-5, H-5, S-5,
Player 4 reveals: H-4 Remaining Card Size: 10 Remaining Cards: S-4, C-4, D-3, H-3, S-3, C-3, D-2, H-2, S-2, C-2,
	Winning Card is S-A
	Round Winner is 1

ROUND: 4
Player 1 reveals: C-A Remaining Card Size: 21 Remaining Cards: D-K, H-K, S-K, C-K, D-Q, H-Q, S-Q, C-Q, D-J, D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4,
Player 2 reveals: D-10 Remaining Card Size: 9 Remaining Cards: H-10, S-10, C-10, D-9, H-9, S-9, C-9, D-8, H-8,
Player 3 reveals: H-7 Remaining Card Size: 9 Remaining Cards: S-7, C-7, D-6, H-6, S-6, C-6, D-5, H-5, S-5,
Player 4 reveals: S-4 Remaining Card Size: 9 Remaining Cards: C-4, D-3, H-3, S-3, C-3, D-2, H-2, S-2, C-2,
	Winning Card is C-A
	Round Winner is 1

ROUND: 5
Player 1 reveals: D-K Remaining Card Size: 24 Remaining Cards: H-K, S-K, C-K, D-Q, H-Q, S-Q, C-Q, D-J, D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4, C-A, D-10, H-7, S-4,
Player 2 reveals: H-10 Remaining Card Size: 8 Remaining Cards: S-10, C-10, D-9, H-9, S-9, C-9, D-8, H-8,
Player 3 reveals: S-7 Remaining Card Size: 8 Remaining Cards: C-7, D-6, H-6, S-6, C-6, D-5, H-5, S-5,
Player 4 reveals: C-4 Remaining Card Size: 8 Remaining Cards: D-3, H-3, S-3, C-3, D-2, H-2, S-2, C-2,
	Winning Card is D-K
	Round Winner is 1

ROUND: 6
Player 1 reveals: H-K Remaining Card Size: 27 Remaining Cards: S-K, C-K, D-Q, H-Q, S-Q, C-Q, D-J, D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4, C-A, D-10, H-7, S-4, D-K, H-10, S-7, C-4,
Player 2 reveals: S-10 Remaining Card Size: 7 Remaining Cards: C-10, D-9, H-9, S-9, C-9, D-8, H-8,
Player 3 reveals: C-7 Remaining Card Size: 7 Remaining Cards: D-6, H-6, S-6, C-6, D-5, H-5, S-5,
Player 4 reveals: D-3 Remaining Card Size: 7 Remaining Cards: H-3, S-3, C-3, D-2, H-2, S-2, C-2,
	Winning Card is H-K
	Round Winner is 1

ROUND: 7
Player 1 reveals: S-K Remaining Card Size: 30 Remaining Cards: C-K, D-Q, H-Q, S-Q, C-Q, D-J, D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4, C-A, D-10, H-7, S-4, D-K, H-10, S-7, C-4, H-K, S-10, C-7, D-3,
Player 2 reveals: C-10 Remaining Card Size: 6 Remaining Cards: D-9, H-9, S-9, C-9, D-8, H-8,
Player 3 reveals: D-6 Remaining Card Size: 6 Remaining Cards: H-6, S-6, C-6, D-5, H-5, S-5,
Player 4 reveals: H-3 Remaining Card Size: 6 Remaining Cards: S-3, C-3, D-2, H-2, S-2, C-2,
	Winning Card is S-K
	Round Winner is 1

ROUND: 8
Player 1 reveals: C-K Remaining Card Size: 33 Remaining Cards: D-Q, H-Q, S-Q, C-Q, D-J, D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4, C-A, D-10, H-7, S-4, D-K, H-10, S-7, C-4, H-K, S-10, C-7, D-3, S-K, C-10, D-6, H-3,
Player 2 reveals: D-9 Remaining Card Size: 5 Remaining Cards: H-9, S-9, C-9, D-8, H-8,
Player 3 reveals: H-6 Remaining Card Size: 5 Remaining Cards: S-6, C-6, D-5, H-5, S-5,
Player 4 reveals: S-3 Remaining Card Size: 5 Remaining Cards: C-3, D-2, H-2, S-2, C-2,
	Winning Card is C-K
	Round Winner is 1

ROUND: 9
Player 1 reveals: D-Q Remaining Card Size: 36 Remaining Cards: H-Q, S-Q, C-Q, D-J, D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4, C-A, D-10, H-7, S-4, D-K, H-10, S-7, C-4, H-K, S-10, C-7, D-3, S-K, C-10, D-6, H-3, C-K, D-9, H-6, S-3,
Player 2 reveals: H-9 Remaining Card Size: 4 Remaining Cards: S-9, C-9, D-8, H-8,
Player 3 reveals: S-6 Remaining Card Size: 4 Remaining Cards: C-6, D-5, H-5, S-5,
Player 4 reveals: C-3 Remaining Card Size: 4 Remaining Cards: D-2, H-2, S-2, C-2,
	Winning Card is D-Q
	Round Winner is 1

ROUND: 10
Player 1 reveals: H-Q Remaining Card Size: 39 Remaining Cards: S-Q, C-Q, D-J, D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4, C-A, D-10, H-7, S-4, D-K, H-10, S-7, C-4, H-K, S-10, C-7, D-3, S-K, C-10, D-6, H-3, C-K, D-9, H-6, S-3, D-Q, H-9, S-6, C-3,
Player 2 reveals: S-9 Remaining Card Size: 3 Remaining Cards: C-9, D-8, H-8,
Player 3 reveals: C-6 Remaining Card Size: 3 Remaining Cards: D-5, H-5, S-5,
Player 4 reveals: D-2 Remaining Card Size: 3 Remaining Cards: H-2, S-2, C-2,
	Winning Card is H-Q
	Round Winner is 1

ROUND: 11
Player 1 reveals: S-Q Remaining Card Size: 42 Remaining Cards: C-Q, D-J, D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4, C-A, D-10, H-7, S-4, D-K, H-10, S-7, C-4, H-K, S-10, C-7, D-3, S-K, C-10, D-6, H-3, C-K, D-9, H-6, S-3, D-Q, H-9, S-6, C-3, H-Q, S-9, C-6, D-2,
Player 2 reveals: C-9 Remaining Card Size: 2 Remaining Cards: D-8, H-8,
Player 3 reveals: D-5 Remaining Card Size: 2 Remaining Cards: H-5, S-5,
Player 4 reveals: H-2 Remaining Card Size: 2 Remaining Cards: S-2, C-2,
	Winning Card is S-Q
	Round Winner is 1

ROUND: 12
Player 1 reveals: C-Q Remaining Card Size: 45 Remaining Cards: D-J, D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4, C-A, D-10, H-7, S-4, D-K, H-10, S-7, C-4, H-K, S-10, C-7, D-3, S-K, C-10, D-6, H-3, C-K, D-9, H-6, S-3, D-Q, H-9, S-6, C-3, H-Q, S-9, C-6, D-2, S-Q, C-9, D-5, H-2,
Player 2 reveals: D-8 Remaining Card Size: 1 Remaining Cards: H-8,
Player 3 reveals: H-5 Remaining Card Size: 1 Remaining Cards: S-5,
Player 4 reveals: S-2 Remaining Card Size: 1 Remaining Cards: C-2,
	Winning Card is C-Q
	Round Winner is 1

ROUND: 13
Player 1 reveals: D-J Remaining Card Size: 48 Remaining Cards: D-A, H-J, S-8, C-5, H-A, S-J, C-8, D-4, S-A, C-J, D-7, H-4, C-A, D-10, H-7, S-4, D-K, H-10, S-7, C-4, H-K, S-10, C-7, D-3, S-K, C-10, D-6, H-3, C-K, D-9, H-6, S-3, D-Q, H-9, S-6, C-3, H-Q, S-9, C-6, D-2, S-Q, C-9, D-5, H-2, C-Q, D-8, H-5, S-2,
Player 2 reveals: H-8 Remaining Card Size: 0 Remaining Cards: 
Player 3 reveals: S-5 Remaining Card Size: 0 Remaining Cards: 
Player 4 reveals: C-2 Remaining Card Size: 0 Remaining Cards: 
	Winning Card is D-J
	Round Winner is 1

Winner of the Game is Player: 1
GAME OVER


