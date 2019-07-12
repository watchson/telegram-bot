(ns telegram-bot.core-test
  (:require [clojure.test :refer :all]
            [telegram-bot.core :refer :all]))

(deftest a-test
  (testing "Should return message"
    (is (= (process-message "Batata") "Hello Batata!"))))
