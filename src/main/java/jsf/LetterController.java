package jsf;

import pdhs.qa.entity.Letter;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import sessionbeans.LetterFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import pdhs.qa.entity.LetterProcessMessurment;
import pdhs.qa.entity.LetterReason;
import pdhs.qa.entity.ProcessMessurment;

@Named("letterController")
@SessionScoped
public class LetterController implements Serializable {

    @EJB
    private sessionbeans.LetterFacade ejbFacade;
    private List<Letter> items = null;
    private Letter selected;

    LetterReason letterReason;

    public LetterReason getLetterReason() {
        if (letterReason == null) {
            letterReason = new LetterReason();
        }
        return letterReason;
    }

    public void addLetterReason() {
        System.out.println("adding letter reason");
        System.out.println("selected = " + selected);
        System.out.println("letterReason = " + letterReason);
        if (selected == null) {
            JsfUtil.addErrorMessage("Letter ?");
            return;
        }
        if (letterReason == null) {
            JsfUtil.addErrorMessage("Reason ?");
            return;
        }
        System.out.println("letterReason = " + letterReason);
        System.out.println("selected.getLetterReasons() = " + selected.getLetterReasons());
        selected.getLetterReasons().add(letterReason);
        letterReason.setLetter(selected);
        System.out.println("selected.getLetterReasons() = " + selected.getLetterReasons());
        letterReason = new LetterReason();
    }

    public void setLetterReason(LetterReason letterReason) {
        this.letterReason = letterReason;
    }

    public LetterController() {
    }

    public Letter getSelected() {
        return selected;
    }

    public void setSelected(Letter selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private LetterFacade getFacade() {
        return ejbFacade;
    }

    public Letter prepareCreate() {
        selected = new Letter();
        initializeEmbeddableKey();
        return selected;
    }

    public void addLetterProcessMeasurments() {
        if (selected == null) {
            JsfUtil.addErrorMessage("Letter ?");
            return;
        }
        List<LetterProcessMessurment> lmps = new ArrayList<>();
        if(selected.getProcess()==null){
            selected.setLetterProcessMessurment(lmps);
            return;
        }
        
        for(ProcessMessurment pm : selected.getProcess().getProcessMessurments()){
            LetterProcessMessurment lpm = new LetterProcessMessurment();
            lpm.setLetter(selected);
            lpm.setProcessMessurment(pm);
            lmps.add(lpm);
        }
        selected.setLetterProcessMessurment(lmps);
        
        
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("LetterCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("LetterUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("LetterDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Letter> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Letter getLetter(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Letter> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Letter> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Letter.class)
    public static class LetterControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LetterController controller = (LetterController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "letterController");
            return controller.getLetter(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Letter) {
                Letter o = (Letter) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Letter.class.getName()});
                return null;
            }
        }

    }

}
