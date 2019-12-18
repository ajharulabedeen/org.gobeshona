package com.gobeshonabd.questionandanswer;

import com.gobeshonabd.pojos.QuestionAndAnswerComment;
import com.gobeshonabd.pojos.QuestionAndAnswerComment_Insert;

public interface Services_QuestionAndAnswerComment_I
    {
        QuestionAndAnswerComment_Insert services_postQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentPost);
        String services_deleteQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentDelete);
        String services_upgradeQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentUpgrade);
    }
