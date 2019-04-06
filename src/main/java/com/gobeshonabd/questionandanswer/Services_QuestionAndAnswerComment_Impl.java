
package com.gobeshonabd.questionandanswer;

import com.gobeshonabd.configs.GetDate;
import com.gobeshonabd.configs.SpringApplicationContextInterface;
import com.gobeshonabd.questionandanswer.DAO_QuestionAndAnswerComment_I;
import com.gobeshonabd.pojos.QuestionAndAnswerComment_Insert;

public class Services_QuestionAndAnswerComment_Impl 
        implements Services_QuestionAndAnswerComment_I, SpringApplicationContextInterface
    {

// Start Bean Area ******************** Injection    ******************************************
    private DAO_QuestionAndAnswerComment_I dao_QuestionAndAnswerComment_I;
    
    public DAO_QuestionAndAnswerComment_I getDao_QuestionAndAnswerComment_I()
      {
        return dao_QuestionAndAnswerComment_I;
      }
    public void setDao_QuestionAndAnswerComment_I(DAO_QuestionAndAnswerComment_I dao_QuestionAndAnswerComment_I)
      {
        this.dao_QuestionAndAnswerComment_I = dao_QuestionAndAnswerComment_I;
      }
    
//    DateUtil bean_dateUtil = (DateUtil) applicationContext.getBean("id_date");
    
// End Bean Area ******************** Injection    ******************************************
    
    public Services_QuestionAndAnswerComment_Impl()
      {
      }

    @Override
    public QuestionAndAnswerComment_Insert services_postQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentPost)
      {
        questionAndAnswerCommentPost.setQuestionCommentDate(GetDate.getDate());
        return  getDao_QuestionAndAnswerComment_I().dao_postQuestionAndAnswerComment(questionAndAnswerCommentPost);
      }

    @Override
    public String services_deleteQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentDelete)
      {
        return  getDao_QuestionAndAnswerComment_I().dao_deleteQuestionAndAnswerComment(questionAndAnswerCommentDelete);
      }

    @Override
    public String services_upgradeQuestionAndAnswerComment(QuestionAndAnswerComment_Insert questionAndAnswerCommentUpgrade)
      {
        return  getDao_QuestionAndAnswerComment_I().dao_upgradeQuestionAndAnswerComment(questionAndAnswerCommentUpgrade);
      }
    
    }
