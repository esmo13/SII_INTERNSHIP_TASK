package Services;

import Repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    @Autowired
    LessonService(LessonRepository lessonRepository){
        this.lessonRepository=lessonRepository;
    }
}
