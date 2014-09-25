(ns miscellany.maybe-test
  (:require [expectations     :refer :all]
            [miscellany.maybe :refer :all]))

;; The function returned by "maybe" returns nil if it is passed nil
(expect nil ((maybe inc) nil))

;; Otherwise it calls the function it has been passed
(expect 3 ((maybe inc) 2))

;; If "maybe" is passed other arguments, the argument to the returned
;; is inserted before them in the function call
(expect 5 ((maybe /) 10 2))

;; If any of the arguments passed to the resulting functions are nil,
;; nil is returned.
(expect nil ((maybe /) nil 2))
(expect nil ((maybe /) 10 nil))
