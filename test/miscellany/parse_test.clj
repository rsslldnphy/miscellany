(ns miscellany.parse-test
  (:require [expectations     :refer :all]
            [miscellany.parse :refer :all]))

;;;;;; parse-int ;;;;;;
;;;;;; a slightly more forving way of reading a string into an int

;; simple integer strings are parsed as you would expect
(expect 3 (parse-int "3"))

;; integers with a fractional part are truncated
(expect 3 (parse-int "3.9"))

;; integers with a fractional but no integer part are parsed as 0
(expect 0 (parse-int ".3"))

;; the dot '.' raises a NumberFormatException
(expect NumberFormatException (parse-int "."))

;; strings with non-numeric characters raise a NumberFormatException
(expect NumberFormatException (parse-int "3.h"))

;; trying to parse nil just returns nil
(expect nil (parse-int nil))

;; parsing an int returns the int
(expect 2 (parse-int 2))
