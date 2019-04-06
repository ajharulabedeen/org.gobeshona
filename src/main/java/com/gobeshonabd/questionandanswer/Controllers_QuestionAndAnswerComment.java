package com.gobeshonabd.questionandanswer;

import com.gobeshonabd.configs.StatusRequestSingleton;
import com.gobeshonabd.pojos.QuestionAndAnswerComment;
import com.gobeshonabd.pojos.QuestionAndAnswerComment_Insert;
import com.gobeshonabd.pojos.StatusRequest;
import com.gobeshonabd.questionandanswer.Services_QuestionAndAnswerComment_I;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controllers_QuestionAndAnswerComment
    {
        @Autowired
        private Services_QuestionAndAnswerComment_I services_QuestionAndAnswerComment_I ;
        
        StatusRequest statusRequest  = StatusRequestSingleton.getStatusRequest();
    
        @RequestMapping(value = "/postQuestionAndAnswerComment", method = RequestMethod.POST)
        public QuestionAndAnswerComment_Insert postQuestionAndAnswerComment( @RequestBody QuestionAndAnswerComment_Insert questionAndAnswerCommentToPost)
          {
            return services_QuestionAndAnswerComment_I.services_postQuestionAndAnswerComment(questionAndAnswerCommentToPost);
          }
        
        @RequestMapping(value = "/deleteQuestionAndAnswerComment", method = RequestMethod.DELETE)
        public StatusRequest deleteQuestionAndAnswerComment( @RequestBody QuestionAndAnswerComment_Insert questionAndAnswerCommentToDelete)
          {
            statusRequest.setOperationStatus(services_QuestionAndAnswerComment_I.services_deleteQuestionAndAnswerComment(questionAndAnswerCommentToDelete));
            return statusRequest;
          }
        
        @RequestMapping(value = "/updateQuestionAndAnswerComment", method = RequestMethod.PUT)
        public StatusRequest upgradeQuestionAndAnswerComment( @RequestBody QuestionAndAnswerComment_Insert questionAndAnswerCommentToUpgrade)
          {
            statusRequest.setOperationStatus(services_QuestionAndAnswerComment_I.services_upgradeQuestionAndAnswerComment(questionAndAnswerCommentToUpgrade));
            return statusRequest;
          }
    }
