package pdhs.qa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pdhs.qa.entity.Branch;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-17T15:31:47")
@StaticMetamodel(Process.class)
public class Process_ { 

    public static volatile SingularAttribute<Process, String> password;
    public static volatile SingularAttribute<Process, Boolean> active;
    public static volatile SingularAttribute<Process, String> sinhala_name;
    public static volatile SingularAttribute<Process, String> sinhala_description;
    public static volatile SingularAttribute<Process, String> process_number;
    public static volatile SingularAttribute<Process, String> tamil_name;
    public static volatile SingularAttribute<Process, String> english_description;
    public static volatile SingularAttribute<Process, Long> id;
    public static volatile SingularAttribute<Process, String> userName;
    public static volatile SingularAttribute<Process, Branch> branch;
    public static volatile SingularAttribute<Process, String> english_name;
    public static volatile SingularAttribute<Process, String> tmail_description;

}