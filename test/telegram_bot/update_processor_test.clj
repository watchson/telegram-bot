(ns telegram-bot.update-processor-test
  (:require [clojure.test :refer :all]
            [telegram-bot.update_processor :refer :all]))

(deftest a-test
  (testing "Should return message"
    (is (= {:method "sendMessage" :chat_id "666" :text "Hi"}
           (process-message {:message {:text "Hi" :chat {:id "666"}}})))))
