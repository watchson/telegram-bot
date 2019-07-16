(ns telegram-bot.update_processor)

(defn -process-text [text]
  (case text
    "/workship" "Work Time Clocked"
    "I do not understand your primitive language human, try another prayer!!!"))

(defn process-message [update]
  (let [{{:keys [text] {:keys [id]} :chat} :message} update]
    {:method "sendMessage"
     :chat_id id
     :text (-process-text text)}))


