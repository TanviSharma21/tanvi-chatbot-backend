package com.tanvi.studentchatbot.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Service
public class OpenAiService {

    @Value("${openai.api.key}")
    private String apiKey;

    public String getChatbotResponse(String userMessage) {
        try {
            // ✅ Using OpenRouter instead of OpenAI
            URL url = new URL("https://openrouter.ai/api/v1/chat/completions");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("HTTP-Referer", "http://localhost:8080"); // Required by OpenRouter
            conn.setRequestProperty("X-Title", "Student Chatbot");             // Your app name
            conn.setDoOutput(true);

            // ✅ Prepare message JSON
            JSONObject message = new JSONObject();
            message.put("role", "user");
            message.put("content", userMessage);

            JSONArray messages = new JSONArray();
            messages.put(message);

            // ✅ Prepare request body
            JSONObject requestBody = new JSONObject();
            requestBody.put("model", "mistralai/mistral-7b-instruct"); // Free model
            requestBody.put("messages", messages);

            // ✅ Send request
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = requestBody.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // ✅ Read response
            Scanner scanner = new Scanner(conn.getInputStream(), "utf-8");
            String jsonResponse = scanner.useDelimiter("\\A").next();
            scanner.close();

            // ✅ Parse response JSON
            JSONObject responseObj = new JSONObject(jsonResponse);
            JSONArray choices = responseObj.getJSONArray("choices");
            JSONObject firstChoice = choices.getJSONObject(0);
            JSONObject messageObj = firstChoice.getJSONObject("message");

            return messageObj.getString("content");

        } catch (Exception e) {
            e.printStackTrace();
            return "Something went wrong: " + e.getMessage();
        }
    }
}
