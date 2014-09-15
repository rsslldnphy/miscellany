(ns miscellany.pipe)

(defmacro |>
  "Returns an anonymous function which takes a single argument,
  and pipes it through each of the forms in turn. Similar to
  the threading macro except a function is returned rather than
  a set of forms being immediately applied. Similar to comp,
  except functions are applied in left-to-right order for easier
  readability, and s-expressions can be used as well as functions.
  Where s-expressions are used in place of plain functions, the
  threaded value is added as the first argument - much as in ->.

  See also |>>."
  [& forms]
  `(fn [x#] (-> x# ~@forms)))

(defmacro |>>
  "Returns an anonymous function which takes a single argument,
  and pipes it through each of the forms in turn. Similar to
  the threading macro except a function is returned rather than
  a set of forms being immediately applied. Similar to comp,
  except functions are applied in left-to-right order for easier
  readability, and s-expressions can be used as well as functions.
  Where s-expressions are used in place of plain functions, the
  threaded value is added as the last argument - much as in ->>.

  See also |>."
  [& forms]
  `(fn [x#] (->> x# ~@forms)))
