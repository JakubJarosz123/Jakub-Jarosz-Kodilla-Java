package com.kodilla.patterns2.observer.homework;

public interface HomeworkObservable {

    void registerObserver(HomeworkObserver homeworkObserver);
    void notifyObserver();
    void removeObserver(HomeworkObserver homeworkObserver);
}
