(ns handler
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestHandler])
  (:import [com.amazonaws.services.lambda.runtime.events APIGatewayProxyResponseEvent]
           (java.util LinkedHashMap))
  (:require  [clojure.data.json :as json]
             [telegram-bot.update_processor :refer [process-message]]))

(defn lambda-integration-response [^String msg ^long status-code]
  (doto (new APIGatewayProxyResponseEvent)
    (.setStatusCode (int status-code))
    (.setHeaders {"Content-Type" "application/json"})
    (.setBody msg)))

(defn -handleRequest [this ^LinkedHashMap input context]
  (println (json/read-str (.get input "body")))
  (let [body-json (.get input "body")
        update (json/read-str body-json :key-fn keyword)]
    (lambda-integration-response
      (json/write-str (process-message update))
      200)))
