(ns handler
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestHandler])
  (:import [com.amazonaws.services.lambda.runtime.events APIGatewayProxyResponseEvent])
  (:require [clojure.data.json :as json]))

(defn lambda-integration-response [^String msg ^long status-code]
  (doto (new APIGatewayProxyResponseEvent)
    (.setStatusCode (int status-code))
    (.setHeaders {"Content-Type" "application/json"})
    (.setBody msg)))

(defn -handleRequest [this input context]
  (println (json/read-str (.get input "body")))
  (let [body-json (.get input "body")
        body (json/read-str body-json :key-fn keyword)
        {{{:keys [id]} :chat} :message} body
        msg (json/write-str {:method "sendMessage" :chat_id id :text "Oh, you must be one of those humans that have been trying to worship me. I don't have time to you, so just Fu** off and go to work!!!!"})]
    (lambda-integration-response msg 200)))
