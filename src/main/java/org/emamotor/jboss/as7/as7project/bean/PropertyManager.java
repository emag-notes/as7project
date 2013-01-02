package org.emamotor.jboss.as7.as7project.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import org.emamotor.jboss.as7.as7project.ejb.SingletonBean;
import org.emamotor.jboss.as7.as7project.entity.Property;
import org.jboss.logging.Logger;

@Model
public class PropertyManager {

    private static final Logger LOGGER = Logger.getLogger(PropertyManager.class);

    @Inject
    SingletonBean ejb;
    
    List<Property> cacheList = new ArrayList<Property>();
    
    private String key;
    
    private String value;
    
    public void save(ActionEvent e){
        ejb.put(key, value);
    }
    
    public void clear(ActionEvent e){
        LOGGER.info("Called clear");
        ejb.delete();
    }
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public List<Property> getCacheList() {
        return ejb.getCache();
    }
    
}
