package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.controllers.valueobjects.ResponseModel;
import io.github.lucasduete.rhtapi.models.Employee;
import io.github.lucasduete.rhtapi.models.Question;
import io.github.lucasduete.rhtapi.models.Response;
import io.github.lucasduete.rhtapi.repositories.ResponseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ResponseService {

    private final ResponseRepository responseRepository;
    private final QuestionService questionService;
    private final EmployeeService employeeService;

    public ResponseService(ResponseRepository responseRepository, QuestionService questionService, EmployeeService employeeService) {
        this.responseRepository = responseRepository;
        this.questionService = questionService;
        this.employeeService = employeeService;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Response save(Response response, Question question) {

        question.addResponse(response);

        this.questionService.save(question);

        return response;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Response save(ResponseModel responseModel) {

        Employee employee = this.employeeService.findByEmail(responseModel.getEmailEmployee());

        Question question = this.questionService.getQuestion(responseModel.getIdQuestion());

        return this.save(
                new Response(null, responseModel.getContent(), employee, question), question
        );
    }

}
