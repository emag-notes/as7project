package org.emamotor.jboss.as7.as7project.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import org.emamotor.jboss.as7.as7project.entity.Property;

@Singleton
public class SingletonBean {

    private List<Property> cache;
    
    @PostConstruct
    public void initCache() {
        this.cache = new ArrayList<Property>();
    }
    
    public void put(String key, String value) {
        Property p = new Property();
        p.setKey(key);
        p.setValue(value);
        this.cache.add(p);
    }

    public void delete() {
        this.cache.clear();
        
    }

    public List<Property> getCache() {
        return this.cache;
    }

}
