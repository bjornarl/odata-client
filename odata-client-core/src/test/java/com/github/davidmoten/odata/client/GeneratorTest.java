package com.github.davidmoten.odata.client;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.oasisopen.odata.csdl.v4.TDataServices;
import org.oasisopen.odata.csdl.v4.TEdmx;

import microsoft.graph.generated.container.GraphService;

public class GeneratorTest {

    @Test
    public void testGenerateMsgraph() throws JAXBException {
        JAXBContext c = JAXBContext.newInstance(TDataServices.class);
        Unmarshaller unmarshaller = c.createUnmarshaller();
        TEdmx t = unmarshaller
                .unmarshal(
                        new StreamSource(GeneratorTest.class
                                .getResourceAsStream("/msgraph-1.0-20180905-formatted.xml")),
                        TEdmx.class)
                .getValue();
        Generator g = new Generator(new Options(), t.getDataServices().getSchema().get(0));
        g.generate();
    }

    public void testApi() {
        new GraphService().devices().id("1").registeredOwners().filter("blah").orderBy("field")
                .top(1000).get();
    }
}