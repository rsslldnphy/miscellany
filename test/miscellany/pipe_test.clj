(ns miscellany.pipe-test
  (:require [expectations :refer :all]
            [miscellany.pipe :refer :all]))


;; |> creates an anonymous function which threads-first
(expect '("1" "3/2" "2")
        (map (|> inc (/ 2) str) [1 2 3]))

;; |>> creates an anonymous function which threads-last
(expect '("1" "2/3" "1/2")
        (map (|>> inc (/ 2) str) [1 2 3]))
