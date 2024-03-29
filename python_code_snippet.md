# Code Snippet To Remember

### create two dimentional array
* [explaination](https://snakify.org/lessons/two_dimensional_lists_arrays/)
```
c = [[0] * n for i in xrange(m)]
```

### copy list
```
b = a[:]
```

### mimic stack
```
a = []
# push from right
a.append(b)

# pop from right
a.pop()
```

### queue
```
from collections import deque
numbers = deque()
# append right
numbers.append(1)
# left
numbers.popleft()
# right
numbers.pop()
```

### binary search in list
* https://github.com/python/cpython/blob/master/Lib/bisect.py
* https://research.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
** use ```lo + (hi - lo) / 2``` instead of ```(lo + hi) / 2``` to avoid overflow (in python it's fine though)
```
```

### sort list of tuples on the first element
```
sorted([('a', 1),('b', 2),('c', 3), ('d',4)], key=lambda x: x[0])
```

### quick sort
```
```

### use Counter
* see [here](https://docs.python.org/2/library/collections.html#collections.Counter)

### use defaultdict
* see [here](https://docs.python.org/2/library/collections.html#collections.defaultdict)

### use OrderedDict
* see [here](https://docs.python.org/3/library/collections.html#collections.OrderedDict)

### use zip
* see [here](https://www.programiz.com/python-programming/methods/built-in/zip)

### use bisect

# Lesser-known data structures and algorithms
* [binary indexed tree](https://cs.stackexchange.com/questions/10538/bit-what-is-the-intuition-behind-a-binary-indexed-tree-and-how-was-it-thought-a)
* [segment tree](https://cs.stackexchange.com/questions/14172/origins-of-the-segment-tree-data-structure)

# Resources
* [git book of solutions](https://soulmachine.gitbooks.io/algorithm-essentials/content/java/)
* [all leetcode solutions](http://www.cnblogs.com/grandyang/p/4606334.html)
* [python sortedcontainer](http://www.grantjenks.com/docs/sortedcontainers/index.html)
