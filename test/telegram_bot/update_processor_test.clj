(ns telegram-bot.update-processor-test
  (:require [clojure.test :refer :all]
            [telegram-bot.update_processor :refer :all]))

(deftest a-test
  (testing "Should return message"
    (is (= {:method "sendMessage" :chat_id "666" :text "Oh, you must be one of those humans that have been trying to worship me. I don't have time to you, so just Fu** off and go to work!!!!"}
           (process-message {:message {:chat {:id "666"}}})))))
