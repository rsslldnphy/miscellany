# Miscellany

[![Build Status](https://travis-ci.org/rsslldnphy/miscellany.svg?branch=master)](https://travis-ci.org/rsslldnphy/miscellany)
[![Clojars Project](http://clojars.org/miscellany/latest-version.svg)](http://clojars.org/miscellany)

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

## miscellany.lifecycle

Easily add shutdown hooks to you application with `on-shutdown`, or if you'd rather avoid a macro and want to pass a fn, `add-shutdown-hook`.

```clojure
(on-shutdown
  (println "Bye bye."))
;; or
(add-shutdown-hook
  (fn [] (println "Bye bye.")))
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
