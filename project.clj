(defproject telegram-bot "0.1.0-SNAPSHOT"
  :description "Telegram Bot for Watchson"
  :plugins [[lein-cljfmt "0.6.4"]]
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/data.json "0.2.6"]
                 [com.amazonaws/aws-lambda-java-core "1.2.0"]
                 [com.amazonaws/aws-lambda-java-events "2.2.6"]]
  :main ^:skip-aot telegram-bot.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
