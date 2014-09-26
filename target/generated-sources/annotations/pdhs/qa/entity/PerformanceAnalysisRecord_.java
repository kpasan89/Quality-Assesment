package pdhs.qa.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pdhs.qa.entity.Branch;
import pdhs.qa.entity.Employee;
import pdhs.qa.entity.Process;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-24T14:44:48")
@StaticMetamodel(PerformanceAnalysisRecord.class)
public class PerformanceAnalysisRecord_ { 

    public static volatile SingularAttribute<PerformanceAnalysisRecord, Process> process;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Long> delayed_count;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Date> toDate;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Long> analysisDate;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, String> causes_for_delay;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Employee> employee;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Long> completed_on_time_count;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Branch> branch;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Double> delayed_count_percentage;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Date> fromDate;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Double> completed_on_time_percentage;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Long> analysisYear;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Long> id;
    public static volatile SingularAttribute<PerformanceAnalysisRecord, Long> analysisMonth;

}