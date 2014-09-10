(ns miscellany.lifecycle-test
  (:require [miscellany.lifecycle :refer :all]))

;; This isn't a test as such, but will hopefully break if the code
;; breaks, giving some indication that something is wrong.
(on-shutdown
  (println "miscellany.lifecycle/on-shutdown appears to work."))
