package jsf;

import pdhs.qa.entity.LetterProcessMessurment;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import sessionbeans.LetterProcessMessurmentFacade;

import java.io.Serializable;
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

@Named("letterProcessMessurmentController")
@SessionScoped
public class LetterProcessMessurmentController implements Serializable {

    @EJB
    private sessionbeans.LetterProcessMessurmentFacade ejbFacade;
    private List<LetterProcessMessurment> items = null;
    private LetterProcessMessurment selected;

    public LetterProcessMessurmentController() {
    }

    public LetterProcessMessurment getSelected() {
        return selected;
    }

    public void setSelected(LetterProcessMessurment selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private LetterProcessMessurmentFacade getFacade() {
        return ejbFacade;
    }

    public LetterProcessMessurment prepareCreate() {
        selected = new LetterProcessMessurment();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("LetterProcessMessurmentCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("LetterProcessMessurmentUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("LetterProcessMessurmentDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<LetterProcessMessurment> getItems() {
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

    public LetterProcessMessurment getLetterProcessMessurment(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<LetterProcessMessurment> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<LetterProcessMessurment> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = LetterProcessMessurment.class)
    public static class LetterProcessMessurmentControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LetterProcessMessurmentController controller = (LetterProcessMessurmentController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "letterProcessMessurmentController");
            return controller.getLetterProcessMessurment(getKey(value));
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
            if (object instanceof LetterProcessMessurment) {
                LetterProcessMessurment o = (LetterProcessMessurment) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), LetterProcessMessurment.class.getName()});
                return null;
            }
        }

    }

}
