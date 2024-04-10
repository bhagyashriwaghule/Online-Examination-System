package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.QuestionDao;
import com.tka.entity.Question;

@Service
public class QuestionService {
@Autowired
QuestionDao dao;

public List<Question>getAllQuestions(String subject){
	return dao.getAllQuestions(subject);
}
}
