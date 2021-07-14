package prabhakar.core.services.impl;

import prabhakar.core.services.MultiService;
import org.osgi.service.component.annotations.Component;


@Component(service = MultiService.class,immediate = true)

public class MultiServiceBImpl implements MultiService{

    @Override
    public String getName() {
        return "MultiServiceBImpl";
    }
}
