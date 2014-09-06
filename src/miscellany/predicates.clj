(ns miscellany.predicates)

(defn is
  "Returns an anonymous function that takes one argument
  and passes it as the first argument to the supplied
  predicate function, along with any other arguments specified.

  Typical usage:
  (filter (is > 3) [1 2 3 4 5 6])
  ;; => [4 5 6]"
  [pred & args]
  (fn [x] (apply pred x args)))

(defn has
  "Returns an anonymous function that takes one argument, calls
  the supplied function on it, and passes the result as the first
  argument to the supplied predicate function, along with any
  other arguments specified.

  Typical usage:
  (filter (has count > 3) [\"cat\" \"dog\" \"fish\" \"tarantula\"])
  ;; => [\"fish\" \"tarantula\"]"
  [f pred & args]
  (fn [x] (apply pred (f x) args)))
