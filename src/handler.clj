(ns handler
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestHandler])
  (:import [com.amazonaws.services.lambda.runtime.events APIGatewayProxyResponseEvent])
  (:require [clojure.data.json :as json]))

(defn lambda-integration-response [^String msg ^long status-code]
  "Wraps message into lambda integration response object"
  (doto (new APIGatewayProxyResponseEvent)
    (.setStatusCode (int status-code))
    (.setHeaders {"Content-Type" "application/json"})
    (.setBody msg)))

(defn -handleRequest [this input context]
  (let [msg (json/write-str {:message (.get input "resource")})]
    (lambda-integration-response msg 200)))
