Rating_System
=============

Rating system for an online book market place - Design

An online system must respond quickly. The application is stored in a server. So time complexity is the important factor when developing an online system. Space complexity can be neglected. So I selected data structures and algorithm mainly considering about their time complexity.

This problem can be solved as follows:-

•	First read the inputs.
•	Use timestamp as the key.
•	Use three data structures to store users, books and venders.
•	A book has vender list, user list and rating list.
•	A vender has user list, book list and rating list.
•	If the input user already in the user list, user’s rating count increased by one (n).
•	If not create new user and set rating count to 1.
•	If the input book is not in the book list, create new book.
•	If the input vender is not in the vender list, create new vender.
•	Then add rating entries and other details of the rating to relevant book and to relevant vender.
•	Finally calculate aggregate ratings using stored details.

I have to use three data structures to store users, venders, books as list. These data structures must support efficient searching. Because for every input we have to search those three lists. So I plan to use hash tables with efficient hashing algorithm to increase searching speed.

When creating book and vender data types, I have to use data structures to store rating list. Pointer to the user who did the rating must be stored with the rating. In a vender, pointer to the rated book must be stored with the rating.  So I use three distinct linked-lists whose data stored according to timestamp order, to store rating list, user list and vender or book list. In order to calculate aggregate rating we have to access all elements in the list. We also have to give a list of top rated venders. The list isn’t sorted according to aggregate rating. So I have to search for maximum values and return them. For this the list must be accessed at random locations. In the other hand the rating list must be stored according to the timestamp order. So I wish to create linked- list to achieve these functionality.

