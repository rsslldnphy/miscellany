# Miscellany

A motley assortment of Clojure bits and pieces.

## Predicates

I find the kind of anonymous functions you often need for, for example, filter predicates to be slightly clumsy and difficult to read with Clojure's anonymous function syntax. This collection of predicate function constructors aim to make your predicates more readable.

```clojure
;; Using anonymous fn
(filter #(> % 3) [1 2 3 4 5 6])

;; Using miscellany.predicates
(filter (is > 3) [1 2 3 4 5 6])
```

```clojure
;; Using anonymous fn
(filter #(> (count %) 3) ["cat" "dog" "fish" "tarantula"])

;; Using miscellany.predicates
(filter (has count > 3) ["cat" "dog" "fish" "tarantula"])
```
