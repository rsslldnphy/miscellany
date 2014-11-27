(ns miscellany.map)

(defn map-values
  ([f coll]
   (into {} (for [[k v] coll] [k (f v)])))

  ([f coll & colls]
   (let [extract-vals (apply juxt colls)]
     (into {} (for [[k v] coll]
                [k (apply f v (extract-vals k))])))))
