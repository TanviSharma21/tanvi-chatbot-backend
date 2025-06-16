# 💡 Tanvi AI Chatbot – Backend (Spring Boot)

This is the backend for the **Tanvi Chatbot**, built using **Spring Boot**. It receives user messages via REST API, processes them (optionally using AI services), and returns intelligent responses to the frontend client.

---

## 🌐 Live API Endpoint

POST https://your-deployed-backend-url.com/api/chat/send


---

## 📦 Features

- 🧠 Accepts user messages and returns dynamic responses
- 🔗 RESTful API using Spring Boot
- ⚙️ Easy integration with any frontend
- 🛡️ CORS enabled for cross-origin requests

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- RestTemplate (for external API if needed)
- Maven

---

## 🧾 API Documentation

### 🔹 POST `/api/chat/send`

- **Description**: Accepts a message from the frontend and responds with AI-generated output or mock response.
- **Request Body**:

```json
{
  "message": "Hello"
}
Response Body:

json
Copy
Edit
{
  "response": "Hi there! How can I help you today?"
}
🗂️ Project Structure
css
Copy
Edit
tanvi-chatbot-backend/
└── src/
    └── main/
        ├── java/com/tanvi/studentchatbot/
        │   ├── ChatbotApplication.java
        │   ├── controller/
        │   │   └── ChatController.java
        │   └── model/
        │       └── ChatRequest.java
        │       └── ChatResponse.java
        │
        └── resources/
            └── application.properties
🔧 Local Setup
📥 Prerequisites
Java 17+

Maven

Eclipse or IntelliJ

🚀 Run Locally
bash
Copy
Edit
# In terminal or IDE
mvn clean install
mvn spring-boot:run
OR
Click Run > ChatbotApplication.java in Eclipse.

Make sure port 8080 is free.

🔄 Integration with Frontend
The React frontend sends user input to:

bash
Copy
Edit
POST http://localhost:8080/api/chat/send
In production, set your backend URL in .env of the frontend like:

env
Copy
Edit
NEXT_PUBLIC_BACKEND_URL=https://your-deployed-backend-url.com/api/chat/send
🔐 CORS Setup
To allow frontend requests, ensure the controller allows cross-origin:

java
Copy
Edit
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/chat")
public class ChatController {
   ...
}
🚀 Deployment Options
You can deploy the backend using:

☁️ Render

🚄 Railway

🌐 [Vercel + Backendless] (for testing only)

☁️ AWS EC2 (advanced)

🌍 Your own VPS or server

👩‍💻 Author
Tanvi Sharma
🔗 GitHub
🔗 LinkedIn

📄 License
MIT License © 2025 Tanvi Sharma
