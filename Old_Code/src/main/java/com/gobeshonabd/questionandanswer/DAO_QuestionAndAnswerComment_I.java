
package com.gobeshonabd.questionandanswer;

import com.gobeshonabd.pojos.QuestionAndAnswerComment;
import com.gobeshonabd.pojos.QuestionAndAnswerComment_Insert;

public interface DAO_QuestionAndAnswerComment_I
    {
        QuestionAndAnswerComment_Insert dao_postQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentPost);
        String dao_deleteQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentDelete);
        String dao_upgradeQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentUpgrade);
    }
