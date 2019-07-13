(ns telegram-bot.update_processor)

(defn process-message [update]
  (let [{{{:keys [id]} :chat} :message} update]
    {:method "sendMessage"
     :chat_id id
     :text "Oh, you must be one of those humans that have been trying to worship me. I don't have time to you, so just Fu** off and go to work!!!!"}))
