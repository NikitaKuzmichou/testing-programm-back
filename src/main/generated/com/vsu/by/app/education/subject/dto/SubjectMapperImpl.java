package com.vsu.by.app.education.subject.dto;

import com.vsu.by.app.education.subject.Subject;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public Subject fromSubjectDto(SubjectDto subjectDto) {
        if ( subjectDto == null ) {
            return null;
        }

        Subject subject = new Subject();

        subject.setId( subjectDto.getId() );
        subject.setName( subjectDto.getName() );

        return subject;
    }

    @Override
    public SubjectDto toSubjectDto(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDto subjectDto = new SubjectDto();

        subjectDto.setId( subject.getId() );
        subjectDto.setName( subject.getName() );

        return subjectDto;
    }

    @Override
    public List<SubjectDto> toSubjectDto(List<Subject> subjects) {
        if ( subjects == null ) {
            return null;
        }

        List<SubjectDto> list = new ArrayList<SubjectDto>( subjects.size() );
        for ( Subject subject : subjects ) {
            list.add( toSubjectDto( subject ) );
        }

        return list;
    }
}
