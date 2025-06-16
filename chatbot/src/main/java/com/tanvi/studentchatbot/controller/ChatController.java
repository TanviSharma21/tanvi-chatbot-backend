package com.tanvi.studentchatbot.controller;

import com.tanvi.studentchatbot.model.Student;
import com.tanvi.studentchatbot.repository.StudentRepository;
import com.tanvi.studentchatbot.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private OpenAiService openAiService;

    // ✅ Root API test endpoint
    @GetMapping("/")
    public String home() {
        return "✅ Student Chatbot API is up and running!";
    }

    // ✅ POST: Ask a question to AI and store response
    @PostMapping("/ask")
    public Student askQuestion(@RequestBody Student student) {
        String userMessage = student.getQuery();

        // Get AI-generated response
        String aiResponse = openAiService.getChatbotResponse(userMessage);

        // Save the response in the Student object
        student.setResponse(aiResponse);

        // Save the Q&A to MongoDB
        return studentRepository.save(student);
    }

    // ✅ GET: Fetch all saved Q&A from MongoDB
    @GetMapping("/all")
    public List<Student> getAllChats() {
        return studentRepository.findAll();
    }
}
