package pdhs.qa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pdhs.qa.entity.Branch;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-17T15:31:47")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> password;
    public static volatile SingularAttribute<Employee, String> sinhala_name;
    public static volatile SingularAttribute<Employee, String> sinhala_description;
    public static volatile SingularAttribute<Employee, Boolean> active;
    public static volatile SingularAttribute<Employee, String> tamil_name;
    public static volatile SingularAttribute<Employee, Long> id;
    public static volatile SingularAttribute<Employee, String> english_description;
    public static volatile SingularAttribute<Employee, String> userName;
    public static volatile SingularAttribute<Employee, Branch> branch;
    public static volatile SingularAttribute<Employee, String> english_name;
    public static volatile SingularAttribute<Employee, String> tmail_description;

}