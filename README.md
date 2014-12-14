Problem description
=============

100 chairs are arranged in a circle.
These chairs are numbered sequentially from One to One Hundred.
At some point in time, the person in chair #1 will be told to leave the room.
The person in chair #2 will be skipped, and the person in chair #3 will be told to leave.
Next to go is person in chair #6. In other words, 1 person will be skipped initially, and then 2, 3, 4.. and so on.
This pattern of skipping will keep going around the circle until there is only one person remaining, the ``survivor``.
Note that the chair is removed when the person leaves the room.


Solution
==========

This program makes use of the Java BitSet class to represent each of the chairs as a sequence of bits.
If a chair is occupied by a person, then that bit is set, else it is not set.
Each set bit is traversed upon to skip some number of chairs in each iteration and get the chair number that must be removed.
The check wraps back to the beginning of the bit set once the end is reached, to perform this operation in a cirular manner.
