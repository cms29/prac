package prabhakar.core.models.impl;

import prabhakar.core.models.ServiceDemo;
import prabhakar.core.services.DemoService;
import prabhakar.core.services.DemoServiceB;
import prabhakar.core.services.MultiService;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;
@Model(adaptables = SlingHttpServletRequest.class,
adapters = ServiceDemo.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceDemoImpl  implements ServiceDemo {
    private static final Logger LOG= LoggerFactory.getLogger(ServiceDemoImpl.class);

    @OSGiService
    DemoService demoService;

    /*@Inject*/
    @OSGiService
    DemoServiceB demoServiceB;


    @Override
    public Iterator<Page> getPagesList(){
        return demoService.getPages();
    }

    @Override
    public List<String> getPageTitleList() {
        return demoServiceB.getPages();
    }
   
    @OSGiService(filter = "(component.name=serviceA)")
    MultiService multiService;

    @OSGiService(filter = "(component.name=prabhakar.core.services.impl.MultiServiceBImpl)")
    MultiService multiServiceB;

    @Override
    public String getNameFromService() {
        return multiService.getName();
    }

    @Override
    public String getNameFromServiceB() {
        return multiServiceB.getName();
    }
    @Override
    public String getNameWithReference() {
        return demoServiceB.getNameWithReference();
    }
    
}

