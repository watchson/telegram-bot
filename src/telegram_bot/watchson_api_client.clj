(ns telegram-bot.watchson-api-client
  (:require [clj-http.client :as client]))

(defn add-time [user-id time]
  (println (str "Adding time=" time " for user=" user-id)))
