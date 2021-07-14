package prabhakar.core.services.impl;


import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prabhakar.core.services.MultiService;

@Component(service = MultiService.class,immediate = true,name = "serviceA")
public class MultiServiceAImpl implements MultiService{
    private static final Logger LOG= LoggerFactory.getLogger(MultiServiceAImpl.class);


    @Override
    public String getName() {
        return "MultiServiceAImpl";
    }


}
