(ns telegram-bot.update_processor)

(defn process-message [update]
  (let [{{:keys [text] {:keys [id]} :chat} :message} update]
    {:method "sendMessage"
     :chat_id id
     :text text}))
