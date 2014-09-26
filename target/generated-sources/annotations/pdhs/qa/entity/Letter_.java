package pdhs.qa.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pdhs.qa.entity.Branch;
import pdhs.qa.entity.Employee;
import pdhs.qa.entity.LetterProcessMessurment;
import pdhs.qa.entity.LetterReason;
import pdhs.qa.entity.Process;
import pdhs.qa.entity.Subject;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-24T14:44:48")
@StaticMetamodel(Letter.class)
public class Letter_ { 

    public static volatile SingularAttribute<Letter, Date> letter_date;
    public static volatile SingularAttribute<Letter, Date> forwarded_for_approval_at;
    public static volatile SingularAttribute<Letter, Process> process;
    public static volatile SingularAttribute<Letter, Date> completedAt;
    public static volatile SingularAttribute<Letter, Boolean> letter_delayed;
    public static volatile SingularAttribute<Letter, String> letter_No;
    public static volatile SingularAttribute<Letter, Subject> subject;
    public static volatile SingularAttribute<Letter, String> letter_contants;
    public static volatile ListAttribute<Letter, LetterProcessMessurment> letterProcessMessurment;
    public static volatile SingularAttribute<Letter, String> letter_remarks;
    public static volatile SingularAttribute<Letter, Employee> employee;
    public static volatile SingularAttribute<Letter, Branch> branch;
    public static volatile SingularAttribute<Letter, Employee> approved_by;
    public static volatile SingularAttribute<Letter, Date> approved_at;
    public static volatile SingularAttribute<Letter, String> remarks_for_delay;
    public static volatile SingularAttribute<Letter, Date> receive_At;
    public static volatile ListAttribute<Letter, LetterReason> letterReasons;
    public static volatile SingularAttribute<Letter, Long> id;
    public static volatile SingularAttribute<Letter, Date> posted_at;

}