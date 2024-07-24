package langhua.activemq.embed;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.security.AuthenticationUser;
import org.apache.activemq.security.SimpleAuthenticationPlugin;
import org.apache.ofbiz.base.util.FileUtil;
import org.apache.ofbiz.base.util.UtilProperties;

import java.io.File;
import java.util.ArrayList;

public class SandBrokerService {
    private static final String MODULE = SandBrokerService.class.getName();
    private static final String BROKER_NAME = UtilProperties.getPropertyValue("sand-activemq", "sand.activemq.broker.name", "SandActiveMQ");
    private static final String SAND_ACTIVEMQ_ROOT = UtilProperties.getPropertyValue("sand-activemq", "sand.activemq.root", "runtime/activemq");
    private static final String BROKER_URL = UtilProperties.getPropertyValue("sand-activemq", "sand.activemq.broker.url", "tcp://localhost:61616");

    public void start() throws Exception {
        BrokerService broker = new BrokerService();
        broker.setBrokerName(BROKER_NAME);
        SimpleAuthenticationPlugin sap = new SimpleAuthenticationPlugin();
        AuthenticationUser au = new AuthenticationUser("admin", "admin","users");
        ArrayList<AuthenticationUser> aul = new ArrayList<AuthenticationUser>();
        aul.add(au);
        sap.setUsers(aul);
        sap.setAnonymousAccessAllowed(false);
        broker.setPlugins(new BrokerPlugin[] { sap });
        File dataPath = FileUtil.getFile(SAND_ACTIVEMQ_ROOT);
        broker.getPersistenceAdapter().setDirectory(dataPath);
        broker.addConnector(BROKER_URL);
        broker.start();
    }
}
