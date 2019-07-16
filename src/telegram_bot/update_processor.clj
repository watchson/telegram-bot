(ns telegram-bot.update_processor)

(defn -process-text [text]
  (case text
    "/workship" "Work Time Clocked"
    text))

(defn process-message [update]
  (let [{{:keys [text] {:keys [id]} :chat} :message} update]
    {:method "sendMessage"
     :chat_id id
     :text (-process-text text)}))


