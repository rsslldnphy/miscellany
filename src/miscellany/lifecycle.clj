(ns miscellany.lifecycle)

(defn add-shutdown-hook
  "Adds a shutdown hook which runs the supplied function."
  [f]
  (.addShutdownHook (java.lang.Runtime/getRuntime)
                    (Thread. ^Runnable f)))

(defmacro on-shutdown
  "Adds a shutdown hook which runs the supplied body."
  [& body]
  `(add-shutdown-hook (fn [] ~@body)))
