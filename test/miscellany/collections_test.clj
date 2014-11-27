(ns miscellany.collections-test
  (:require [miscellany.collections :refer :all]
            [expectations           :refer :all]))

(expect 3
        (find-first odd? (range 2 10)))

(expect {:a {:b "cats" :c "dogs" :d "fish"}}
        (deep-merge {:a {:b "cats"}} {:a {:c "dogs"}} {:a {:d "fish"}}))

(expect {:a 4 :b 6 :sum 10}
        (assoc-result {:a 4 :b 6} :sum #(apply + (vals %))))
