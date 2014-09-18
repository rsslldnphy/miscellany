(ns miscellany.maybe)

(defn maybe
  "Given a function f, returns a function that takes a single argument
  and calls f with that argument unless it is nil. If the argument is nil,
  nil is returned."
  [f & args]
  (fn [x] (when x (apply f x args))))
