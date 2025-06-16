package com.tanvi.studentchatbot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
    
    @Id
    private String id;
    private String name;
    private String query;       // Question from student
    private String response;    // Chatbot reply

    // Constructors
    public Student() {}

    public Student(String name, String query, String response) {
        this.name = name;
        this.query = query;
        this.response = response;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }

    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }
}
