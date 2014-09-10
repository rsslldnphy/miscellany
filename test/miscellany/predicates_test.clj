(ns miscellany.predicates-test
  (:require [expectations          :refer :all]
            [miscellany.predicates :refer :all]))

(expect [4 5 6]
        (filter (is > 3) [1 2 3 4 5 6]))

(expect ["fish" "tarantula"]
        (filter (has count > 3) ["cat" "dog" "fish" "tarantula"]))
