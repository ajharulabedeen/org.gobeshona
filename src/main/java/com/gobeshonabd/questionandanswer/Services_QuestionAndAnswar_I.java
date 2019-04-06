package com.gobeshonabd.questionandanswer;

import com.gobeshonabd.pojos.QuestionAndAnswer;
import com.gobeshonabd.pojos.QuestionAndAnswer_Insert;
import com.gobeshonabd.pojos.QuestionAndAnswer_View_Summury;
import java.util.List;

public interface Services_QuestionAndAnswar_I
    {
        QuestionAndAnswer_Insert services_postQuestionAndAnswar( QuestionAndAnswer_Insert questionAndAnswerToInsert );
        String services_deleteQuestionAndAnswar( QuestionAndAnswer questionAndAnswerToDelete );
        String services_updateQuestionAndAnswar( QuestionAndAnswer questionAndAnswerToUpdate );
        List   services_getAllQuestionsBySubjectOnly();
        List services_getSpecificQuestionAndAnswerDetails(int questionAndAnswerID);
    }
