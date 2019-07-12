runtest:
	lein test

build:
	lein uberjar

release: runtest build

package: release
	sam package  --output-template-file packaged.yaml --s3-bucket watchson-telegram-bot-deploy-bucket

deploy: package
	sam deploy --template-file packaged.yaml --stack-name watchson-telegram-bot --capabilities CAPABILITY_IAM
