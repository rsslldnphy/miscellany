# Miscellany

A motley assortment of Clojure bits and pieces.

## Predicates

```clojure
(filter (is > 3) [1 2 3 4 5 6])
;; (4 5 6)
```

```clojure
(filter (has count > 3) ["cat" "dog" "fish" "tarantula"])
;; ("fish" "tarantula")
```
