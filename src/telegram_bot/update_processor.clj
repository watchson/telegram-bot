(ns telegram-bot.update_processor)

(defn -process-text [text]
  (case text
    "/workship" "I have received your prayer human, and you shall be blessed with my powers!!!"
    "I do not understand your primitive language human, try another prayer!!!"))

(defn process-message [update]
  (let [{{:keys [text] {:keys [id]} :chat} :message} update]
    {:method "sendMessage"
     :chat_id id
     :text (-process-text text)}))


