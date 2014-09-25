(ns miscellany.maybe)

(defn maybe
  "Given a function f, returns a function that takes any number of arguments
  and calls f with those arguments, unless any of them are nil. If any of the
  arguments are nil, nil is returned."
  [f]
  (fn [& args] (when (not-any? nil? args) (apply f args))))
