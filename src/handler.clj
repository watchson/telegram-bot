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
  (let [msg (json/write-str {:message (str (.get input "resource") "dawson") })]
    (lambda-integration-response msg 200)))
