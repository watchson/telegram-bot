(ns handler
  (:gen-class
    :methods [^:static [handler [Object] String]]))

(defn -handler [s]
  (str "Hello" (.toString s) "!"))
