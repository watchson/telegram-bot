(ns telegram-bot.update_processor
  (:require [telegram-bot.watchson-api-client :refer [add-time]])
  (:import (java.util Date)
           (java.text SimpleDateFormat)))

(defn -now []
  (.format (SimpleDateFormat. "dd/MM/yyyy HH:mm") (new Date)))

(defn -process-text [user-id text]
  (case text
    "/workship" (do
                  (add-time user-id (-now))
                  "I have received your prayer human, and you shall be blessed with my powers!!!")
    "I do not understand your primitive language human, try another prayer!!!"))

(defn process-message [update]
  (let [{:keys [message]} update
        {:keys [text] {chat-id :id} :chat {user-id :id} :from} message]
    {:method "sendMessage"
     :chat_id chat-id
     :text (-process-text user-id text)}))
