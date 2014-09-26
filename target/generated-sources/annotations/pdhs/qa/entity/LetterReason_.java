package pdhs.qa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pdhs.qa.entity.Letter;
import pdhs.qa.entity.Reasons;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-24T14:44:48")
@StaticMetamodel(LetterReason.class)
public class LetterReason_ { 

    public static volatile SingularAttribute<LetterReason, Reasons> reasons;
    public static volatile SingularAttribute<LetterReason, Letter> letter;
    public static volatile SingularAttribute<LetterReason, Long> id;

}