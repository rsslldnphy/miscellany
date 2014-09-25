# Miscellany

[![Clojars Project](http://clojars.org/miscellany/latest-version.svg)](http://clojars.org/miscellany)


[![Build Status](https://travis-ci.org/rsslldnphy/miscellany.svg?branch=master)](https://travis-ci.org/rsslldnphy/miscellany)

A motley assortment of Clojure bits and pieces.

## miscellany.predicates

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

## miscellany.pipe

Nicks the `|>` operator from the likes of Elixir and F# for a macro very similar to the threading macro, except that it returns an anonymous function rather than applying the forms immediately. As such it is also similar to a version of `comp` that works from left to right - except that it is a macro that accepts a sequence of forms rather than just simply functions. There are thread-first and thread-last (or pipe-first and pipe-last, if you will) versions.

```clojure
(map (|>  inc (/ 2) str) [1 2 3]) ;; => ("1" "3/2" "2")
(map (|>> inc (/ 2) str) [1 2 3]) ;; => ("1" "2/3" "1/2")
```

## miscellany.lifecycle

Easily add shutdown hooks to you application with `on-shutdown`, or if you'd rather avoid a macro and want to pass a fn, `add-shutdown-hook`.

```clojure
(on-shutdown
  (println "Bye bye."))
;; or
(add-shutdown-hook
  (fn [] (println "Bye bye.")))
```

## miscellany.maybe

Make a function *optional*, i.e. return nil if any of the arguments it is passed are nil, rather than break.

```clojure
((maybe /) 10   2)  ;; => 5
((maybe /) nil  2)  ;; => nil
((maybe /) 10 nil)  ;; => nil
```

## miscellany.parse

Parse numeric strings as integers with a slightly more forgiving function than Java's Integer constructor.

```clojure
(parse-int   "3")  ;; => 3
(parse-int "3.9")  ;; => 3
(parse-int  ".9")  ;; => 0
(parse-int   nil)  ;; => nil
(parse-int "3.h")  ;; => throws NumberFormatException
```
