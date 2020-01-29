runtest:
	cargo test

build-bin:
	docker run --rm \
		-v ${PWD}:/code \
		-v ${HOME}/.cargo/registry:/root/.cargo/registry \
		-v ${HOME}/.cargo/git:/root/.cargo/git \
		softprops/lambda-rust

release: build-bin

package: release
	sam package  --output-template-file packaged.yaml --s3-bucket watchson-telegram-bot-deploy-bucket

deploy: package
	sam deploy --template-file packaged.yaml --stack-name watchson-telegram-bot --capabilities CAPABILITY_NAMED_IAM

setWebHook:
	curl -F "url=$(shell aws cloudformation describe-stacks --stack-name watchson-telegram-bot --query 'Stacks[0].Outputs[?OutputKey==`TelegramBotApi`].OutputValue' --output text)" \
	    https://api.telegram.org/bot${TELEGRAM_BOT_TOKEN}/setWebhook

deployBot: deploy setWebHook
