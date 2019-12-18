package com.gobeshonabd.questionandanswer;

import com.gobeshonabd.pojos.QuestionAndAnswer;
import com.gobeshonabd.pojos.QuestionAndAnswer_Insert;
import com.gobeshonabd.pojos.QuestionAndAnswer_View_Summury;
import java.util.List;

public interface DAO_QuestionAndAnswar_I
    {
//        String dao_postQuestionAndAnswar( QuestionAndAnswer_Insert questionAndAnswerToInsert );
        QuestionAndAnswer_Insert dao_postQuestionAndAnswar( QuestionAndAnswer_Insert questionAndAnswerToInsert );
        String dao_deleteQuestionAndAnswar( QuestionAndAnswer questionAndAnswerToDelete );
        String dao_updateQuestionAndAnswar( QuestionAndAnswer questionAndAnswerToUpdate );
        List   dao_getAllQuestionsBySubjectOnly();
        List dao_getSpecificQuestionAndAnswerDetails(int questionAndAnswerID);
    }
