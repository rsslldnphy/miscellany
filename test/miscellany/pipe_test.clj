(ns miscellany.pipe-test
  (:require [expectations :refer :all]
            [miscellany.pipe :refer :all]))

;; |> creates an anonymous function which threads-first
(expect 2
        (let [f (|> inc (/ 2))]
            (f 3)))

;; |>> creates an anonymous function which threads-last
(expect 1/2
        (let [f (|>> inc (/ 2))]
              (f 3)))
