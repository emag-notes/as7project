package org.emamotor.jboss.as7.as7project.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import org.emamotor.jboss.as7.as7project.entity.Property;

@Singleton
@Remote(SingletonBeanRemote.class)
public class SingletonBeanRemoteImpl implements SingletonBeanRemote {

    private List<Property> cache;
    
    @PostConstruct
    public void initCache() {
        this.cache = new ArrayList<Property>();
    }
    
    @Override
    public void put(String key, String value) {
        Property p = new Property();
        p.setKey(key);
        p.setValue(value);
        this.cache.add(p);
    }

    @Override
    public void delete() {
        this.cache.clear();
        
    }

    @Override
    public List<Property> getCache() {
        return this.cache;
    }

}
