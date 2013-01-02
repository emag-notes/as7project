package org.emamotor.jboss.as7.as7project.client;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.emamotor.jboss.as7.as7project.ejb.SingletonBeanRemote;
import org.emamotor.jboss.as7.as7project.ejb.SingletonBeanRemoteImpl;
import org.emamotor.jboss.as7.as7project.entity.Property;
import org.jboss.logging.Logger;

public class RemoteEJBClient {

    public static final Logger LOGGER = Logger.getLogger(RemoteEJBClient.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        testRemoteEJB();
    }

    private static void testRemoteEJB() {

        final SingletonBeanRemote ejb = lookupEJB();
        // Adds an entry to the cache
        ejb.put("entry", "value");
        // Retrieves the cache entries and prints them
        List<Property> list = ejb.getCache();
        LOGGER.info(list);

    }

    private static SingletonBeanRemote lookupEJB() {

        final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.URL_PKG_PREFIXES,
                "org.jboss.ejb.client.naming");

        Context context = null;
        SingletonBeanRemote ejb = null;

        final String appName        = "";
        final String moduleName     = "as7project";
        final String distinctName   = "";
        final String beanName       = SingletonBeanRemoteImpl.class.getSimpleName();
        final String viewClassName  = SingletonBeanRemote.class.getName();

        final String lookupName =
                "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

        try {
            context = new InitialContext(jndiProperties);
            ejb = (SingletonBeanRemote) context.lookup(lookupName);
        } catch (NamingException e) {
            LOGGER.error("failed lookup", e);
        }

        return ejb;
    }

}
