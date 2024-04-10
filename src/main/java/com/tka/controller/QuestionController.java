package com.tka.controller;

import java.util.Collection;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Answer;
import com.tka.entity.Question;
import com.tka.service.QuestionService;

@RestController
@CrossOrigin("http://localhost:4200")
public class QuestionController {
	
@Autowired
QuestionService questionservice;

@RequestMapping("getAllQuestions/{subject}")
public List<Question> getAllQuestions(@PathVariable  String subject)
{
	List<Question> list=questionservice.getAllQuestions(subject);
	HttpSession httpSession=LoginController.httpSession;
	httpSession.setAttribute("allquestions", list);
	return list;
}

@RequestMapping("getFirstQuestion/{subject}")
public Question getFirstQuestion(@PathVariable String subject){
	List<Question> list=questionservice.getAllQuestions(subject);
	HttpSession httpSession=LoginController.httpSession;
	httpSession.setAttribute("allquestions", list);
	return list.get(0);
}
//
@RequestMapping("nextQuestion")
public Question nextQuestion() {
	HttpSession httpSession=LoginController.httpSession;
List<Question>list=(List<Question>) httpSession.getAttribute("allquestions");
Question question;
if((int)httpSession.getAttribute("questionIndex")<list.size()-1)
{
httpSession.setAttribute("questionIndex",(int)httpSession.getAttribute("questionIndex")+1);
 question=list.get((int)httpSession.getAttribute("questionIndex"));
 
}
else
{
	question=list.get(list.size()-1);
}
return question;
}
@RequestMapping("previousQuestion")
public Question previousQuestion() {
	HttpSession httpSession=LoginController.httpSession;
List<Question>list=(List<Question>) httpSession.getAttribute("allquestions");
Question question;
if((int)httpSession.getAttribute("questionIndex")>0)
{
httpSession.setAttribute("questionIndex",(int)httpSession.getAttribute("questionIndex")-1);
 question=list.get((int)httpSession.getAttribute("questionIndex"));
 
}
else
{
	question=list.get(0);
}
return question;
}
//{"qno":1,"qtext":"why","submittedAnswer":"A","originalAnswer":"A"}
@PostMapping("saveAnswer")
public void saveAnswer(@RequestBody Answer answer)
{
	System.out.println(answer);
	HttpSession httpSession=LoginController.httpSession;
	//add/update user response in HashMap
	if(answer.getSubmittedAnswer()!=null)
	{
		HashMap<Integer,Answer>hashMap=(HashMap<Integer,Answer>)httpSession.getAttribute("submittedDetails");
		hashMap.put(answer.getQno(),answer);
		System.out.println(hashMap);
	}
}
@GetMapping("getAllAnswers")
public  ResponseEntity<Collection<Answer>> getAllAnswers()
{
	HttpSession httpsession=LoginController.httpSession;
	
	HashMap<Integer,Answer>  hashMap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
	
	// Collection   values()

	Collection<Answer>   collection=hashMap.values();
	ResponseEntity<Collection<Answer>> rs=new ResponseEntity<>(collection,HttpStatus.OK);
	return rs;
}


@RequestMapping("endexam")
public ResponseEntity<Integer> endexam()
{
	
		HttpSession httpSession=LoginController.httpSession;
		try {
		HashMap<Integer,Answer>hashMap=(HashMap<Integer,Answer>)httpSession.getAttribute("submittedDetails");
		Collection<Answer>collection=hashMap.values();
		System.out.println("values() gives object of class whose name is "+collection.getClass().getName());
		//Collection collection=new Arraylist();
		for(Answer ans:collection)
		{
			if(ans.getSubmittedAnswer().equals(ans.getOriginalAnswer()))
			{
				httpSession.setAttribute("score",(int) httpSession.getAttribute("score")+1);
				
			}
		}
		Integer score=(Integer) httpSession.getAttribute("score");
		System.out.println("Total Score at Server"+score);
		httpSession.invalidate();// all attributes from HttpSession will be removed 
		ResponseEntity<Integer>responseEntity=new ResponseEntity<Integer>(score,HttpStatus.OK);
		return responseEntity;
		}
catch(Exception e)
{
	return null;
}

}
}
