(ns telegram-bot.watchson-api-client
  (:require [clj-http.client :as client]
            [clojure.data.json :as json])
  (:import (java.text SimpleDateFormat)))

(defn -to-epoch [time]
  (.getEpochSecond
   (.toInstant
    (.parse
     (SimpleDateFormat. "dd/MM/yyyy HH:mm") time))))

(defn add-time [user-id time]
  (let [body {:user_id user-id :registered_date (-to-epoch time) :is_holiday false :is_leave false}
        watchson-api-time-url (str (System/getenv "WATCHSON_API_URL") "/api/time")]
    (println (str "Adding time=" time " for user=" user-id " and body=" body))
    (client/put watchson-api-time-url
                {:body               (json/write-str body)
                 :content-type       :json
                 :socket-timeout     10000
                 :connection-timeout 10000
                 :accept             :json})))
