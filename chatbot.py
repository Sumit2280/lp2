def chatbot():
    responses = {
        "hello": "Hello! How can I assist you today?",
        "how are you?": "I'm doing well, thank you! How about you?",
        "what is your name?": "My name is ChatBot. Nice to meet you!",
        "bye": "Goodbye! Have a great day!",
        "default": "I'm sorry, I didn't understand that. Can you please rephrase?"
    }

    while True:
        user_input = input("User: ").lower()

        if user_input in responses:
            print("ChatBot:", responses[user_input])
        else:
            print("ChatBot:", responses["default"])

        if user_input == "bye":
            break

if __name__ == "__main__":
    print("ChatBot: Hi! How can I assist you today?")
    chatbot()