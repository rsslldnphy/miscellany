(ns miscellany.collections
  (:require [miscellany.predicates :refer [present?]]))

(defn find-first
  "Return the first element of a collection that satisfies a predicate."
  [pred coll]
  (first (filter pred coll)))

(defn deep-merge
  "Deep-merge nested maps."
  [& vs]
  (if (every? map? vs)
    (apply merge-with deep-merge vs)
    (find-first present? vs)))

(defn assoc-result
  "Assocs the result of calling a function on a map into that map at the given key."
  [map k f]
  (assoc map k (f map)))
