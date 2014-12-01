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

(defn applicator
  "Takes a variable number of arguments and returns a function that
  accepts a function, then applies that function to the arguments
  passed earlier."
  [& vs]
  (fn [f] (apply f vs)))

(defn either
  "Takes two or more predicates, and returns a predicate
  that returns true if any of them return true for its argument.

  Typical usage:
  (filter (either even? (is > 5)) [1 2 3 4 5 6 7 8])
  ;; => [2 4 5 6 7]"
  [& ps]
  (fn [v] (some (applicator v) ps)))

(def
  ^{:doc "Returns `true` if its argument is non-nil."}
  present?
  (complement nil?))
