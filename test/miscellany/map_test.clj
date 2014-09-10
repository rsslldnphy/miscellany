(ns miscellany.map-test
  (:require [expectations   :refer :all]
            [miscellany.map :refer :all]))

;; map-values maps a function over the values in a map
(expect {:a 2 :b 3 :c 4}
        (map-values inc {:a 1 :b 2 :c 3}))

;; if two maps are supplied, the function is called
;; taking all the matching items from each map as arguments
(expect {:a 11 :b 22 :c 33}
        (map-values + {:a 1 :b 2 :c 3} {:a 10 :b 20 :c 30}))
