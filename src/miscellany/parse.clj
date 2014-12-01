(ns miscellany.parse)

(defn parse-int
  "Parses a numeric string into an int.
  This function is a bit more forgiving than the java Integer constructor.

  Simple integers are parsed as you would expect: \"3\" => 3.
  Integers with a fractional part are truncated: \"3.6\" => 3.
  Numbers with a fractional but no integer part are parsed as 0: \".4\" => 0.
  If the string is nil, nil is returned.
  Any other format raises a NumberFormatException."
  [s]
  (if (string? s)
    (condp re-matches s
      #"(\d+)\.?\d*" :>> (fn [[_ m]] (Integer. m))
      #"\.\d+"       :>> (constantly 0)
      (throw (NumberFormatException. (str s " is not a valid number."))))
    s))
