package com.londonappbrewery;

public class TrueFalse {
private int nQuestion;
private boolean answer;

public TrueFalse ( int question, boolean trueFalse){

    nQuestion = question;
    answer = trueFalse;

}

    public int getnQuestion() {
        return nQuestion;
    }

    public void setnQuestion(int nQuestion) {
        this.nQuestion = nQuestion;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
