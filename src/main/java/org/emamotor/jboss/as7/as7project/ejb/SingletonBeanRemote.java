package org.emamotor.jboss.as7.as7project.ejb;

import java.util.List;

import org.emamotor.jboss.as7.as7project.entity.Property;

public interface SingletonBeanRemote {

    void delete();
    void put(String key, String value);
    List<Property> getCache();
    
}
