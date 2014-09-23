/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pdhs.qa.entity.PerformanceAnalysisRecord;

/**
 *
 * @author root
 */
@Stateless
public class PerformanceAnalysisRecordFacade extends AbstractFacade<PerformanceAnalysisRecord> {
    @PersistenceContext(unitName = "pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PerformanceAnalysisRecordFacade() {
        super(PerformanceAnalysisRecord.class);
    }
    
}
