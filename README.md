## Read Me Graph Implementation ##

This is a graph implementation using an Adjacency List that maps Vertices (keys) to their edges.  A created a Vertex and Edge class that I used to store information like weights and names of such objects.

#### Creating a Real World Graph ####

I decided to use a data set I found on KONECT (the Koblenz Network Collection) which “is a project to collect large network datasets of all types in order to perform research in network science and related fields, collected by the Institute of Web Science and Technologies at the University of Koblenz–Landau.”  A link to the data set is here: http://konect.uni-koblenz.de/networks/moreno_oz

The data set shows the relationships between 217 residents living in an Australian National University campus.  A vertex represents a person and the edge cost is the familiarity between them, as stated by the data collector, “friendships are weighted as follows from strongest to weakest tie:  5 (best friend), 4 (close friend), 3 (friend), 2, 1.”  So a path between two vertices in the data shows a relationship and the edge cost is the familiarity.  I look at adjacent vertices in MyClient.java and find ‘people’ with a lot of friends and then look at the weights between the relationships, I even find the average ranking for the person with most friends which is 2.54 meaning they are less than a friend.  Working with this data required parsing it, and cleaning it up to be in the right format to add to my graph.
